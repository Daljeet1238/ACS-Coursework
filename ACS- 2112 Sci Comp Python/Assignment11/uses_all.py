def uses_all(line, required_letters):
    """
    Returning words containing all required letters from a letters.
    """
    words = line.lower().split()
    result = []
    for word in words:
        if all(letter in word for letter in required_letters):
            result.append(word)
    return result


def test_uses_all():
    """
    Test function for the uses_all function.
    """
    assert uses_all("This is an example line containing words", "ae") == ["example"]
    assert uses_all("Hello world", "el") == ["hello"]
    assert uses_all("Python is awesome", "py") == ["python"]


if __name__ == "__main__":    
    test_uses_all()
