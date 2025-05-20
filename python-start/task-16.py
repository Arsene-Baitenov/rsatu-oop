from random import randint
from statistics import mean, median, pstdev, pvariance
import matplotlib.pyplot as plt


def generate_numbers():
    num = randint(5, 10)
    xs = []
    for _ in range(num):
        xs.append(randint(0, 100))

    return xs


def save_numbers(filename, xs):
    with open(filename, 'w') as f:
        f.writelines(map(lambda x: str(x) + '\n', xs))


def get_numbers(filename):
    with open(filename, 'r') as f:
        return list(map(lambda x: int(x), f.readlines()))


def get_stats(xs):
    return mean(xs), median(xs), pvariance(xs), pstdev(xs)


filename = 'task-15-numbers.txt'

xs = generate_numbers()
save_numbers(filename, xs)
xs = get_numbers(filename)
mean, median, pvariance, pstdev = get_stats(xs)
print(f'mean: {mean}')
print(f'median: {median}')
print(f'pvariance: {pvariance}')
print(f'pstdev: {pstdev}')

ys = [0 for _ in range(len(xs))]
plt.scatter(xs, ys, label='numbers')
plt.scatter([mean], [0], label='mean', marker='o')
plt.scatter([median], [0], label='median', marker='o')
plt.scatter([mean - pstdev, mean + pstdev], [0, 0],
            label='pstdev bouds', marker='|')

plt.legend()
plt.show()
