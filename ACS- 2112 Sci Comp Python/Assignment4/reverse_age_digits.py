def str_fill(i: int, n: int) -> str:
    """
    Returns i as a string with at least n digits.
    """
    return str(i).zfill(n)

def are_reversed(i: int, j: int) -> bool:
    """
    Checks if i and j are the reverse of each other.
    """
    return str_fill(i, 2) == str_fill(j, 2)[::-1]

def num_instances(diff: int, flag=False) -> int:
    """Counts the number of palindromic ages.

    Returns the number of times the mother and daughter have
    palindromic ages in their lives, given the difference in age.
    """
    daughter = 0
    count = 0
    while True:
        mother = daughter + diff

        if are_reversed(daughter, mother) or are_reversed(daughter, mother+1):
            count += 1
            if flag:
                print(daughter, mother)
        if mother > 100:
            break
        daughter += 1
    return count

def test_num_instance():
    assert num_instances(18, True) == 8
    assert num_instances(9, True) == 9
    assert num_instances(4, True) == 0
    assert not num_instances(0, False) == 99
