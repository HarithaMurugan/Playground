#include<iostream>
using namespace std;
unsigned long long int combinations(unsigned long long int n,unsigned long long int r)
{
	unsigned long long int num=1,den=1,i,result;
	for(i=1;i<=r;i++)
	{
		den=den*i;
		num=num*(n-i+1);
	}
	return num/den;	
}
unsigned long long int gcd(unsigned long long int a,unsigned long long int b)
{
	unsigned long long int result,i,small;
	small=(a<b)?a:b;
	while(small>1)
	{
		if(a%small==0 && b%small==0)
			break;
		small--;
	}
	return small;
}
unsigned long long int mulinv(unsigned long long int a)
{
	unsigned long long int m=1000000007,i,b;
	for(i=1;i<m;i++)
	{
		if((i*m+1)%a==0)
		{
			b=(i*m+1)/a;
			break;
		}	
	}
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{	
		unsigned long long int N,M,T,waysOfChoosing, waysOfFailing,p,q;
		cin>>N>>M>>T;
		waysOfChoosing=combinations(N,T);
		waysOfFailing=combinations(N-M,T);
		p=waysOfChoosing-waysOfFailing;
		q=waysOfChoosing;
		unsigned long long int hcf = gcd(p,q);
		p=p/hcf;
		q=q/hcf;
		cout<<(p*mulinv(q))%1000000007<<"\n";
	}
		return 0;
}