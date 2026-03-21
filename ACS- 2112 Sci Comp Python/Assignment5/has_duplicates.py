def has_duplicates(list):
    """
    Checks if a list contains any duplicate elements.
    Returns True if duplicates are found, False otherwise.
    """
    for i in range(len(list)-1):
        if list[i] == list[i+1]:
            return True
    return False

def test_has_duplicates():
    """
    Tests the has_duplicates function.
    """
    assert not has_duplicates([1 , 2 , 3 , 4])
    assert has_duplicates([1 , 2 , 2 , 3])
    assert has_duplicates([1 , 1 , 2 , 3])
    assert has_duplicates([1 , 2 , 3 , 3])
    assert not has_duplicates([])
    assert has_duplicates([[1 , 2 , 3] , [1 , 2 , 3]])