#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
void rotateleft(string& str)
{
    string s=str;
    for(int j=0;j<str.size();j++)
    {
        s[j]=str[(j+1)%str.size()];
    }
    str=s;
}
void rotateright(string& str)
{ 
    string s=str;
    s[0]=str[str.size()-1];
    for(int j=str.size()-1;j>0;j--)
    {
        s[j]=str[j-1];
    }
    str=s;
}
bool areAnagram(string str1, string str2)
{
    int n1 = str1.length();
    int n2 = str2.length();
    if (n1 != n2)
        return false;
    sort(str1.begin(), str1.end());
    sort(str2.begin(), str2.end());
    for (int i = 0; i < n1; i++)
        if (str1[i] != str2[i])
            return false;
    return true;
}
int main()
{ 
    string str; 
    cin>>str; 
    int no_rotation;
    cin>>no_rotation;
    string s;
    char d[no_rotation];
    int r[no_rotation];
    string temp = str;
        for(int i = 0; i < no_rotation; i++)
            cin>>d[i]>>r[i];
    for(int k = 0; k < no_rotation; k++)
    { 
        if(d[k] == 'L'){
            for(int i = 0; i < r[k]; i++)
                 rotateleft(str); 
            s = s + str[0];
        }
        else if(d[k] == 'R'){
            for(int i = 0; i < r[k]; i++)
                 rotateright(str);
            s = s + str[0];
        }
    }
    bool is_true = false;
    int pos = s.length();
    for(int i = 0; i < temp.length(); i++){
         string r = temp.substr(i, pos);
         if(areAnagram(s, r))
         {
             is_true = true;
             break;
         }
    }
    if(is_true == true)
        cout<<"YES";
    else
        cout<<"NO";
    return 0;
}