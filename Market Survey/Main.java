#include<iostream>
using namespace std;
int main()
{
	int n,m,i,j,k,l;
	cin>>n>>m;
	int a[m+1][n],finalkey[n];
	for(i=0;i<=m;i++)
	{
		for(j=0;j<n;j++)
			cin>>a[i][j];
	}
	int option[5]={0};
	for(i=0;i<n;i++)//copying default key to compare further
	    finalkey[i]=a[0][i];
	for(l=1;l<=m;l++)
	{
	    int score=0;
		j=0;
		while(j<n)//calculating instant score 
		{
		    if(finalkey[j]==a[l][j])
			{
				score++;
			}
			j++;
		}
		cout<<score<<"\n";
		for(i=0;i<n;i++)//modifying the key based on current persons answer
		{
			int max=0,maxcount=0;
			option[1]=option[2]=option[3]=option[4]=0;//initialising the option frequency to zero
			for(j=0;j<=l;j++)//updating no.of times an option is selected for each question
			{
				option[a[j][i]]++;
			}
//			for(j=1;j<5;j++)
//			cout<<option[j]<<" ";
//			cout<<"\n";
			for(k=1;k<5;k++)//checking which option has been selected the most
			{
				if(option[k]>max)
				{
					max=option[k];
					finalkey[i]=k;
				}
			}
			for(k=1;k<5;k++)//finding any options selected for same number of time
			{	
				if(max==option[k])
				maxcount++;
			}
			int flag=1;
			if(maxcount>1) // incase of similar options selecting the latest
			{
				for(j=l;j>0;j--)
				{
					for(k=1;k<5;k++)
					{
						if((a[j][i]==k) && (option[k]==max) &&(flag==1))
						{
							finalkey[i]=k;
							flag=0;
							break;
						}
					}
				}
			}
		}
//		for(i=0;i<n;i++)
//			cout<<finalkey[i]<<" ";
//		cout<<"\n";
	}
	int maxscore=0,maxperson=0;
	for(i=1;i<=m;i++)//calculating the topper guy
	{
		int score=0;
		for(j=0;j<n;j++)
		{
			if(finalkey[j]==a[i][j])
			{
				score++;
			}
		}
		//cout<<"Score of person"<<i<<":"<<score<<"\n";
		if(score>maxscore)//incase of similar score print the person who wrote first among them
		{
			maxscore=score;
			maxperson=i;
		}
	}
	cout<<maxperson<<" "<<maxscore;
}