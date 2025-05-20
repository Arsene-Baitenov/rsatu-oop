from random import randint


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
    xs.sort()
    max_x = xs[-1]
    min_x = xs[0]
    sum = 0
    for x in xs:
        sum += x

    avg = sum / len(xs)
    m = xs[len(xs) // 2] if len(xs) % 2 == 1 else (xs[len(xs) //
                                                      2 - 1] + xs[len(xs) // 2]) / 2

    return max_x, min_x, max_x - min_x, avg, m


def save_stats(filename, *args):
    with open(filename, 'w') as f:
        f.writelines(map(lambda arg: str(arg) + '\n', args))


filename = 'task-13-numbers.txt'
filename_stats = 'task-13-numbers-stats.txt'

xs = generate_numbers()
save_numbers(filename, xs)
xs = get_numbers(filename)
max_x, min_x, diff, avg, m = get_stats(xs)
save_stats(filename_stats, max_x, min_x, diff, avg, m)
