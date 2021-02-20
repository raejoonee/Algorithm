#include <iostream>
#include <math.h>
#include <limits.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int M, N;
int tomato[1001][1001];
int visit[1001][1001];
int mr[4] = {0, 0, -1, 1};
int mc[4] = {-1, 1, 0, 0};
queue<pair<int, int>> Q;

void bfs()
{
        while (!Q.empty())
        {
                int tmp_i = Q.front().first;
                int tmp_j = Q.front().second;
                Q.pop();
                for (int i = 0; i < 4; i++)
                {
                        int nr = tmp_i + mr[i];
                        int nc = tmp_j + mc[i];

                        if (0 <= nr && nr < N && 0 <= nc && nc < M && !visit[nr][nc] && tomato[nr][nc] != -1)
                        {
                                Q.push(make_pair(nr, nc));
                                visit[nr][nc] = 1;
                                tomato[nr][nc] = tomato[tmp_i][tmp_j] + 1;
                        }
                }
        }
}

int main()
{
        cin >> M >> N;
        for (int i = 0; i < N; i++)
        {
                for (int j = 0; j < M; j++)
                {
                        cin >> tomato[i][j];
                        if (tomato[i][j] == 1)
                        {
                                Q.push(make_pair(i, j));
                                visit[i][j] = 1;
                        }
                }
        }
        bfs();
        int tmp = 0;
        for (int i = 0; i < N; i++)
        {
                for (int j = 0; j < M; j++)
                {
                        if (tomato[i][j] == 0)
                        {
                                cout << -1 << '\n';
                                return 0;
                        }
                        tmp = max(tmp, tomato[i][j]);
                }
        }
        cout << tmp - 1 << '\n';
        return 0;
}
