p = 857504083339712752489993810777 
q = 1029224947942998075080348647219

totient = (p - 1) * (q - 1)
exponente = 65537

# Al hacer esto en vez de elevar a la -1 y calcular el modulo
# Lo que hace es buscar el valor de X para: exponente * x ≡ 1 (mod totient)
resultado = pow(exponente, -1, totient);

print(resultado);