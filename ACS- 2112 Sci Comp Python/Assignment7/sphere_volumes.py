import numpy as np

def sphere_volumes(radii):
    """
    Calculate the volume of the sphere
    """
    volumes = 4/3 * np.pi * radii**3
    return volumes

def test_sphere_volumes():
    """
    Compare the results through pytest
    """
    input_values = sphere_volumes(np.array([5, 10, 15]))
    expected_volumes = np.array([523.5987756, 4188.79020479, 14137.16694115])
    assert np.allclose(input_values, expected_volumes)

    input_values_zero = sphere_volumes(np.array([0, 0, 0]))
    expected_volumes_zero = np.array([0, 0, 0])
    assert np.allclose(input_values_zero, expected_volumes_zero)
    
    input_values_large = sphere_volumes(np.array([1000, 10000, 100000]))
    expected_volumes_large = np.array([4.18879020e+09, 4.18879020e+12, 4.18879020e+15])
    assert np.allclose(input_values_large, expected_volumes_large)