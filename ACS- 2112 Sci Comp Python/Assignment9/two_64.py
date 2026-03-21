import numpy as np

#Creating the numpy array with dtype uint64 conatining the single integer.
array = np.array([2], dtype = np.uint64)

value = np.power(array, 63) - 1

#Convert the value to a binary string with 63 '1' characters.
result = np.binary_repr(value[0], width = 63)

print(result)