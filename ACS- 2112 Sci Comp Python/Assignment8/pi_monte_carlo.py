import numpy as np

def mc_pi_numpy(max_iterations=200):
    """
    Estimate the value of pi using Monte Carlo Method.
    """

    inside_unit_circle = 0
    total_points = max_iterations
    random_points = np.random(max_iterations, 2)
    x, y = random_points[:, 0], random_points[:, 1]
    inside_unit_circle = np.sum(x**2 + y**2 < 1)
    pi_estimate = 4 * inside_unit_circle / total_points
    print(pi_estimate)

#Results:
    """
    Time taken for mc_pi: 1.1786779000000105
    Time taken for mc_pi_numpy: 0.01937369999999443
    Time difference (mc_pi - mc_pi_numpy): 1.159304200000016
    """