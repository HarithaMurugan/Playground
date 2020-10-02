#include<iostream>
using namespace std;
int main()
{
    int test_case, index;
    cin >> test_case;
    for(index = 1; index <= test_case; index++)
    {
        string str1, str2, result = "";
        cin >> str1 >> str2;
        int len = str2.size();
        //cout << len;
        int len1 = str1.size();
        int frequency[256]= {0};
        int i, x;
        for(i = 0; i < len; i++)
        {
            frequency[str2[i]]++;
        }
        for(i = 0; i < len1; i++)
        {
             if(frequency[str1[i]] != 0)
            {
                while(frequency[str1[i]]--)
                {
                    result = result + str1[i];
                }
            }
        }
        if(index < test_case)
            cout << result << endl;
        else
            cout << result;
    }
}