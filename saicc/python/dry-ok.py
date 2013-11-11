class Moeda:
    BRL = 0
    USD = 1
    EUR = 2

conversions = {Moeda.BRL: 1, Moeda.USD: 2.31, Moeda.EUR: 3.09}

def convert2(m1, m2, v):
    if (m1 not in conversions or m2 not in conversions):
        raise Exception('Moeda invalida')
    return v * (conversions[m1] / conversions[m2])

print convert2(Moeda.USD, Moeda.EUR, 10)
print convert2(Moeda.EUR, Moeda.BRL, 7.47)
print convert2(Moeda.BRL, Moeda.USD, 5)
