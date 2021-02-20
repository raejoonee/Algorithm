#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <array>

using namespace std;

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        array<int, 10001> b = {0};
        int N;
        cin >> N;
        for (int i = 0; i < N; i++)
        {
                int ac;
                cin >> ac;
                b[ac]++;
        }
        int T = b.size();
        for (int i = 0; i < T; i++)
        {
                while (b[i])
                {
                        cout << i << '\n';
                        b[i]--;
                }
        }
        return 0;
}
