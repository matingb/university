from pwn import *
import json
import base64
import binascii
import codecs
import sys
from Crypto.Util.number import *

r = remote('socket.cryptohack.org', 13377, level = 'debug')

def json_recv():
    line = r.recvline()
    return json.loads(line.decode())

def json_send(hsh):
    request = json.dumps(hsh).encode()
    r.sendline(request)

def decode(t, data):
    if t == 'base64':
        return base64.b64decode(data).decode('utf-8')
    elif t == 'hex':
        return bytes.fromhex(data).decode('utf-8')
    elif t == 'bigint':
        return bytes.fromhex(data.replace('0x', '')).decode('utf-8')
    elif t == 'rot13':
        return codecs.encode(data, 'rot_13')
    elif t == 'utf-8':
        return "".join(chr(i) for i in received["encoded"])

while True:

    received = json_recv()

    if "flag" in received:
        print("FLAG: %s" % received["flag"])
        sys.exit(0)

    decifrado = decode(received["type"], received["encoded"])
    print("\nDecifrado " + decifrado);

    to_send = {
        "decoded": decifrado
    }

    json_send(to_send)

