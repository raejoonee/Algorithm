#include <string>
#include <iostream>
#include <sstream>

using namespace std;

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        string tmp;
        getline(cin, tmp);
        int cnt = 0;
        bool start = false;
        bool space = false;
        for (int i = 0; i <tmp.size(); i++){
                if (tmp[i] != ' ' && !start) start = true;
                if (tmp[i] == ' ' && start) cnt++;
                if (tmp[i] == ' ') space = true;
                else space = false;
        }
        if (!space) cnt++;
        cout << cnt;
        return 0;
}