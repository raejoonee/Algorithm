#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        int N, K;
        cin >> N >> K;
        vector<int> tmp;
        for (int i = 0; i < N; i++)
        {
                int a;
                cin >> a;
                tmp.push_back(a);
        }
        sort(tmp.begin(), tmp.end());
        cout << tmp[K - 1];
        return 0;
}
