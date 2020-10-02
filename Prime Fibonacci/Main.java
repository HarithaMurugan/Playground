#include<bits/stdc++.h>
#include<vector>
using namespace std;
int isprime(int n)
{
	int i,flag=1;
	for(i=2;i<=sqrt(n);i++)
	{
		if(n%i==0)
		{
			flag=0;
			break;
		}
	}
	return flag;
}
void concat(int a, int b, vector<int> &v)
{
	int temp=b;
	while(temp)
	{
		temp=temp/10;
		a=a*10;
	}
	v.push_back(a+b);
}
unsigned long long int fib(int t1, int t2, int n)
{
	int i;
	unsigned long long int sum=0,n1,n2;
	n1=(unsigned long long int)t1;
	n2=(unsigned long long int)t2;
	if(n==1)
		return t1;
	else if(n==2)
		return t2;
	else
	{
		for(i=2;i<n;i++)
		{
			sum=n1+n2;
			n1=n2;
			n2=sum;
			//cout<<sum<<" ";
		}
	}
	return sum;
}
int main()
{
	int n1,n2,i,j;
	cin>>n1>>n2;
	vector<int> list1,list2;
	for(i=n1;i<=n2;i++)
	{
		if(isprime(i))
			list1.push_back(i);
	}
	/*for(i=0;i<list1.size();i++)
	{
		cout<<list1[i]<<" ";
	}
	cout<<"\n";*/
	for(i=0;i<list1.size();i++)
	{
		for(j=0;j<list1.size();j++)
		{
			if(i!=j)
			{
				concat(list1[i],list1[j],list2);
			}
		}
	}
	list1.clear();
	for(i=0;i<list2.size();i++)
	{
		if(isprime(list2[i]))
		{
			vector<int>::iterator it=find(list1.begin(),list1.end(),list2[i]);
			if(it==list1.end())
				list1.push_back(list2[i]);
		}
	}
	/*for(i=0;i<list1.size();i++)
		cout<<list1[i]<<" ";
	cout<<"\n";*/
	int t1 = *min_element(list1.begin(),list1.end());
	int t2 = *max_element(list1.begin(),list1.end());
	cout<<fib(t1,t2,list1.size());
}