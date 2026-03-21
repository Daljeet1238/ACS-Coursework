def check_fermat(a, b, c, n):
    """
    Check Fermat's Last Theorem for given parameters.

    Parameters:
    - a (int): First parameter.
    - b (int): Second parameter.
    - c (int): Third  parameter.
    - n (int): Exponent parameter.

    Returns: True if Fermat's Last Theorem holds for the given parameters, False otherwise.
    """
    if n > 2 and (a**n + b**n == c**n):
        return True
    return False

def test_check_fermat():
    result = check_fermat(1, 1, 1, 3)
    if result:
        print("Holy smokes, Fermat was wrong!")
    else:
        print("No, that doesn't work.")
    assert result == False
    assert not check_fermat(1, 1, 1, 1)
    assert not check_fermat(1, 3, 5, 3)