n = int(input())

max_x = int(input())

for _ in range(n-1):
    max_x = max(max_x, int(input()))

print(max_x)
