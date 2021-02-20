#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> positive;
vector<int> negative;
int ones = 0;
int zeros = 0;
int N;
bool zerosum = false;

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        cin >> N;
        int ans = 0;
        for (int i = 0; i < N; i++)
        {
                int a;
                cin >> a;
                if (a > 1)
                        positive.push_back(a);
                else if (a < 0)
                        negative.push_back(a);
                else if (a == 1)
                        ones++;
                else if (a == 0)
                        zeros++;
        }
        if (!positive.empty())
                sort(positive.rbegin(), positive.rend());
        if (!negative.empty())
                sort(negative.begin(), negative.end());
        int pcnt = positive.size();
        int ncnt = negative.size();
        if (pcnt % 2)
        {
                for (int i = 0; i < pcnt - 1; i += 2)
                {
                        ans += positive[i] * positive[i + 1];
                }
                ans += positive[pcnt - 1];
        }
        else
        {
                for (int i = 0; i < pcnt; i += 2)
                {
                        ans += positive[i] * positive[i + 1];
                }
        }
        if (ncnt % 2)
        {
                if (zeros != 0 && !negative.empty())
                {
                        zerosum = true;
                        negative.pop_back();
                }
                for (int i = 0; i < ncnt - 1; i += 2)
                {
                        ans += negative[i] * negative[i + 1];
                }
                if (!zerosum)
                        ans += negative[ncnt - 1];
        }
        else
        {
                for (int i = 0; i < ncnt; i += 2)
                {
                        ans += negative[i] * negative[i + 1];
                }
        }
        cout << ans + ones;
        return 0;
}