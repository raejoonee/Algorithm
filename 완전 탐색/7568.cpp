#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        vector<pair<int, int>> ppl;
        int N;
        cin >> N;
        for (int i = 0; i < N; i++)
        {
                int x, y;
                cin >> x >> y;
                ppl.push_back(make_pair(x, y));
        }
        for (int i = 0; i < N; i++)
        {
                int rank = 1;
                for (int j = 0; j < N; j++)
                {
                        if (i == j)
                                continue;
                        if (ppl[i].first < ppl[j].first && ppl[i].second < ppl[j].second)
                                rank++;
                }
                cout << rank << ' ';
        }
        return 0;
}
