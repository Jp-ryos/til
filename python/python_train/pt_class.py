class Dog:
    name = ""
    def __init__(self,name):
        self.name = name

    def bark(self):
        m = self.name + ": Bow Bow!"
        print(m)

poti = Dog("poti")
poti.bark()