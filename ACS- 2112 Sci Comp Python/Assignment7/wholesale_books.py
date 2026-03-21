import numpy as np

def total_book_cost(price, discount, shipping_base, shipping_additional, number_of_copies):
    """
    Calculates the total cost of a book order using vectorized operations.

    Returns: The total cost of each book order.
    """

    discounted_price = price * (1 - discount / 100)
    total_shipping = shipping_base + (number_of_copies - 1) * shipping_additional
    total_cost = discounted_price * number_of_copies + total_shipping

    return total_cost

data = np.array([[24.95, 40, 3, 0.75, 60] , [26.95, 35, 4, 1.00, 70] , [27.95, 45, 5, 1.25, 80]])

def test_total_book_cost():
    """
    Compare the values of both functions
    """
    price, discount, shipping_base, shipping_additional, number_of_copies = data.T
    expected_costs = np.array([945.45, 1299.23, 1333.55])
    assert np.allclose(total_book_cost(price, discount, shipping_base, shipping_additional, number_of_copies), expected_costs, rtol=1e-5)
