#include <vector>
#include <string>
#include <iostream>

using namespace std;

int main(){
    vector<long long> zeros;
    vector<long long> ones;
    zeros.push_back(0);
    ones.push_back(1);
    int N; cin >> N;
    for (int i = 0; i < N; i++){
        zeros.push_back(zeros[i]%15746 + (ones[i]%15746));
        ones.push_back(zeros[i]%15746);
    }
    cout << (zeros[N] + ones[N]) % 15746;
    return 0;
}