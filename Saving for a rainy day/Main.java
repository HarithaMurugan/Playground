#include<iostream>
#include<math.h>
using namespace std;

int main()
{
    int monthlypay, months;
    float rateofinterest,amount,interest,requiredmoney;
    cin>>monthlypay>>months>>rateofinterest;
    if(monthlypay<=0 || months<=0 || rateofinterest<0)
      return 0;
    else
    {
    requiredmoney = monthlypay;
    while(months--)
    {
        amount = requiredmoney/(1 + rateofinterest/(float)1200);
        interest = requiredmoney - amount;
        requiredmoney = requiredmoney+(monthlypay - interest);
    }
    requiredmoney -=  monthlypay;
    double finalamount = ceil(requiredmoney - 0.5);
    if(finalamount>requiredmoney)
        finalamount = ceil(requiredmoney);
    else
       finalamount = floor(requiredmoney);
    cout<<finalamount;
    return 0;
    }
}