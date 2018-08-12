# coding: UTF-8
import math
import matplotlib.pyplot as plt


def sigmoid(a):
    return 1.0 / (1.0 + math.exp(-a))


# ニューロン
class Neuron:
    input_sum = 0.0
    output = 0.0

    def setinput(self, inp):
        self.input_sum += inp

    def getOutput(self):
        self.output = sigmoid(self.input_sum)
        return self.output

    def reset(self):
        self.input_sum = 0
        self.output = 0


# ニューラルネットワーク
class NeuralNetwork:
    # 入力の重み
    w = [-0.5, 0.5, -0.2]
    # ニューラルクラスのインスタンス生成
    neuron = Neuron()

    # 実行
    def commit(self, input_data):
        self.neuron.reset()
        bias = 1.0
        input_data.append(bias)
        for data, wei in zip(input_data, self.w):
            self.neuron.setinput(data * wei)
        return self.neuron.getOutput()


# 基準点（データの範囲を0.0~1.0の範囲に収めるため）
refer_point_0 = 34.5
refer_point_1 = 137.5

# ファイル読み込み
trial_data = []
trial_data_file = open("trial_data", "r")
for data in trial_data_file:
    data = data.rstrip().split(",")
    trial_data.append([float(data[0]) - refer_point_0, float(data[1]) - refer_point_1])
trial_data_file.close()

neural_network = NeuralNetwork()

# 実行
position_tokyo = [[], []]
position_kanagawa = [[], []]

for data in trial_data:
    if neural_network.commit(data) < 0.5:
        position_tokyo[0].append(data[1] + refer_point_1)
        position_tokyo[1].append(data[0] + refer_point_0)
    else:
        position_kanagawa[0].append(data[1] + refer_point_1)
        position_kanagawa[1].append(data[0] + refer_point_0)

plt.scatter(position_tokyo[0], position_tokyo[1], c="red", label="Tokyo", marker="+")
plt.scatter(position_kanagawa[0], position_kanagawa[1], c="blue", label="Kanagawa", marker="+")
plt.legend()
plt.show()

trial_data = [1.0, 2.0, 3.0]
print(neural_network.commit(trial_data))
