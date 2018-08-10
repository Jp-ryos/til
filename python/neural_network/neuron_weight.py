# coding: UTF-8
import math


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


# ニューラルネットワーク
class NeuralNetwork:
    #入力の重み
    w = [1.5,-2.5,-0.5]
    # ニューラルクラスのインスタンス生成
    neuron = Neuron()
    #実行
    def commit(self, input_data):
        for data,wei in zip(input_data,self.w):
            self.neuron.setinput(data * wei)
        return self.neuron.getOutput()


neural_network = NeuralNetwork()

# データ
trial_data = [1.0, 2.0, 3.0]
print(neural_network.commit(trial_data))
