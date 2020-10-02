#include<iostream>
using namespace std;

int main()
{
    long int n,i,s=2;;
    
    cin >> n;
  
    
    if(n>2)
    {
        if(n==3)
        cout << s;
        else
        {
        for(i=1;i<n-2;i++)
        {
            s=(s*2 + 2) % 10000000007;   
        }
        cout << s;
        }
    }
  
  	else
    {
      cout << "0";
    }
}