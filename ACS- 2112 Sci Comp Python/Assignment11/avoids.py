import pandas as pd

def avoids(word, letters):
    """
    Check if the word contains any of the letters.
    """
    word_series = pd.Series(list(word))
    
    letters = pd.Series(list(letters))
    if (word_series.isin(letters)).any():
        return False
    else:
        return True

def test_avoids():
    """
    Test cases for the avoids function.
    """
    assert not avoids("example", "xyz")
    assert not avoids("example", "abc")
    assert not avoids("hello", "abcde")
    assert avoids("example", "")
    assert avoids("", "")
   
if __name__ == "__main__":
    test_avoids()