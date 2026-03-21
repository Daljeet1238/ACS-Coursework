import pandas as pd

def long_words(line:str):
    """"
    Finds and returns words in a string that have a length greater than 20 characters
    """
    words = line.split()
    long_words = list(filter(lambda word: len(word) > 20, words))
    return long_words

def test_long_words():
    """
    test function for long_words.
    """
    assert long_words("This is a test string with some really long words like antidisestablishmentarianism") == ['antidisestablishmentarianism']
    assert long_words("Short words.") == []
    assert long_words("") == []
    assert long_words("Wordswithlengthmorethan20 Wordswithlengthmorethan20") == ['Wordswithlengthmorethan20', 'Wordswithlengthmorethan20']

if __name__ == "__main__":
    test_long_words()