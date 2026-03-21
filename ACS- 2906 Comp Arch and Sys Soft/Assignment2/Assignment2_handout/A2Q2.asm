;------------------------------------------------------------------------------------------------------------
; ACS-2906-001
; Assignment 2 Question 2
; Name: Daljeet Singh
; Student Number: 3169763
;-------------------------------------------------------------------------------------------------------------------------------------------------------
data	segment							; data segment. Keyword db means define byte. You can also define word (dw)
		iNum	db  225					;Define input number
		
		num db 21, 22 dup(?), 10, '$'	;user input to be stored in this variable

        msg1 db "Enter a String (max 20 char.)", 10, 13, '$'
        msg2 db "The String you entered is:", 10, 13, '$'
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
;****************** Assignment 2 Question 2 ******************

    ;getting input from the user:	 
		lea dx, msg1					; subroutine to print first input msg
        mov ah, 09
        int 21h

        lea dx, num						;subroutine 0Ah to get String input from the user.
        mov ah, 0Ah
        int 21h

    ;storing the string and the length of given String
        mov bx, dx						; storing the input string in bx
        inc bx							; incrementing bx, to move to 2nd position(count) in bx

        mov cl, [bx]					; moving the value of count stored in bx using []
        mov ch, 00						; setting ch to 0
        inc bx							; incrementing bx to move to the first character of the input String

    ;printing the sting that the user entered:

        mov ah, 02                        ; line feed to move to next line after input
        mov dl, 10
        int 21h

        lea dx, msg2
        mov ah, 09
        int 21h

    chars:
            mov dl, [bx]					; moving the character stored at address bx to dl
            inc bx
            mov ah, 02
            int 21h

            loop chars                        ; looping till all characters are printed
;-------------------------------------------------------------------------------------------------------------------------------------------------------										
		mov ah, 4ch 					;Set up code to specify return to dos
        int 21h							;Interpt number 21 (Return control to dos prompt)

code    ends

end     start
;-------------------------------------------------------------------------------------------------------------------------------------------------------



