#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

int main()
{
        ios_base::sync_with_stdio(false);
        vector<int> v1;
        int N, M;
        cin >> N >> M;
        for (int i = 0; i < N + M; i++)
        {
                int a;
                cin >> a;
                v1.push_back(a);
        }
        sort(v1.begin(), v1.end());
        for (int i = 0; i < v1.size(); i++)
        {
                cout << v1[i] << ' ';
        }
        return 0;
}
