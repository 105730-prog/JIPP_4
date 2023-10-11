# The following iterative sequence is defined for the set of positive integers
# Which starting number, under one million, produces the longest chain ?
def collatz_sequence(n):
    sequence = [n]
    while n != 1:
        if n % 2 == 0:
            n = n // 2
        else:
            n = 3 * n + 1
        sequence.append(n)
    return sequence

def find_longest_collatz_sequence(limit):
    sequences = [(i, collatz_sequence(i)) for i in range(1, limit)]
    longest = max(sequences, key=lambda x: len(x[1]))
    return longest[0]

result = find_longest_collatz_sequence(1000000)
print(result)




