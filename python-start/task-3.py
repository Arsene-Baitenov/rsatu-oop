from math import floor

f = float(input())

h = floor(f / 30)
f -= h * 30
m = floor(f / 0.5)
f -= m * 0.5
s = round(f / (0.5 / 60))

print(f'{h} : {m} : {s}')
