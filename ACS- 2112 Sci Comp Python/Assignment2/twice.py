def do_twice(func, val):
    """
    Run the funcrtion two times
    
    func: function object.
    val: a value passed by the function.
    """
    func(val)
    func(val)

def print_twice(val):
    """
    Print the argument twice
    """
    print(val)
    print(val)

do_twice(print, "spam")

print('')

def do_four(func, val):
    """
    Runs the function four times
    """
    do_twice(func, val)
    do_twice(func, val)

do_four(print, "spam")