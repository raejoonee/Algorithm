#include <string>
#include <iostream>
#include <sstream>

using namespace std;

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        int A, B, C; cin >> A >> B >> C;
        if (B-C >= 0) cout << -1;
        else cout << (-1*A)/(B-C)+1;
        return 0;
}