#include <iostream> 
#include <stack>
using namespace std;
int main()
{
   stack<char> a;
    string s;
    cin >> s;
    int flag = 0,count=0;
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] == '{' || s[i] == '[' || s[i] == '(') 
        {
            a.push(s[i]);
            flag = 1;    
        }
        if (!a.empty()) 
        {
            if (s[i] == '}') 
            {
                if (a.top() == '{')
                {
                    a.pop();
                    continue;
                }
                else
                    break;
            }
            if (s[i] == ']') 
            {
                if (a.top() == '[') 
                {
                    a.pop();
                    continue;
                }
                else
                    break;
            }
            if (s[i] == ')') 
            {
                if (a.top() == '(') 
                {
                    a.pop();
                    continue;
                }
                else
                    break;
            }
            if(s[i] == '*')
            {
                if(s[i+1] == '*')
                {
                    if(a.top() == '(' || a.top() == '{' || a.top() == '[')
                    {
                        count++;
                    }
                }
            }
        }
        else 
        {
            if(flag == 1)
            {
                flag = 0;
                break;
            }
        }
    }
    if ((a.empty()) && (flag == 1))
        cout << "Yes "<<count<<endl;
    else
        cout << "No " <<count<<endl;    
    return 0;
}