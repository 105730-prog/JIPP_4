# The following iterative sequence is defined for the set of positive integers
# Which starting number, under one million, produces the longest chain ?
def collatz_sequence(n):
    sequence = [n]
    while n != 1:
        if n % 2 == 0:
            n = n // 2  # if n is even, divide it by 2
        else:
            n = 3 * n + 1 # if odd, multiply it by 3 and add 1
        sequence.append(n)
    return sequence


def euler_14():
    max_length = 0
    max_starting_number = 0

    for i in range(1, 1000000):
        sequence_length = len(collatz_sequence(i))
        if sequence_length > max_length:
            max_length = sequence_length
            max_starting_number = i

    return max_starting_number


print(euler_14())




