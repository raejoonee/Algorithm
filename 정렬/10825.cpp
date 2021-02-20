#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

struct Student
{
        string name;
        int kor;
        int eng;
        int mat;
};

bool compare(Student a, Student b)
{
        if (a.kor > b.kor)
        {
                return true;
        }
        else if (a.kor == b.kor)
        {
                if (a.eng < b.eng)
                {
                        return true;
                }
                else if (a.eng == b.eng)
                {
                        if (a.mat > b.mat)
                        {
                                return true;
                        }
                        else if (a.mat == b.mat)
                        {
                                if (a.name < b.name)
                                        return true;
                                else
                                        return false;
                        }
                        else
                        {
                                return false;
                        }
                }
                else
                {
                        return false;
                }
        }
        else
        {
                return false;
        }
}

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        int N;
        cin >> N;
        vector<Student> v;
        for (int i = 0; i < N; i++)
        {
                string a;
                int b, c, d;
                cin >> a >> b >> c >> d;
                Student tmp = {a, b, c, d};
                v.push_back(tmp);
        }
        sort(v.begin(), v.end(), compare);
        for (int i = 0; i < N; i++)
        {
                cout << v[i].name << '\n';
        }
        return 0;
}
