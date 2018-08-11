# coding: UTF-8

# ニューロンクラス
class Neuron:
    # 入力の合計を記憶する変数
    input_sum = 0.0

    # 入力データをフィールド変数に足し合わせるメソッド
    def setInput(self, inp):
        self.input_sum += inp
        print(self.input_sum)


# ニューラルネットワーククラス
class NeuralNetwork:
    neuron = Neuron()

    # 実際にニューロンクラスに値を渡すメソッド
    def commit(self, data):
        for put_data in data:
            self.neuron.setInput(put_data)


# インスタンスを用意しデータを入れる
neural_network = NeuralNetwork()
trial_data = [1.0, 2.0, 3.0]
neural_network.commit(trial_data)
