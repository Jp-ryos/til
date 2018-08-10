# coding: UTF-8

# ニューロン
class Neuron:
    input_sum = 0.0

    def setinput(self, inp):
        self.input_sum += inp
        print(self.input_sum)


# ニューラルネットワーク
class NeuralNetwork:
    # ニューラルクラスのインスタンス生成
    neuron = Neuron()

    def commit(self, input_data):
        for data in input_data:
            self.neuron.setinput(data)


neural_network = NeuralNetwork()

# データ
trial_data = [1.0, 2.0, 3.0]
neural_network.commit(trial_data)
