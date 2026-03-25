import socket

HOST = 'localhost'
PORT = 5000

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST, PORT))
server.listen()

print("servidor rodando...")

conn, addr = server.accept()
print("conectado por:", addr)

data = conn.recv(1024).decode()

try:
    base_str, altura_str = data.split(",")

    base = float(base_str)
    altura = float(altura_str)

    if base <= 0 or altura <= 0:
        resposta = "ERRO: valores devem ser positivos"
    else:
        area = (base * altura) / 2
        resposta = f"area = {area}"

except:
    resposta = "ERRO: entrada inválida"

conn.send(resposta.encode())

conn.close()
server.close()