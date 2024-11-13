db = [["1:starts:6"], ["7:starts:9"], ["2:end:9"]]

bd = []

for i in range(len(db)):
    db[i] = db[i][0].split(":")

for items in db:
    print(":".join(items))
