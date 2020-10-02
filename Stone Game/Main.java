#include<iostream>
using namespace std;

int solve(int N)
    { 
        int x,y;
        int a;                              
        int k;                              
        x=N/4;
        y=N%4;
        if(y==0)                        
          return x%2;                       
        else                                
        {
          a=0;                        
          if(x%2)                       
          {
                for(k=1;k<y;++k)      
                    a=++k;
                if(a==y)
                    return 1;
                else
                    return 0;
          }
          else                         
          {
                for(k=0;k<y;++k)        
                    a=++k;
                if(a==y)
                    return 1;
                else
                    return 0;
          }
       }
    }

    int main()
    {
        int T;                             
        int N;                              
        int result;
        int i;                          
      	cin>>T;
        if(T<1||T>1000)                 
           return 0;
        for(i=0;i<T;i++)
        {
            cin>>N;
           
            if(N<1||N>10000)                
               return 0;
            result=solve(N);
            if(result)
               cout<<"Yes"<<endl;
            else
               cout<<"No"<<endl;
        }
    return 0;
    }