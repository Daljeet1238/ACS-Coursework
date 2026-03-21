import pandas as pd

def has_no_e(word):
    """
    return true if the word doeesn't contain letter 'e'
    """
    return 'e' not in word.lower()

def test_has_no_e():
    """
    test function for the has_no_e
    """
    assert has_no_e("kiwi")
    assert not has_no_e("lychee")
    assert not has_no_e("persimmon")

if __name__ == "__main__":
    test_has_no_e()