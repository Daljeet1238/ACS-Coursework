def is_palindrome(t):
    """
    Check if the line or a word is palindrome
    """
    t = t.lower()         # Convert the string to lowercase for case-insensitivity
    t = ''.join(filter(str.isalpha, t))     #Removing the non-alphabets

    return t == t[::-1]         # Checking if the dtring is equals to their reverse


def test_is_palindeome():
    assert is_palindrome("A man, a plan, a canal, Panama") == True
    assert is_palindrome("Hello World") == False
    assert is_palindrome("12321") == True
    assert is_palindrome("Madam") == True
    assert is_palindrome("A") == True