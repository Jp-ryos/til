class Calc:
    value = 0
    def __init__(self,value=0):
        self.value = value

    def squere(self):
        s = self.value * self.value
        return s

a = Calc(3)
c = Calc()
print(a.squere())
print(c.squere())
