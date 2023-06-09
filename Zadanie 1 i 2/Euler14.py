# The following iterative sequence is defined for the set of positive integers
# Which starting number, under one million, produces the longest chain ?
# NOTE: Once the chain starts the terms are allowed to go above one million.
ans = 0
def collatz(current_num):
    collatzsequence = [current_num]
    n = current_num
    while (n != 1):
        if ((n%2)==0):
            n = n/2 # n → n/2 (n is even)
        else:
            n = (3*n) + 1 # n → 3n + 1 (n is odd)
        collatzsequence.append(n) # add n to the end of the list
    return collatzsequence
for i in range(3,1000000):
    if (ans < len(collatz(i))):
        ans = len(collatz(i))
        print(f"{i}")
