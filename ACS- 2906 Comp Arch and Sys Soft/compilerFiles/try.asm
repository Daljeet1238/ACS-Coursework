; data segment. Keyword db means define byte. You can also define word (dw)
data segment
    msg db 10,13, 'Hello World!' , 10,13, '$' ; Message to be displayed
data ends

stack1 segment
    db 100 dup(?)
stack1 ends

code segment
    assume cs:code, ds:data, ss:stack1


start:
    mov ax, data
    mov ds, ax

    lea dx, msg
    mov ah, 09h
    int 21h

    mov ah, 4ch
    int 21h

code ends
end start