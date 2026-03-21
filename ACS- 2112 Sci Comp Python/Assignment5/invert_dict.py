import collections

def invert_dict(l):
    """
    Inverts the keys and values of a dictionary.
    """
    inverted_dict = collections.defaultdict(list)
    for key in l:
        val = l[key]
        if val not in inverted_dict:
            inverted_dict[val] = [key]
        else:
            inverted_dict[val].append(key)
    return inverted_dict

def test_invert_dict():
    """
    Tests the invert_dict function.
    """
    assert invert_dict({'a':1, 'b':1, 'c':2, 'd':3}) == {1: ['a','b'], 2: ['c'], 3: ['d']}
    assert invert_dict({1: 'a', 2: 'b', 3: 'c'}) == {'a': [1], 'b': [2], 'c': [3]}
    assert invert_dict({}) == {}
    assert not invert_dict({'a': 1, 'b': 1, 'c': 1, 'd': 2}) == {1: ['a','b','c','d']}