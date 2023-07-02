# If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
# then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

# If all the numbers from 1 to 1000 (one thousand)
# inclusive were written out in words, how many letters would be used? 

def num_to_word(n):
    units = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    tens = ['', '', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']
    teens = ['ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen']

    if n == 1000:
        return 'onethousand'
    
    word = ''
    
    
    if n >= 100:
        word += units[n // 100] + 'hundred'  # checking hundreds
        if n % 100 != 0:
            word += 'and'
    
    
    n %= 100
    if n >= 20:  # checking tens and units
        word += tens[n // 10]
        word += units[n % 10]
    elif n >= 10:
        word += teens[n - 10]
    else:
        word += units[n]
    
    return word


def euler_17():
    letters_sum = 0

    for i in range(1, 1001):
        word = num_to_word(i)
        letters_sum += len(word)

    return letters_sum


print(euler_17())


# Do not count spaces or hyphens. For example, 
# 342 (three hundred and forty-two) 
# contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
# The use of "and" when writing out numbers is in compliance with British usage.