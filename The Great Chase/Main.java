#include <iostream>
using namespace std;

int main() 
{
 int i,d,z,s,l,k,c=0,j,t;
 cin>>t;
 for(j=0;j<t;j++)
 {
   cin>>i>>d>>z;
 
 c=0;
 s=1;
 while(s!=0)
 {
     i=i+d;
     for(k=2;k<=z;k++)
     {
         if(((i%k)==0)&&((z%k)==0))
         ++c;
     }
         if(c==0)
         {
           cout<<"-1"<<endl;
         break;
         }
     
     s=i%z;
     if(s==0)
     {
         l=i/z;
        cout<<l<<endl;
     }
     l=0;
 }
 }
 return 0;
}