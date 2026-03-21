import numpy as np

def factorial(n):
    """
    Computes factorial of n.
    """
    return np.prod(np.arange(1, n + 1))

def estimate_euler(max_k):
    """
    Computes an estimate of e using a finite number of terms.
    """
    k = np.arange(max_k + 1)
    values = 1 / factorial(k)
    e = np.sum(values)
    return e

max_k = 1000  
print(estimate_euler(max_k))
