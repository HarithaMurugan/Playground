#include <bits/stdc++.h> 
#include<algorithm>
using namespace std;
int main()
{
    int n;
    cin>>n;
    int arr[n];
    for(int i = 0; i < n; i++)
    cin>>arr[i];
    sort(arr,arr+n);
    int visible_count = 0;
    char enclose[n];
    memset(enclose, 'o', sizeof(enclose)); 
    int start = 0;
    for(int i = 0; i < n; i++)
    {
        for(int j = i; j < n; j++)
        {
            if(arr[i] < arr[j])
            {
                if(enclose[j] == 'o')
                {
                    start = i+1;
                    enclose[j] = 'f';  
                    break;
                }
            }
        }
    }
    cout<<n-start;
    return 0;
}