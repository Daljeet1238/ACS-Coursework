def nested_sum(t:list):
    """"
    t : a list conating sublist
    Completing the sum of all the values in the list
    """
    total = 0
    for sublist in t:
        total += sum(sublist)
    return total

def test_nested_sums():
    assert nested_sum([[1, 2, 7, 9], [3, 6], [1, 4, 5, 6]]) == 44
    assert nested_sum([[0, 0, 0], [0, 0], [0, 0, 0]]) == 0
    assert not nested_sum([[1, 2, 7, 9], [3, 6], [1, 4, 5, 6]]) == 50
    assert nested_sum([[], [], []]) == 0