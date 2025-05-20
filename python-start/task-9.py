x = int(input())

f = True

while x != 0:
    prev = x
    x = int(input())
    if (prev > x):
        f = False

if f:
    print('Yes')
else:
    print('No')
