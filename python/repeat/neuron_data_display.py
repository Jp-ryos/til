# coding: UTF-8
import matplotlib.pyplot as plt
import math


# シグモイド関数に通し0~1の間の値を返す
def sigmoid(a):
    return 1.0 / (1.0 + math.exp(-a))


# ニューロンクラス
class Neuron:
    # 入力の合計を記憶する変数
    input_sum = 0.0

    # 出力用変数
    output = 0.0

    # 入力データをフィールド変数に足し合わせるメソッド
    def setInput(self, inp):
        self.input_sum += inp

    # 出力を行うメソッド
    def getOutput(self):
        self.output = sigmoid(self.input_sum)
        return self.output


# ニューラルネットワーククラス
class NeuralNetwork:
    neuron = Neuron()
    # 重みを設定
    weight = [0.5, 0.5, 0.5]

    # 実際にニューロンクラスに値を渡すメソッド
    def commit(self, trial):
        for data, wei in zip(trial, self.weight):
            # 重みとデータを掛けたものを渡す
            self.neuron.setInput(data * wei)
        # 最終的には出力用のメソッドを呼び返り値にする
        return self.neuron.getOutput()

#基準点を作成
refer_point_0 = 34.5
refer_point_1 = 137.5


#データを読むためにファイル処理
trial_data = []
trial_data_file = open("trial_data", "r")
for line in trial_data_file:
    line = line.rstrip().split(",")
    trial_data.append([float(line[0]) - refer_point_0, float(line[1]) - refer_point_1])
trial_data_file.close()

# インスタンスを用意しデータを入れる
neural_network = NeuralNetwork()
position = [[], []]
for data in trial_data:
    position[0].append(data[1] + refer_point_1)
    position[1].append(data[0] + refer_point_0)

#matplotlibで散布図を描画
plt.scatter(position[0], position[1], c="red",label="Position", marker="+")
plt.legend()
plt.show()

