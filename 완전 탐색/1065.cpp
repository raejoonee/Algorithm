#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool val(int n){
        bool ans = true;
        int tmp = n % 10;
        n /= 10;
        int chai = (n % 10 - tmp);
        while (n / 10){
                tmp = n % 10;
                n /= 10;
                ans *= (chai == (n%10-tmp));
        }
        return ans;
}

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        int ans = 0;
        int s; cin >> s;
        if (s <= 99) cout << s;
        else {
                for (int i = 1; i <= s; i++){
                        if (val(i)) ans++;
                }
                cout << ans;
        }
        return 0;
}