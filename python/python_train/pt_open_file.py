j = []

j_file = open("Juice")

for data in j_file:
    data = data.rstrip().split(",")
    j.append([data[0], int(data[1])])

j_file.close()

print(j)
