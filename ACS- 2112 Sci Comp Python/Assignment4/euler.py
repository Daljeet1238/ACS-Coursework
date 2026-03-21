def factorial(n):
    """Computes factorial of n recursively."""
    if n == 0:
        return 1
    else:
        recurse = factorial(n-1)
        result = n * recurse
        return result


def estimate_euler():
    """Computes an estimate of e.
    By using the formula of infinite series.
    """
    e = 0
    k = 0

    while True:

        term = 1 / factorial(k)

        e += term

        if abs(term) < 1e-15:
            break
        
        k += 1
    
    return e

print(estimate_euler())