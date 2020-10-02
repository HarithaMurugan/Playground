#include<iostream>
#include<math.h>
using namespace std;


int prime(int b)
{
    int flag = 1;
    for(int i = 2; i <= sqrt(b); i++)
    {
        if(b % i == 0)
        {
            flag = 0;
            break;
        }
    }
    
    if(flag == 1)
        return b;
    else
        return 0;
}
int main()
{
    long long int n;
    cin >> n;
    long int count = 0;
    long long int temp;
    
    long long int sum = 2;
    long long int m = n;
    if(n>1000000&&n<100000000)//From 10 power 6 to 10 power 8
    {
        n=n/1000;
    
    }
    if(n>=100000000)
    {
        n=n/10000;
    }
      
    for(int i = 3; i <= n; i++)
    {
        temp = prime(i);
        
        if(temp)
        {
            sum = sum + temp;
            if(prime(sum) && sum <= m)
            {
                count++;
            }
        }
    }
    
    cout << count;
}