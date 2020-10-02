#include<iostream>
#include<math.h>
using namespace std;
float dist(float x1, float y1, float x2, float y2)
{
	return sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
}
int main()
{
	float x1,x2,y1,y2,f,lb,ub;
	cin>>x1>>y1>>x2>>y2>>f;
	lb = (x1>x2)?(ub=x1,x2):(ub=x2,x1);
	while(lb<ub)
	{
		float mid = (lb+ub)/2;
		float mid1= (lb+mid)/2;
		float mid2= (ub+mid)/2;
		
		float t1 = (dist(x1,y1,mid1,0)/f)+dist(mid1,0,x2,y2);
		float t2 = (dist(x1,y1,mid2,0)/f)+dist(mid2,0,x2,y2);
		(t1<=t2)?ub=mid:lb=mid;
	}
	printf("%0.6f",ub);
}