#include <string>
#include <iostream>
#include <sstream>
#include <cmath>
#include <algorithm>

using namespace std;

long long comp(long long a, long long b){
        if (a == 0) return 1;
        if (b == 0) return 1;
        if (a == 1) return 1;
        if (b == 1) return a;
        long long cut1 = a - b + 1;
        long long cut2 = a - b;
        long long boonja = a;
        long long boonmo = 1;
        long long c = 1;
        while (true){
                a--;
                c++;
                boonja *= a;
                boonmo *= c;
                if (a == cut1) break;
                if (c == cut2) break;
        }
        return boonja/boonmo;
}

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        int N, M; cin >> N >> M;
        cout << comp(M-1, M-N);
        return 0;
}