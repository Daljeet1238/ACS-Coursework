;-------------------------------------------------------------------------------------------------------------------------------------------------------
; ACS-2906-001
; Daljeet Singh
; Student ID: 3169763
; Assignment 3
;-------------------------------------------------------------------------------------------------------------------------------------------------------
data	segment							; data segment. Keyword db means define byte. You can also define word (dw)
		iNum	db  225					;Define input number (not used, but kept)

		msg1 db 'Enter a 16-bit binary number: $'
		msg2 db 'The decimal unsigned integer equivalent is $'

		errmsg1 db 'Error! Please enter exactly 16 bits.$'
		errmsg2 db 'Error! Illegal characters detected. Please enter a 16-bit binary number.$'

        ; Buffered input structure: max length, actual length, buffer bytes
        input db 18, 0, 18 dup(?)       ; max 18 chars, actual count, then data
data	ends

										; stack segment
stack1  segment	stack 		
		db	100 dup(?)      			; This is the stack of 100 bytes
stack1  ends


code    segment
        assume  cs:code, ds:data, ss:stack1

start: 
										;Perform initialization 
		mov ax, data					;Put the starting address of the data segment into the ax register (must do this first)
		mov ds, ax						;Put the starting address of the data segment into the ds register (where it belongs)
		
		mov ax, stack1					;Put the starting address of the stack into the ax register (must do this first)
		mov ss, ax						;Put the starting address of the stack segment into the ss register (where it belongs)
;-------------------------------------------------------------------------------------------------------------------------------------------------------
;****************** Perform your code here ******************

GetInput:
	; Prompt the user
	lea dx, msg1
	mov ah, 09h
	int 21h

	; Get buffered input
	lea dx, input
	mov ah, 0Ah
	int 21h

	mov al, [input+1]           ; actual number of characters entered
	cmp al, 16
	jne InvalidLength

	mov cx, 16
	lea si, [input+2]           ; first character of input

CheckChars:
	mov al, [si]
	cmp al, '0'
	je ValidChar
	cmp al, '1'
	je ValidChar

	; anything else is illegal
	jmp InvalidChar

ValidChar:
	inc si
	loop CheckChars
	jmp ConvertUnsigned         ; all characters are valid


;----------------- Error handlers --------------------------------------

InvalidLength:
	lea dx, errmsg1
	mov ah, 09h
	int 21h
	jmp GetInput

InvalidChar:
	lea dx, errmsg2
	mov ah, 09h
	int 21h
	jmp GetInput


;----------------- Conversion: 16-bit binary -> unsigned integer --------

ConvertUnsigned:
	xor bx, bx                  ; will hold the numeric value
	mov cx, 16
	lea si, [input+2]

BuildNumber:
	shl bx, 1                   ; shift left to make room for next bit

	mov al, [si]                ; get next character
	sub al, '0'                 ; convert '0'/'1' -> 0/1
	or  bl, al                  ; set lowest bit

	inc si
	loop BuildNumber

	; BX now contains the unsigned value
	mov ax, bx                  ; copy to AX for printing

	; Print label text
	lea dx, msg2
	mov ah, 09h
	int 21h

	;----------------- Print AX as unsigned decimal ---------------------

PrintNumber:
	lea dx, msg2
    mov ah, 09h
    int 21h

    mov ax, bx          ; AX = signed value

    ; check if negative
    cmp ax, 0
    jge PrintDecimal

    ; print minus sign
    mov dl, '-'
    mov ah, 02h
    int 21h


PrintDecimal:
    cmp ax, 0
    jne NotZero

    mov dl, '0'
    mov ah, 02h
    int 21h
    jmp DonePrint


NotZero:
	xor cx, cx                  ; digit count = 0
	mov bx, 10                  ; divisor = 10

DivLoop:
	xor dx, dx                  ; clear high word for division
	div bx                      ; AX / 10 -> AX = quotient, DX = remainder
	push dx                     ; save remainder (digit)
	inc cx                      ; increment digit count
	cmp ax, 0
	jne DivLoop

; Now print digits in reverse (from stack)
Print:
	pop dx
	add dl, '0'                 ; convert 0–9 to '0'–'9'
	mov ah, 02h
	int 21h
	loop Print

DonePrint:

;-------------------------------------------------------------------------------------------------------------------------------------------------------										
		mov ah, 4ch 					;Set up code to specify return to dos
        int 21h							;Interrupt number 21 (Return control to DOS prompt)

code    ends

end     start
;-------------------------------------------------------------------------------------------------------------------------------------------------------
