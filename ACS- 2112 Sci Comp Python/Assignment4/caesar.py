def rotate_letter(letter: str, n: int) -> str:
    """
    Rotates a single letter by a given number of positions in the alphabet.
    """

    if letter.isupper():
        begin = ord('A')
    else:
        begin = ord('a')

    c = ord(letter) - begin
    i = (c + n) % 26 + begin
    return chr(i)


def rotate_string(word: str, n: int) -> str:
    """
    Rotates each letter in a string by a given number of positions in the alphabet.
    """

    result = ''
    for letter in word:
        result += rotate_letter(letter, n)
    return result


if __name__ == '__main__':
    print(rotate_string("funny", 7))

def test_rotate_string():
    assert rotate_string("cheer", 7) == "jolly"
    assert rotate_string("melon", -10) == "cubed"
    assert not rotate_string("HAL", -1) == "IBM"
