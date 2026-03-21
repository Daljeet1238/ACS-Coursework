def do_twice(i):
    """
    Runs the function two times.
    """
    i()
    i()

def do_four(i):
    """
    Runs the function four times.
    """
    do_twice(i)
    do_twice(i)

def print_line():
    """
    This function prints the syntex and end that with space.
    """
    print("- - - - +", end=" ")

def print_vert():
    """
    This function prints the syntex and end it with space.
    """
    print("        |", end=" ")

def print_lines():
    """
    Calls the print_line twice 
    """
    do_twice(print_line)

def print_verts():
    """"
    Calls the print_vert twice 
    """
    print("|", end=" ")
    do_four(print_vert)
    print("")

def print_row():
    """
    Call a function and executing one function in another 
    """
    print("+", end=" ")
    do_twice(print_lines)
    print("")
    do_four(print_verts)

def print_grid():
    """
    calls the function twice with another function
    """
    do_four(print_row)
    print("+", end=" ")
    do_twice(print_lines)

print_grid()