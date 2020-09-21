
from sys import stdin
def verify(input2):
    for x in input2:
        if x=="-":
            return True
        elif x=="x":
            return False
def main():
    input1=stdin.readline().strip().split()
    init=input1[0]
    final=int(input1[1])
    matriz=[]
    matriz2=[]
    dic={}
    dic2={}
    cont=1
    for i in range(8):
        fila=[]
        for j in range(8):
            if(i+j)%2==1:
                fila.append(".")
                dic[cont]=[i,j]
                cont+=1
            else:
                fila.append("-")
        matriz.append(fila)
    matriz2=[el[:] for el in matriz]
    for a in range(final):
        if a%2==0 and init=="w":
            input2=stdin.readline().strip()
            if verify(input2)==True:
                input2=input2.split("-")
                key=int(input2[0])
                matriz[dic[key][0]][dic[key][1]]=init
                key2=int(input2[1])
                matriz2[dic[key2][0]][dic[key2][1]]=matriz[dic[key][0]][dic[key][1]]
            elif verify(input2)==False:
                input2=input2.split("x")
                key=int(input2[0])
                matriz[dic[key][0]][dic[key][1]]="b"
                for i in input2[1:]:
                    if dic[key][0]%2==0:
                        key2=int(i)
                        matriz2[dic[key2][0]][dic[key2][1]]="w"
                        matriz2[dic[key+abs(key-key2)//2+1][0]][dic[key+abs(key-key2)//2+1][1]]="."
                        
                    else:
                        key2=int(i)
                        matriz2[dic[key2][0]][dic[key2][1]]="b"
                        matriz2[dic[key+abs(key-key2)//2][0]][dic[key+abs(key-key2)//2][1]]="."

                        

                    
                    
    for x in matriz:
        print(x)
    print("johann es re gurrerooooooooooo")
    for y in matriz2:
        print(y)

            
main()
