;------------------------------------------------------------------------------------------------------------------------------------------------------
; ACS-2906-001 Lab 6
; Daljeet Singh
; 3169763
;------------------------------------------------------------------------------------------------------------------------------------------------------



data segment
    msg1 db 'Please insert number 1$'
    msg2 db 10, 13, 'Please insert number 2$'
    sumMsg db 10, 13, 'The summation is: $'
data ends
    
stack1 segment
    db 100 dup(?)
stack1 ends

code segment
    assume cs:code, ds:data, ss:stack1


start:
    mov ax, data
    mov ds, ax
    
    ; Display first message
    lea dx, msg1
    mov ah, 09h
    int 21h
    
    ; Read first number
    mov ah, 01h
    int 21h
    sub al, 30h  ; Convert from ASCII to number
    mov bl, al   ; Store first number in bl
    
    ; Display second message
    lea dx, msg2
    mov ah, 09h
    int 21h
    
    ; Read second number
    mov ah, 01h
    int 21h
    sub al, 30h  ; Convert from ASCII to number
    add bl, al   ; Add second number to first number in bl
    
    ; Display sum message
    lea dx, sumMsg
    mov ah, 09h
    int 21h
    
    ; Convert sum to ASCII and display
    mov al, bl
    add al, 30h
    mov dl, al
    mov ah, 02h
    int 21h
    
    mov ah, 4ch
    int 21h
code ends
end start
;-------------------------------------------------------------------------------------------------------------------------------------------------------
