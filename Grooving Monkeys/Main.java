#include<iostream>
using namespace std;
int main()
{
	int T;
	cin>>T;
	while(T)
	{
		int n,i,j,count=1;
		cin>>n;
		int a[n];
		char alpha[n],a1[n],a2[n],ch='a';
		for(i=0;i<n;i++)
		{
			cin>>a[i];
			a1[i] = ch++;
			alpha[i] = a1[i];
		}
		while(1)
		{	
			int count1=0;
			for(i=0;i<n;i++)
			{
				a2[a[i]-1] = a1[i];
			}
			for(i=0;i<n;i++)
			{
				if(a2[i] == alpha[i])
					count1++;
			}
			if(count1 == n)
				break;
			else
			{
				for(i=0;i<n;i++)
					a1[i] = a2[i];
			}
			count++;
		}
		cout<<count<<endl;
		T--;
	}
}