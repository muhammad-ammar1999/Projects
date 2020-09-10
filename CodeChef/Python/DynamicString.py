def check(l):
    if len(l) < 3:
        return "Dynamic"
    else:
        if l[3] != l[2] + l[1]:
            l[0],l[1] = l[1],l[0]
        for i in range(2,len(l)):
            if l[i] != l[i-1] + l[i-2]:
                return "Not"
        return "Dynamic"
        
for _ in range(int(input())):
    s = input()
    d={}
    for i in s:
        if i in d:
            d[i] += 1
        else:
            d[i] = 1
    l = list(d.values())
    l.sort()
    #print(l)
    print(check(l))