from math import ceil, sqrt

x = int(input())
xs = []

while x != 0:
    xs.append(x)
    x = int(input())

for x in xs:
    max_div = x//2 + 1
    divs = []
    y = x

    for i in range(2, max_div + 1):
        if y % i == 0:
            divs.append(i)
            while y % i == 0:
                y //= i

    if y != 1:
        divs.append(x)

    with open(f'Простые делители {x}.txt', 'w') as f:
        f.writelines(map(lambda d: str(d) + '\n', divs))

    print(x, divs)
