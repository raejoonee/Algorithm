#include <iostream>

using namespace std;

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        int T; cin >> T;
        int ans = T / 5;
        if (T % 5 != 0) ans++;
        cout << ans;
        return 0;
}