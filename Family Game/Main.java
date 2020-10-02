#include <iostream>
using namespace std;
int main()
{
    int n;
    string s;
    cin>>n;
    cin>>s;
    int z=n;
    int l=s.length();
    bool arr[n];
    for(int b=0;b<n;b++)
    {
        arr[b] = true;
    }
    int i=0,j=0;
    while(n != 1)
    {
     if ( arr[i] == true)
     {
         if(s[j] == ('y') )
         {
             arr[i] = false;
             n--;
             j++;
         }
         else
         {
             j++;
         }
     }
     i++;
     if( i>= z)
     {
         i=0;
     }
     if( j>= l)
     {
         j=0;
     }
    }
    int r;
    for(int q=0;q<z;q++)
    {
        if(arr[q] == true )
        {
            r=q;
        }
    }
    cout<<r+1;
}
 