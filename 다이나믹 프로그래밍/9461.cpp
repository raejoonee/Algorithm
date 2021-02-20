#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<long long> P;

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        int T;
        cin >> T;
        vector<long long> answer;
        for (int i = 0; i < T; i++)
        {
                P.push_back(1);
                P.push_back(1);
                P.push_back(1);
                P.push_back(2);
                P.push_back(2);
                int a;
                cin >> a;
                if (a <= 5)
                        answer.push_back(P[a - 1]);
                else
                {
                        for (int i = 5; i < a; i++)
                        {
                                P.push_back(P[i - 5] + P[i - 1]);
                        }
                        answer.push_back(P[a - 1]);
                }
                P.clear();
        }
        for (int i = 0; i < answer.size(); i++)
        {
                cout << answer[i] << '\n';
        }
        return 0;
}
