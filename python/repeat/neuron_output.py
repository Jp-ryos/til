# coding: UTF-8

# ニューロンクラス
class Neuron:
    # 入力の合計を記憶する変数
    input_sum = 0.0

    #出力用変数
    output = 0.0

    # 入力データをフィールド変数に足し合わせるメソッド
    def setInput(self, inp):
        self.input_sum += inp

    #出力を行うメソッド
    def getOutput(self):
        self.output = self.input_sum
        return self.output


# ニューラルネットワーククラス
class NeuralNetwork:
    neuron = Neuron()

    # 実際にニューロンクラスに値を渡すメソッド
    def commit(self, data):
        for put_data in data:
            self.neuron.setInput(put_data)
        #最終的には出力用のメソッドを呼び返り値にする
        return self.neuron.getOutput()


# インスタンスを用意しデータを入れる
neural_network = NeuralNetwork()
trial_data = [1.0, 2.0, 3.0]
print(neural_network.commit(trial_data))

