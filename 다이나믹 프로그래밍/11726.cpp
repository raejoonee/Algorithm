#include <string>
#include <iostream>
#include <vector>

using namespace std;

int main()
{
        int a;
        cin >> a;
        vector<long long> dp;
        dp.push_back(0);
        dp.push_back(1);
        dp.push_back(2);
        for (int i = 2; i < a; i++)
        {
                dp.push_back((dp[i] + dp[i - 1]) % 10007);
        }
        cout << dp[a];
        return 0;
}
