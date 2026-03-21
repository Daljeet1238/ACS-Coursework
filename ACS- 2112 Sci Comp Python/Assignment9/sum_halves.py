import numpy as np

def sum_halves():
    """"
    Calculate sum of the series.
    """
    values = np.array([1 / (2**i) for i in range(1, 101)])

    addition = np.sum(values)
    return addition

def test_sum_halves():
    """
    Testing the sum_halves function
    """
    expected_value = 1.0
    result = sum_halves()
    assert np.isclose(expected_value, result)

    