;--------------------------------------------------------------------------------------
; ACS-2906-001
; Daljeet Singh
; Student ID: 3169763
; Lab 8
;--------------------------------------------------------------------------------------
data	segment						; data segment

        input db 'Input a word:' , 13, 10, '$'		;Define message for input prompt
        strBr db 21, 22 dup(?), 10, '$'			; Define input buffer
        msg1 db 'The word is palindrome.', 13, 10, '$'	; Define palindrome message
        msg2 db 'The word is NOT a palindrome.', 13, 10, '$'	; Define not palindrome message

data	ends

                                    ;stack segment
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
        lea dx, input               ; Print input prompt
        mov ah, 09h
        int 21h

        lea dx, strBr               ; Get input from the user
        mov ah, 0Ah
        int 21h

        mov ah, 2h
        mov dl, 10
        int 21h                    ; Print newline

        lea bx, strBr              ; Get address of input buffer
        inc bx                      ; Skip max length byte
        mov al,[bx]               ; Get actual length in CL
        mov ah, 0                  ; Clear CH to use CX as counter

        mov cl,2
        div cl

        mov ch, 0
        mov cl,al

        mov dx, word ptr '$'
        push dx
    addIntoStack:
        inc bx
        mov dl, [bx]   
        mov dh, 0
        push dx
        loop addIntoStack

    cmp ah,1
    jne evenLength
    inc bx

    evenLength:
        inc bx
        mov dh, 0
        pop dx
        cmp dl, '$'
        je isPalindrome
        cmp dl, [bx]
        je evenLength
        jmp error

    isPalindrome:
        lea dx, msg1               ; Print palindrome message
        mov ah, 09h
        int 21h
        
    jmp theEnd

    error:
        lea dx, msg2               ; Print not palindrome message
        mov ah, 09h
        int 21h

    theEnd:

;-------------------------------------------------------------------------------------------------------------------------------------------------------
        mov ax, 4ch              
        int 21h

    code ends
    end start   
;--------------------------------------------------------------------------------------