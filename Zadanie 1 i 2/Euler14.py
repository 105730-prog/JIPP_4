# The following iterative sequence is defined for the set of positive integers
# Which starting number, under one million, produces the longest chain ?
def collatz_sequence(n):
    def collatz_step(x):
        if x % 2 == 0:
            return x // 2
        else:
            return 3 * x + 1

    sequence = [n]
    while n != 1:
        n = collatz_step(n)
        sequence.append(n)
    return sequence

def find_longest_collatz_sequence(limit):
    def sequence_length(n):
        return len(collatz_sequence(n))

    starting_numbers = range(1, limit)
    return max(starting_numbers, key=sequence_length)

result = find_longest_collatz_sequence(1000000)
print(result)




