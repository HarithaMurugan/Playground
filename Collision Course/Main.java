#include<bits/stdc++.h>
#include<map>
using namespace std;
int main()
{
	int n,i;
	cin>>n;
	int x[n],y[n],v[n];
	for(i=0;i<n;i++)
	{
		cin>>x[i]>>y[i]>>v[i];
	}
	for(i=0;i<n;i++)
	{
		v[i]=(sqrt(x[i]*x[i]+y[i]*y[i]))/v[i];
	}
	int count=0,j;
	map<int, int> freq;
	for (int i=0; i<n; i++) 
		freq[v[i]]++; 
	bool dup = false;
	map<int, int>:: iterator itr; 
	for (itr=freq.begin(); itr!=freq.end(); itr++) 
	{ 
		if (itr->second > 1) 
		{ 
          	count=count+(itr->second*(itr->second-1)/2);
		} 
	} 
  	cout<<count;
}