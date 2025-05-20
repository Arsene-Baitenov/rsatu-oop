print('Format: xx.xx y.y r.r')

x1, y1, r1 = tuple(map(float, input().split(' ')))
x2, y2, r2 = tuple(map(float, input().split(' ')))
if r1 < r2:
    r1, r2 = r2, r1
    x1, x2 = x2, x1
    y1, y2 = y2, y1

if (x1 - x2) ** 2 + (y1 - y2) ** 2 <= r1 ** 2:
    print('No')
elif (x1 - x2) ** 2 + (y1 - y2) ** 2 <= (r1 + r2) ** 2:
    print('Yes')
else:
    print('No')
