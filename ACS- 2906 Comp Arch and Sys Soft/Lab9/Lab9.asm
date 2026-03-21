;-------------------------------------------------------------------------------------------------------------------------------------------------------
; ACS-2906-001
; Daljeet Singh
; Student ID: 3169763
; Lab 9
;-------------------------------------------------------------------------------------------------------------------------------------------------------
data	segment											; data segment. Keyword db means define byte. You can also define word (dw)
		msg1 db "Input x: ", 10, 13, '$'
		msg2 db "Input y: ", 10, 13, '$'
		answerMsg db "The answer is: ", 10, 13, '$'

		xValue db ?
		yValue db ?
		result dw ?

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

		jmp main
;-------------------------------------------------------------------------------------------------------------------------------------------------------		
;printNumber: print number procedure
;Uses: AX - number to print
;      DX, CX, BX - used in procedure
;-------------------------------------------------------------------------------------------------------------------------------------------------------
printNumber  proc

		cmp ax, 0
		jne print_number_non_zero

		mov dl, '0'
		mov ah, 02h
		int 21h
		ret

print_number_non_zero:
		mov cx, 0  					; Initialize digit count to 0

print_number_div_loop:
		xor dx, dx       			; Clear dx before division
		mov bx, 10
		div bx             			; Divide ax by 10
		push dx           			; Push remainder (digit) onto stack
		inc cx            			; Increment digit count
		cmp ax, 0     				
		jne print_number_div_loop   

print_number_pop_loop:
		pop dx
		add dl, 30h
		mov ah, 02h
		int 21h
		loop print_number_pop_loop

		ret
printNumber  endp

;-------------------------------------------------------------------------------------------------------------------------------------------------------
; fibonacci: fibonacci procedure recursively calculates fibonacci number
; input : AX = x
; output: AX = Fib(x)
; Fib(0) = 0 
; Fib(1) = 1
; Fib(n) = Fib(n-1) + Fib(n-2) for n > 1
;-------------------------------------------------------------------------------------------------------------------------------------------------------
fib		proc
		cmp ax, 0
		je fib_0					;if x = 0 return 0

		cmp ax, 1
		je fib_1					;if x = 1 return 1

		push bx

		mov bx, ax

		dec ax						;calculate Fib(x-1)
		call fib
		push ax

		mov ax, bx
		sub ax, 2					;calculate Fib(x-2)
		call fib

		pop bx
		add ax, bx					;Fib(x) = Fib(x-1) + Fib(x-2)

		pop bx
		ret

fib_0:
		mov ax, 0
		ret

fib_1:
		mov ax, 1
		ret

fib		endp

;-------------------------------------------------------------------------------------------------------------------------------------------------------
;****************** Write Code Here ******************

main:
	;first input 
		lea dx , msg1					; load address of msg1
		mov ah, 09h						; DOS print string function
		int 21h							; call DOS interrupt

		mov ah, 01h						; subroutine 1 to get input from the user
		int 21h

		mov cl, al						; storing the first input in counter cl, to use it int the loop
		sub cl, 30h						; subtracting 30 to get the correct ASCII value
		mov xValue, cl					; storing the first input value

	;line feed
		mov ah, 2						; next-line 
		mov dl, 10
		int 21h

	;second input
		lea dx , msg2					; load address of msg2
		mov ah, 09h						; DOS print string function
		int 21h							; call DOS interrupt

		mov ah, 01h						; subsoutine 1 to get input from the user
		int 21h

		mov bl, al						; storing the second number in bl 
		sub bl, 30h						; subtracting 30 to get the correct ASCII value
		mov yValue, bl					; storing the second input value

	;line feed
		mov ah, 2						; next-line 
		mov dl, 10
		int 21h

	;calculations
		xor ax, ax						; clear ax before calling fib
		mov al, xValue					; move xValue to al
		call fib						; call fibonacci procedure
		mov bx, ax						; store Fib(x) in bx

		;adding y
		xor ax, ax						; clear ax before calling fib
		mov al, yValue					; move yValue to al
		add ax,bx						; add Fib(x) + y

		mov result, ax					; store the result

	;output the result
		lea dx, answerMsg				; load address of answerMsg
		mov ah, 09h						; DOS print string function
		int 21h							; call DOS interrupt

		mov ax, result					; move result to al
		call printNumber				; call printNumber procedure to print the result

;-------------------------------------------------------------------------------------------------------------------------------------------------------										
		mov ah, 4ch 		;Set up code to specify return to dos
        int 21h				;Interpt number 21 (Return control to dos prompt)
	
;*****************************************************		

code    ends

end     start
;-------------------------------------------------------------------------------------------------------------------------------------------------------



