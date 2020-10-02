#include<iostream>
using namespace std;
int main()
{
    int a[100],i,j,k,max=0,n,maxi,f=0;
    cin>>n;
    for(i=0;i<n;i++)
        cin>>a[i];
    maxi=0;
    for(i=0;i<n-1;i++)
    {
        f++;
        if(a[i] > a[i+1])
        {
            if(f>max)
            {
                max=f;
                maxi=i-f+1;
            }
            f=0;
        }
    }
    f++;
    if(f>max)
    {
        max=f;
        maxi=i-f+1;
    }
    for(i=maxi;i<maxi+max;i++)
    {
        cout<<a[i]<<" ";
    }
    return 0;
}