#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        vector<long long> cards;
        int n, m; cin >> n >> m;
        for (int i = 0; i < n; i++){
                long long a; cin >> a;
                cards.push_back(a);
        }
        while (m){
                sort(cards.begin(), cards.end());
                long long tmp = cards[0];
                cards[0] += cards[1];
                cards[1] += tmp;
                m--;
        }
        long long ans = 0;
        for (int i = 0; i < n; i++){
                ans += cards[i];
        }
        cout << ans;
        return 0;
}