def is_triangle(a:int, b:int, c:int):
    """
    Check if three given side lengths can form a triangle.

    Parameters:
    - a : Length of first side.
    - b : Length of second side.
    - c : Length of third side.

    Returns:
    bool: True if a triangle can be formed with the given side lengths, False otherwise.
    """
    if(a + b >= c and a + c >= b and b + c >= a):
        return True
    return False

def test_is_triangle():
    assert is_triangle(3, 4, 5) 
    assert not is_triangle(1, 1, 10)
    assert is_triangle(6, 6, 6) 
    assert is_triangle(0, 0, 0) 
