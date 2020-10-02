#include <stdio.h>
#include<iostream>
using namespace std;

int main() {
	int i,n,j;
	int k=2;    
	cin>>n;
	for(i=0;i<n;i++)
	{
	    for(int sp = 0; sp<(n-i-1);sp++)
	    printf("     ");
	    for(j=0;j<=i;j++)
	    {	
	        if(j == 0)
	        printf("%.5d",(k*(2*k-1)));
	        else
	        printf("%10.5d",(k*(2*k-1)));
            //to print in pyramid form
	        k=k+2;      
	    }
	    cout<<endl;
	}
	return 0;   
}