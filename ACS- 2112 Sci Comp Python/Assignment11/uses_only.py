def uses_only(line, letters):
    """
    Returning the words from the line which contain only letters from the given string.
    """
    words = line.split()
    valid_words = [] 
    for word in words:
        if all(letter in letters for letter in word):
            valid_words.append(word)
    return valid_words

def test_uses_only():
    """
    Test function for the uses_only function.
    """
    assert uses_only("hello world", "helo") == ["hello"]
    assert uses_only("apple banana avocado", "a") == []
    assert uses_only("", "abcd") == []
    assert uses_only("123 456 789", "abc") == []
    assert uses_only("banana apple grape", "abn") == ['banana']

if __name__ == "__main__":    
    test_uses_only()
