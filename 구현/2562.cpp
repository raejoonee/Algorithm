#include <iostream>
#include <math.h>

using namespace std;

int N, mx, tmp;

int main(){
        int ans[9];
        mx = 0;
        tmp = 0;
        for (int i = 1; i<10;i++){
                cin >> ans[i];
                if (mx < ans[i]){
                        mx = ans[i];
                        tmp = i;
                }
        }
        cout << mx << endl << tmp << endl;
}