import matplotlib.pyplot as plt
import numpy as np
import math

e = math.e
dx = 0.1
x = np.arange(-8, 8, dx)


def sigmoid(a):
    s = 1 / (1 + e ** -a)
    return s


# y_sig = 1 / (1 + e ** -x)
y_sig = sigmoid(x)
plt.plot(x, y_sig)
plt.show()
