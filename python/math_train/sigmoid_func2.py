#coding: UTF-8

import matplotlib.pyplot as plt
import numpy as np
import math

e = math.e
dx = 0.1
x = np.arange(-8, 8, dx)


def sigmoid(a):
    s = 1 / (1 + e ** -a)
    return s

# シグモイド関数
y_sig = sigmoid(x)

# シグモイド関数2
y_dsig = (sigmoid(x+dx) - sigmoid(x) )/ dx
plt.plot(x, y_sig, label="sigmoid")
plt.plot(x, y_dsig, label="d_sigmoid")
plt.legend()

plt.show()
