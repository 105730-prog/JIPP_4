# The following iterative sequence is defined for the set of positive integers
# Which starting number, under one million, produces the longest chain ?
# NOTE: Once the chain starts the terms are allowed to go above one million.
def collatz(n):
    count = 0
    while n != 1:
        if n % 2 == 0:
            n //= 2  # when the number is even it 'll divide by 2
        else: 
            n = (3*n) + 1 # when the num 'll odd 
        count += 1

    return count

biggest_starting_value = 0
longest_chain = 0

for i in range(1, 10**6):
    current_num = collatz(i)
    if current_num > longest_chain:
        biggest_starting_value = i
        longest_chain = current_num

print(biggest_starting_value)



