#include <iostream>

using namespace std;


int main(){
        int N;
        int ans = 0;
        cin >> N;

        while (N>0){
                if (N%5 == 0){
                        N-=5;
                        ans++;
                } else if (N%3 == 0){
                        N-=3;
                        ans++;
                } else if (N>5){
                        N-=5;
                        ans++;
                } else {
                        ans--;
                        break;
                }
        }
        cout << ans << endl;
}