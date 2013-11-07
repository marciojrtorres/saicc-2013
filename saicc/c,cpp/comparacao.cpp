#include <iostream>
#include <stdlib.h>

using namespace std;

int main() {
    int v;
    cin >> v;
    
    cout << "v is " << v << endl;
        
    if (v = 1) { // esta errado, mas compila
        cout << "v equals 1" << endl;
    } else {
        cout << "v not equals 1" << endl;
    }
    
    // prefira assim if (1 == v) em vez if (v == 1)
    
    return 0;
}
