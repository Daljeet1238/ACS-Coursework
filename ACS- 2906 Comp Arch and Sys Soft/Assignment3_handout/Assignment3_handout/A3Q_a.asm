;-------------------------------------------------------------------------------------------------------------------------------------------------------
; ACS-2906-001
; Daljeet Singh
; Student ID: 3169763
; Assignment 3
;-------------------------------------------------------------------------------------------------------------------------------------------------------
data	segment							; data segment. Keyword db means define byte. You can also define word (dw)
		iNum	db  225					;Define input number
		input db 17, 18, 17 dup('$'), 10, 13 ; Input buffer for 16-bit binary number
		msg1 db 'Enter a 16-bit binary number: $'
		msg2 db 'The decimal unsigned integer equivalent is $'
		value dw 0


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

	; Prompt the User
	lea dx, msg1
	mov ah, 09h
	int 21h

	; Get Buffered Input
	lea dx, input
	mov ah, 0Ah
	int 21h

	; Convert Binary String to Signed Integer
	mov bx, 0
	mov cx, 0

	mov cl, [input+1]		; number of characters entered
	cmp cl, 0
	je PrintUnsignedResult	; If no input, skip conversion

	lea si, input+2			; point to first character

ConvertUnsignedLoop:
	mov al, [si]
	sub al, 30h             ; Convert ASCII 

	shl bx, 1              	; Shift left to make room for next bit
	or  bl, al        		; Add the new bit

	inc si                  
	loop ConvertUnsignedLoop        

	mov value, bx          ; Store result in variable

PrintUnsignedResult:
	; Print Result Message
	lea dx, msg2
	mov ah, 09h
	int 21h

	;print unsigned decimal value
	mov ax, bx				; Load signed integer into ax
	mov cx, 0
	mov bx, 10

DivideLoop:
	xor dx, dx			; Clear dx before division
	div bx
	push dx				; save remainder
	inc cx
	cmp ax, 0
	jne DivideLoop

PrintLoop:
	pop dx
	add dl, 30h
	mov ah, 02h
	int 21h
	loop PrintLoop						

;-------------------------------------------------------------------------------------------------------------------------------------------------------										
		mov ah, 4ch 					;Set up code to specify return to dos
        int 21h							;Interpt number 21 (Return control to dos prompt)

code    ends

end     start
;-------------------------------------------------------------------------------------------------------------------------------------------------------



