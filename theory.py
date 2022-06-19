import math

def entropy(password):
    length = 0 
    used = []  
    alpha = {'numbers':'1234567890', 'low':'qwertyuiopasdfghjklzxcvbnm', \
    'up':'QWERTYUIOPASDFGHJKLZXCVBNM'} 
    for i in range(0, len(password)):
        symbol = password[i]; 
        for key in alpha: 
            if symbol in alpha.get(key) and key not in used: 
                length += len(alpha.get(key)) 
                used.append(key) 
    result = len(password)*math.log2(length) 
    print("entropy: " + str(result)) 
pAss = input('password: ')
entropy(pAss)
