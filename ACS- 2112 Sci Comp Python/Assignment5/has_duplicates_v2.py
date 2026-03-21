def has_duplicates(s):
    """
    Checks for duplicate elements in a sequence.
    Returns True if duplicates are found, False otherwise.
    """
    d = dict()

    for c in s:
        if c in d:
            return True
        if c not in d:
            d[c] = 1
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