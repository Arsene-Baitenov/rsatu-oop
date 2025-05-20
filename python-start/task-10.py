x = int(input())
xs = [x]

while x != 0:
    x = int(input())
    xs.append(x)

k = int(input())

ys = list(filter(lambda x: x <= k, xs))
print(ys)
