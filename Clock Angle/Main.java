#include<iostream>
#include<iomanip>
using namespace std;
int main()
{
	int pr;
	float longitude,time;
	cin>>pr>>longitude;
	float period_of_rotation = (float)pr;
	time = (period_of_rotation/360.00)*longitude*60;
	int h = (int)time/60;
	int m = (int)time-(h*60);
	float H = h%12;//24H format to 12H format 
	float M = m;
	float angle = (11.0/2.0)*M-(30.0*H); 
	/*Angle between hands of clock if 60m=1hr 
	for a 12 dail clock since the question contains
	"irrespective of period of the earths rotation"
	this formula will be applicable for all cases*/
	if(angle<0)
		cout<<fixed<<setprecision(2)<<angle+360;
	else
		cout<<fixed<<setprecision(2)<<angle;
}