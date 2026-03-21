import numpy as np

def pi_array():
    """"
    Convert the first 16 digits of pi into an array.
    """
    #Converting value of pi into string.
    pi_digits_str = str(np.pi)

    pi_without_point = pi_digits_str.replace(".", "")

    #Converting string into an array
    pi_digits_array = np.array([int(digit) for digit in pi_without_point])
    return pi_digits_array

def test_pi_array():
    """
    Test function for pi array
    """
    expected_result = np.array([3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3])
    result =pi_array()
    assert np.array_equal(result, expected_result)