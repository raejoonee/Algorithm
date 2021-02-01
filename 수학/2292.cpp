#include <iostream>

using namespace std;

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        int N; cin >> N;
        int dflt = 1;
        int summer = 1;
        while(true){
                if (N <= dflt) break;
                dflt += 6*summer;
                summer++;
        }
        cout << summer;
        return 0;
}