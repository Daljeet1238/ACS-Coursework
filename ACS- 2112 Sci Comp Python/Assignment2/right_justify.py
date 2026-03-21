def right_justify(s):
    """
    This function displays the last letter of the text at the 70th column 
    of the line.
    """
    spaces = " " * (70-len(s))
    print(spaces + s)

right_justify("think python")
