import random

def count_same_birthdays():
    """
    Giving probability of at least two people sharing the same birthday 
    within a group of 23 people over 10,000 trials.
    
    n: number of people
    """
    n = 23
    trials = 10000
    total_same_birthdays = 0

    for i in range(trials):
        l = [random.randint(1, 366) for i in range(n)]
        l.sort()

        count = 0
        for i in range(0, len(l) - 1):
            if l[i] == l[i + 1]:
                count += 1
                break

        total_same_birthdays += count

    probability = total_same_birthdays / trials * 100
    print("Number of same birthdays:", total_same_birthdays, "Probability:", probability)

count_same_birthdays()
