import time
import math
import datetime as dt

seconds = time.time()

# Converting the seconds into days and current time

days = seconds // 86400
hours = ((seconds % 86400) // 3600) % 12
minutes = ((seconds % 86400) % 3600) // 60
seconds =  ((seconds % 86400) % 3600) % 60

# Prints the days and current time 

print("Total days are " + str(days))
print("Current time ", hours, ":", minutes, ":", math.floor(seconds))

t = dt.time(hour=int(hours), minute=int(minutes), second=int(seconds))
print(t)