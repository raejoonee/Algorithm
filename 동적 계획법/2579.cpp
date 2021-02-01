#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
        ios_base::sync_with_stdio(false);
        int N;
        vector<int> stairs;
        vector<int> dp;
        cin >> N;
        stairs.push_back(0);
        stairs.push_back(0);
        dp.push_back(0);
        dp.push_back(0);
        for (int i = 0; i < N; i++){
                int a;
                cin >> a;
                stairs.push_back(a);
        }
        for (int i = 2; i < N+2; i++){
                if (i == 2){
                        dp.push_back(stairs[i]);
                        continue;
                }
                dp.push_back(max(stairs[i]+stairs[i-1]+dp[i-3], stairs[i]+dp[i-2]));
                // cout << "stairs[i]: " << stairs[i] << ", stairs[i-1]: " << stairs[i-1] << ", dp[i-3]: " << dp[i-3] << endl;
                // cout << dp[0] << ' ' << dp[1] << ' ' << dp[2] << endl;
                // cout << "first: " << stairs[i] + stairs[i - 1] + dp[i - 3] << ", second: " << stairs[i] + dp[i - 2] << endl;
        }
        // for (int i = 0; i < dp.size(); i++){
        //         cout << dp[i] << ' ';
        // }
        cout << dp[dp.size()-1];
        return 0;
}