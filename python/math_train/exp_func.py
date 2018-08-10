import matplotlib.pyplot as plt
import numpy as np

x = np.arange(-10, 10, 1.0)

y_2 = 2 ** x

y_3 = 3 ** x
plt.plot(x, y_3)
plt.plot(x, y_2)
plt.show()
