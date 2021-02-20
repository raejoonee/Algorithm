#include <string>
#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

void dfs(int start, vector<int> g[], bool check[])
{
        check[start] = true;
        for (int i = 0; i < g[start].size(); i++)
        {
                if (check[g[start][i]] == false)
                {
                        dfs(g[start][i], g, check);
                }
        }
}

int main()
{
        int n, m;
        int cnt = 0;
        cin >> n >> m;
        vector<int> g[n + 1];
        for (int i = 1; i <= m; i++)
        {
                int u, v;
                cin >> u >> v;
                g[u].push_back(v);
                g[v].push_back(u);
        }
        bool check[n + 1];
        memset(check, false, sizeof(check));
        for (int i = 1; i <= n; i++)
        {
                if (check[i] == false)
                {
                        dfs(i, g, check);
                        cnt++;
                }
        }

        cout << cnt;
        return 0;
}
