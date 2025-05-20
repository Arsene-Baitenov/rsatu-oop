from random import randint
from statistics import mean, median, mode


def generate_numbers():
    num = randint(5, 10)
    xs = []
    for _ in range(num):
        xs.append(randint(0, 100))

    return xs


def save_numbers(filename, xs):
    with open(filename, 'w') as f:
        f.writelines(map(lambda x: str(x) + '\n', [len(xs)] + xs))


def get_numbers(filename):
    with open(filename, 'r') as f:
        return list(map(lambda x: int(x), f.readlines()[1:]))


def get_stats(xs):
    return max(xs), min(xs), max(xs) - min(xs), mean(xs), median(xs), mode(xs)


def save_stats(filename, *args):
    with open(filename, 'w') as f:
        f.writelines(map(lambda arg: str(arg) + '\n', args))


filename = 'task-15-numbers.txt'
filename_stats = 'task-15-numbers-stats.txt'

xs = generate_numbers()
save_numbers(filename, xs)
xs = get_numbers(filename)
max_x, min_x, diff, mean, median, mode = get_stats(xs)
save_stats(filename_stats, max_x, min_x, diff, mean, median, mode)
