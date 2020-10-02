#include<bits/stdc++.h>
using namespace std;
int main()
{
    int test_case;
    cin >> test_case;
    for(int i = 0; i < test_case; i++)
    {
        int total;
        cin >> total;
        int count = 0;
        while(total != 0)
        {
            count++;
            total = total >> 1;
        }
        cout << count << endl;
    }
}