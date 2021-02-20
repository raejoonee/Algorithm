#include <iostream>
#include <vector>
#include <string>
#include <cstring>

using namespace std;

void dfs(int start, vector<int> graph[], bool check[])
{
        check[start] = true;
        for (int i = 0; i < graph[start].size(); i++)
        {
                if (check[graph[start][i]] == false)
                {
                        dfs(graph[start][i], graph, check);
                }
        }
}

int main()
{
        int t;
        cin >> t;
        vector<int> answer;
        for (int i = 0; i < t; i++)
        {
                int n;
                int cnt = 0;
                cin >> n;
                vector<int> graph[n + 1];
                for (int j = 0; j < n; j++)
                {
                        int a;
                        cin >> a;
                        graph[j + 1].push_back(a);
                }

                bool check[n + 1];
                memset(check, false, sizeof(check));
                for (int k = 1; k <= n; k++)
                {
                        if (check[k] == false)
                        {
                                dfs(k, graph, check);
                                cnt++;
                        }
                }
                answer.push_back(cnt);
        }
        for (int i = 0; i < answer.size(); i++)
        {
                cout << answer[i] << endl;
        }
        return 0;
}
