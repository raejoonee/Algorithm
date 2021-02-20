#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        vector<int> coins;
        int N, K;
        cin >> N >> K;
        for (int i = 0; i < N; i++)
        {
                int a;
                cin >> a;
                coins.push_back(a);
        }
        sort(coins.rbegin(), coins.rend());
        int ans = 0;
        while (K)
        {
                for (int i = 0; i < N; i++)
                {
                        if (K >= coins[i])
                        {
                                K -= coins[i];
                                ans++;
                                break;
                        }
                }
        }
        cout << ans;
        return 0;
}
