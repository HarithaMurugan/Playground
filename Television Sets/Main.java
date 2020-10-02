#include<iostream>
#include<vector>
#include<math.h>
using namespace std;
int main()
{
	int rooms, R1,R2,target;
	cin>>rooms>>R1>>R2>>target;
	int months[]={31,28,31,30,31,30,31,31,30,31,30,31};
	vector<int>patients;
	 for(int i = 0 ; i < 12 ; i++)
	 {
		 for(int j = 0 ; j < months[i] ; j++)
		 {
			 int cnt = ((6-(i+1))*(6-(i+1)) )+abs((j+1)-15);
			 patients.push_back(cnt);
		 }
	 }
	 int cost = 0;
	 int finalcost = 0;
	 for(int tvs = 0 ; tvs <= rooms ; tvs++)
	 {
		 int normal=rooms-tvs;
		 finalcost=0;
		 for(int i=0;i<patients.size();i++)
		 {
			 cost = 0;
			   if(patients[i]>rooms)
	           {
	        	   cost=(R2*normal)+(R1*tvs);
	           }
			   else if(patients[i]<= normal)
	           {
	               cost=(R2*patients[i]);	  
	           }
	           else
	           {
	        	  int rempats = patients[i] - normal;
	        	  cost=(R2*normal)+(R1*rempats);
	           }
	           finalcost = finalcost+cost;
		 }
		 if(finalcost>=target)
		 {
			 cout<<tvs;
			 break;
		 }
		 else
		 {
			 finalcost=0;
		 }	       
	 }
	  if(finalcost<target)
	  {
		  cout<<rooms;
	  }
}