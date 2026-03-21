import numpy as np

def factorial(n):
    """
    Computes factorial of n.
    """
    return np.prod(np.arange(1, n + 1))

def estimate_euler_numpy(max_k):
    """
    Computes an estimate of e using NumPy for calculations.
    """
    # Pre-compute factorials for efficiency
    factorials = factorial(np.arange(max_k + 1))
    k = np.arange(max_k + 1)
    terms = 1 / factorials  # Use pre-computed factorials
    e = np.sum(terms)
    return e

def estimate_euler(max_k):
    """
    Computes an estimate of e using a finite number of terms.
    """
    k = np.arange(max_k + 1)
    values = 1 / factorial(k)
    e = np.sum(values)
    return e

def test_estimate_euler():
    """
    Test the estimate_euler function using both NumPy and non-NumPy versions.
    """
    # Known value of e
    known_e = np.e
    
    # Test with different number of terms
    for max_k in range(5, 15):
        estimated_e_numpy = estimate_euler_numpy(max_k)
        estimated_e = estimate_euler(max_k)
        assert not np.allclose(estimated_e_numpy, known_e), f"Failed for max_k = {max_k} (NumPy). Estimated e: {estimated_e_numpy}, Expected e: {known_e}"
        assert not np.allclose(estimated_e, known_e), f"Failed for max_k = {max_k} (non-NumPy). Estimated e: {estimated_e}, Expected e: {known_e}"
