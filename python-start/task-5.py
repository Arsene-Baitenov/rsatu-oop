eps = 1 / 1e9

bs = list(map(float, input().split(' ')))
bs.sort()
k1, k2, g = bs
print(k1, k2, g)

if k1 ** 2 + k2 ** 2 == g ** 2:
    print(f"Triangle exists, area: {k1 * k2 / 2}")
else:
    print("Triangle doesn't exist")
