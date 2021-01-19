#include <iostream>
#include <stdio.h>

using namespace std;

int N, A, B;

int main(){
        cin >> N;
        int tmp = N;
        int ans = 0;
        do {
                A = tmp/10;
                B = tmp%10;
                tmp = (10*B) + ((A + B)%10);
                ans++;
        } while (tmp != N);
        cout << ans << endl;
        return 0;
}