#include <iostream>
#include <math.h>
#include <limits.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<int> adj[1001];
int visit[1001];
int N, M, V;

void bfs(int start)
{
        queue<int> Q;
        Q.push(start);
        visit[start] = 1;

        while (!Q.empty())
        {
                int tmp = Q.front();
                Q.pop();
                cout << tmp << ' ';
                sort(adj[start].begin(), adj[start].end());
                for (int i = 0; i < adj[tmp].size(); i++)
                {
                        if (visit[adj[tmp][i]] == 0)
                        {
                                Q.push(adj[tmp][i]);
                                visit[adj[tmp][i]] = 1;
                        }
                }
        }
        return;
}

void dfs(int start)
{
        visit[start] = 1;
        cout << start << ' ';
        sort(adj[start].begin(), adj[start].end());
        for (int i = 0; i < adj[start].size(); i++)
        {
                if (visit[adj[start][i]] == 0)
                        dfs(adj[start][i]);
        }
        return;
}

int main()
{
        cin >> N >> M >> V;
        for (int i = 1; i <= M; i++)
        {
                int a, b;
                cin >> a >> b;
                adj[a].push_back(b);
                adj[b].push_back(a);
        }
        dfs(V);
        cout << '\n';
        for (int j = 0; j < 1001; j++)
                visit[j] = 0;
        bfs(V);
        cout << '\n';
        return 0;
}
