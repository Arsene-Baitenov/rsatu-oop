n = int(input())

xs = []

for _ in range(n):
    xs.append(int(input()))

ys = []

for i in range(n):
    if xs[i] in xs[i+1:] and xs[i] not in ys:
        ys.append(xs[i])

print(ys)
