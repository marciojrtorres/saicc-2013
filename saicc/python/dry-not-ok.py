def convert(m1, m2, v):
    if (m1 != 'R$' and m1 != 'US$' and m1 != 'EU$'):
        raise Exception('Moeda invalida')
    if (m2 != 'R$' and m2 != 'US$' and m2 != 'EU$'):
        raise Exception('Moeda invalida')
    if (m1 == 'R$' and m2 == 'US$'):
        return v / 2.31
    if (m1 == 'R$' and m2 == 'EU$'):
        return v / 3.09
    if (m1 == 'US$' and m2 == 'R$'):
        return v * 2.31
    if (m1 == 'EU$' and m2 == 'R$'):
        return v * 3.09
    if (m1 == 'US$' and m2 == 'EU$'):
        return v * 2.31 / 3.09
    if (m1 == 'EU$' and m2 == 'US$'):
        return v * 3.09 / 2.31


print convert('US$', 'EU$', 10)
print convert('EU$', 'R$', 7.47)
print convert('R$', 'US$', 5)
