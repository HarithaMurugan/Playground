#include <iostream>
#include <stack>
using namespace std;
int main()
{
    int t;
    cin>>t;
	for(int i = 0; i < t; i++){
	    int c = 0;
		stack<char> s;
		string str;
		cin >> str;
		int n = str.length();
		int flag = 1;
		int count = 0;
		if(str[0] != '{' || str[1] == '{' || str[n-1] != '}')
			flag = 0;
		else{
			for (int i = 1; i < str.length()-1; i++)
			{
				if (str[i] == '<')
				{
					s.push(str[i]);
					continue;
				}
				if(str[i] == '{'){
					if(s.top() == '(' || s.top() == '<' || s.top() == '{'){
						s.push(str[i]);
						continue;
					}
				}
				if(str[i] == '('){
					if(s.empty()){
						s.push(str[i]);
						continue;
					}
					else{
						flag = 0;
						break;
					}
				}
				if (!s.empty())
				{
					if (str[i] == '}')
					{
						if (s.top() == '{')
						{
							s.pop();
							continue;
						}
						else
							break;
					}
					if (str[i] == '>')
					{
						count++;
						if(count > 1){
							flag = 0;
							break;
						}
						if (s.top() == '<')
						{
							s.pop();
							continue;
						}
						else
							break;
					}
					if (str[i] == ')')
					{
						if (s.top() == '(')
						{
							s.pop();
							continue;
						}
						else
							break;
					}
					if(str[i] == 'P' && s.top() == '(')
					    c++;
						continue;
				}
			
			}
		}
		if(count == 0 || c > 100){
			flag = 0;
		}
		if ((s.empty()) && (flag == 1))
			cout << "No Compilation Errors"<<endl;
		else
			cout << "Compilation Errors"<<endl;
	}			
    return 0;
}