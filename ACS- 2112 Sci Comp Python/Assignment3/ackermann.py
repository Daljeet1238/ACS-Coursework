def ackermann(m:int, n:int):
    """
    The Ackermann function is a mathematical function that grows rapidly,
    used to demonstrate the computability of certain functions.

    Parameters:
    - m : Non-negative integer.
    - n : Non-negative integer.

    Returns:
    int: Result for the given parameters.
    """
    if m == 0:
        return n+1
    elif m > 0 and n == 0:
        return ackermann(m-1, 1)
    elif m > 0 and n > 0:
        return ackermann(m-1, ackermann(m, n-1))

def test_ackermann():
    assert ackermann(3, 4) == 125
    assert ackermann(0, 0) == 1
    assert not ackermann(1, 0) == 3
    assert ackermann(0, 1) == 2