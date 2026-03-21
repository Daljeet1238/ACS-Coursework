;-------------------------------------------------------------------------------------------------------------------------------------------------------
;  Assignment 2
;  Name: Daljeet Singh
;  Student ID: 3169763
;-------------------------------------------------------------------------------------------------------------------------------------------------------

;-------------------------------------------------------------------------------------------------------------------------------------------------------
data	segment										; data segment. Keyword db means define byte. You can also define word (dw)
		input db 21 
		buffer db 21 dup('$')						;Define buffer to hold input string
		msg db 'Enter a String (max 20 char.)$'  	;Define message to prompt user for input
		msg2 db 'The String you entered is:$'
		iNum	db  225								;Define input number
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
		lea dx, msg
		mov ah, 09h
		int 21h
		
		lea dx, input
		mov ah, 0ah
		int 21h

		lea dx, msg2
		mov ah, 09h
		int 21h

		lea dx, buffer + 1
		lea dx, buffer
		
		int 21h
;-------------------------------------------------------------------------------------------------------------------------------------------------------										
		mov ah, 4ch 					;Set up code to specify return to dos
        int 21h							;Interpt number 21 (Return control to dos prompt)

code    ends

end     start
;-------------------------------------------------------------------------------------------------------------------------------------------------------



