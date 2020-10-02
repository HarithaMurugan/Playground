#include<iostream>
#include<math.h>
#include<iomanip>
using namespace std;
int main()
{
  int x,y,vx,vy;
  cin>>x>>y>>vx>>vy;
  if(x<=0 || y<=0 || vx<=0 || vy<=0)
    cout<<"Invalid Input";
  else
  {
    double min = sqrt(x*x + y*y);
    double d;
    while(x>=0 || y>=0)
    {
      x -= vx;
      y -= vy;
      d = sqrt(x*x + y*y);
      if(d<min)
        min = d;
    }
    if(min== 0.0)
      cout<<"0.0";
    else
      cout<<fixed<<setprecision(11)<<min;
  }
  return 0;
}