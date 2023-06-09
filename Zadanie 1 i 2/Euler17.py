# If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
# then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

# If all the numbers from 1 to 1000 (one thousand)
# inclusive were written out in words, how many letters would be used? 
endnums = {1:"one",
           2:"two",
           3:"three",
           4:"four",
           5:"five",
           6:"six",
           7:"seven",
           8:"eight",
           9:"nine"} 
exceptions = {1:"one",
              2:"two",
              3:"three",
              4:"four",
              5:"five",
              6:"six",
              7:"seven",
              8:"eight",
              9:"nine",
              10:"ten",
              11:"eleven",
              12:"twelve",
              13:"thirteen",
              14:"fourteen",
              15:"fifteen",
              16:"sixteen",
              17:"seventeen",
              18:"eighteen",
              19:"nineteen",
              20:"twenty", 
              1000:"onethousand"}
tens = {10:"ten",
        20:"twenty",
        30:"thirty", 
        40:"forty",
        50:"fifty",
        60:"sixty",
        70:"seventy",
        80:"eighty",
        90:"ninety"}
letters = ""
def spell(n):
    spelling = ""
    if n in exceptions: 
        spelling = exceptions[n]
        return spelling 
    if n >= 100:
        spelling = endnums[int(str(n)[0])] + "hundred" 
        if str(n)[1] == "0" and str(n)[2]=="0": # for full hundreds
            return spelling
        if str(n)[1] == "0": 
            spelling = spelling+" and "+endnums[int(str(n)[2])] # for ex. 302 ; 508
        else:
            if int(str(n)[1:3]) < 20:
                spelling = spelling+" and "+exceptions[int(str(n)[1:3])] # ex. 1,2,3
            else:
                if n % 10 == 0:
                    spelling = spelling + " and "+tens[int(str(n)[1]+"0")] # for ex. 110 , 330
                else:
                    spelling = spelling + " and " + tens[int(str(n)[1]+"0")] + "-"+endnums[int(str(n)[2])] # for ex. 443 , 776
    else:
        if str(n)[1]=="0":
            spelling = tens[int(str(n)[0]+"0")]
        else:
            spelling = tens[int(str(n)[0]+ "0")]+"-"+endnums[int(str(n)[1])]
    spelling = spelling.replace(" ","")
    spelling = spelling.replace("-","")
    return spelling
for i in range(1,1001):
    letters = letters + spell(i)
print(len(letters)) # Get the length of given string

# Do not count spaces or hyphens. For example, 
# 342 (three hundred and forty-two) 
# contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
# The use of "and" when writing out numbers is in compliance with British usage.