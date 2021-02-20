#include <vector>
#include <string>
#include <iostream>

using namespace std;


int main(){
    vector<long long> zeros;
    vector<long long> ones;
    zeros.push_back(0);
    ones.push_back(1);
    int N;
    cin >> N;
    for (int i = 0; i < N; i++){
        zeros.push_back(zeros[i]+ones[i]);
        ones.push_back(zeros[i]);
    }
    cout << zeros[N-1]+ones[N-1];
    return 0;
    
}