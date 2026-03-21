;--------------------------------------------------------------------------------------
; ACS-2906-001
; Daljeet Singh
; Student ID: 3169763
; Lab 7
;--------------------------------------------------------------------------------------
;.186 You may need to uncomment this to get some of the instructions working (e.g. shl, dest, count)
;--------------------------------------------------------------------------------------
data	segment						; data segment. Keyword db means define byte. You can also define word (dw)
        msg1	db 'Enter a String :', 13, 10, '$'				;Define message for first variable
        msg2   db 'The reversed String is :', 13, 10,'$'
        input db 21, 22 dup(?), 10, '$'

data	ends

stack1  segment	stack
        db	100 dup(?)     			; This is the stack of 100 bytes
stack1  ends

code    segment
        assume  cs:code, ds:data, ss:stack1

start:

        mov ax, data
        mov ds, ax

        mov ax, stack1
        mov ss, ax
;--------------------------------------------------------------------------------------

        lea dx, msg1			; Print prompt
		mov ah, 09h
		int 21h
		
		lea dx, input			; Get input from the user
		mov ah, 0Ah
		int 21h

		lea dx, msg2			; Print "The reversed String is:"
		mov ah, 09h
		int 21h

		lea bx, input			; Get address of input buffer
		inc bx					; Skip max length byte
		mov cl, [bx]			; Get actual length in CL
		mov ch, 0				; Clear CH to use CX as counter
		inc bx					; Move to first character

		print_forward:			; Print forward
			mov dl, [bx]		; Get character
			mov ah, 02h			; DOS function 02h - print character
			int 21h
			inc bx				; Move to next character
			loop print_forward	; Repeat for all characters

		mov dl, '-'				; Print hyphen separator
		mov ah, 02h
		int 21h

		lea bx, input			; Reset BX to start of buffer
		inc bx					; Skip max length byte
		mov cl, [bx]			; Get length again
		mov ch, 0				; Clear CH
		add bx, cx				; Point to last character
		inc bx					; Adjust for the initial position
		
		print_reverse:			; Print in reverse
			dec bx				; Move to previous character
			mov dl, [bx]		; Get character
			mov ah, 02h			; Print character
			int 21h
			loop print_reverse	; Repeat for all characters
		
		

;-------------------------------------------------------------------------------------------------------------------------------------------------------
	mov ah, 4ch 					;Set up code to specify return to dos
        int 21h						;Interrupt number 21 (Return control to dos prompt)

code    ends

end     start
;-------------------------------------------------------------------------------------------------------------------------------------------------------
