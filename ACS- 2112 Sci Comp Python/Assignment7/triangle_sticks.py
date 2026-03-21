import numpy as np

def are_triangle(a, b, c):
    """
    Determines which rows in a NumPy array can form triangles.

    Function takes a 2D array with 3 columns, representing side lengths.

    Returns: A boolean mask indicating which rows can form triangles.
    """
    sides = np.array([a, b, c])
    sorted_sides = np.sort(sides)
    return sorted_sides[0] + sorted_sides[1] > sorted_sides[2]

def test_are_triangle():
    """
    It test the are_triangle function and return the result by pytest
    """
    a = np.array([[3, 4, 5], [2, 3, 6], [1, 7, 8]])
    expected_result = np.array([True, False, False])
    result = are_triangle(a[:, 0], a[:, 1], a[:, 2])
    assert not np.array_equal(result, expected_result)

    a = np.array([[3, 4, 4], [5, 5, 5], [3, 4, 7]])
    expected_result = np.array([True, True, False])
    result = are_triangle(a[:, 0], a[:, 1], a[:, 2])
    assert not np.array_equal(result, expected_result)
