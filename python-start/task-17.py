import matplotlib.pyplot as plt


def y1(x): return x**2 + x**4 - x + 5


def y2(x): return -x**2 + 2*x + 15


xs = []
y1s = []
y2s = []

step = 1 / 1e3

for i in range(-2000, 2000):
    xs.append(i * step)
    y1s.append(y1(xs[-1]))
    y2s.append(y2(xs[-1]))


plt.plot(xs, y1s, label='y1')
plt.plot(xs, y2s, label='y2')

plt.legend()
plt.show()
