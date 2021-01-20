#include <string>
#include <iostream>
#include <vector>
#include <cmath>
#include <math.h>
#include <cstdio>

using namespace std;

vector<double> pbgood(101);
vector<double> pbbad(101);

int main()
{
        int N, init;
        double gg, gb, bg, bb;
        cin >> N >> init;
        cin >> gg >> gb >> bg >> bb;
        if (init == 1)
        {
                pbgood[0] = bg;
                pbbad[0] = bb;
        }
        else
        {
                pbgood[0] = gg;
                pbbad[0] = gb;
        }
        for (int i = 1; i < N; i++)
        {
                pbgood[i] = pbgood[i - 1] * gg + pbbad[i - 1] * bg;
                pbbad[i] = pbgood[i - 1] * gb + pbbad[i - 1] * bb;
        }
        printf("%.0f\n%.0f", round(pbgood[N - 1] * 1000), round(pbbad[N - 1] * 1000));
        return 0;
}