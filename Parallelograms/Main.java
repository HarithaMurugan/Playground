#include<iostream>
using namespace std;

int pairfound(int angle[],int i,int n)
{
  int j;
  for(j=i+1;j<n;j++)
  {
    if(angle[i]==angle[j])
      return 1;
  }
  return 0;
}
int main()
{
  int n,i,count=0,pllgm,ang;
  cin>>n;
  int angle[n];
  for(i=0;i<n;i++)
  {
    cin>>ang;
    if(ang>=-89&&ang<=90)
        angle[i]=ang;
  }
  for(i=0;i<n;i++)
  {
    if(pairfound(angle,i,n)==1)
    {
      count++;
    }
  }
  pllgm=(count-1)*count/2;
  cout<<pllgm;
  return 0;
}