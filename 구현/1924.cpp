#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

int main(){
        int M, D, ans, sunday;
        cin >> M >> D;
        switch (M){
                case 1:
                        sunday = 0;
                        break;
                case 2:
                        sunday = 4;
                        break;
                case 3:
                        sunday = 4;
                        break;
                case 4:
                        sunday = 1;
                        break;
                case 5:
                        sunday = 6;
                        break;
                case 6:
                        sunday = 3;
                        break;
                case 7:
                        sunday = 1;
                        break;
                case 8:
                        sunday = 5;
                        break;
                case 9:
                        sunday = 2;
                        break;
                case 10:
                        sunday = 0;
                        break;
                case 11:
                        sunday = 4;
                        break;
                case 12:
                        sunday = 2;
                        break;
        }
        string sheet[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        if ((D%7-sunday) < 0) cout << sheet[abs(D%7-sunday+7)] << endl;
        if ((D%7-sunday) >= 0) cout << sheet[abs(D%7-sunday)] << endl;
        return 0;

}