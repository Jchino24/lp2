#include <iostream>

using namespace std;
    
int main(){

    int cantidad;
    cout << "Ingrese la cantidad de monedas: ";
    cin >> cantidad;

    if (cantidad < 0) {
        cout << "La cantidad no puede ser negativa." << endl;
        return 1;
    }

    int monedas_500 = cantidad / 500;
    cantidad %= 500;

    int monedas_200 = cantidad / 200;
    cantidad %= 200;

    int monedas_100 = cantidad / 100;
    cantidad %= 100;

    int monedas_50 = cantidad / 50;
    cantidad %= 50;

    int monedas_25 = cantidad / 25;
    cantidad %= 25;

    int monedas_10 = cantidad / 10;
    cantidad %= 10;

    int monedas_5 = cantidad / 5;
    cantidad %= 5;

    int monedas_1 = cantidad;

    cout << "De 500 hay " << monedas_500 << endl;
    cout << "De 200 hay " << monedas_200 << endl;
    cout << "De 100 hay " << monedas_100 << endl;
    cout << "De 50 hay " << monedas_50 << endl;
    cout << "De 25 hay " << monedas_25 << endl;
    cout << "De 10 hay " << monedas_10 << endl;
    cout << "De 5 hay " << monedas_5 << endl;
    cout << "De 1 hay " << monedas_1 << endl;

    return 0;

}
