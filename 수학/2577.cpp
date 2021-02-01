#include <iostream>

using namespace std;

int A, B, C;

int main(){
        int ans[10] = {0};
        cin >> A >> B >> C;
        int tmp = A*B*C;

        do {
                ans[tmp%10]++;
                tmp /= 10;
        } while (tmp>=10);

        ans[tmp]++;
        for (int i=0;i<10;i++){
                cout << ans[i] << endl;
        }
        return 0;
}