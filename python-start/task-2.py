x = int(input())

a = x // 100
b = (x % 100) // 10
c = x % 10

print(f'reversed: {c*100 + b*10 + a}, sum of digits: {a + b + c}')
