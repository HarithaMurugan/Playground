#include<iostream>
using namespace std;
int convert_to_base(int no, int base)
{
	int store[100], index = 0;	
	while(no > 0)
	{
		int quot = no / base;
		int rem  = no % base;
		store[index++] = rem;		
		no = quot;
	}	
	int converted_no = 0, i;
	for(i = index - 1; i >= 0; i--)
	{
		converted_no = converted_no * 10 + store[i];
	}	
	return converted_no;
}
int compute_sum_of_digits(int n)
{
	int sod = 0;
	while(n > 0)
	{
		sod = sod + n % 10;
		n = n / 10;
	}	
	return sod;
}
int main() {
    int b, t;
	cin >> b >> t;
	int i, count = 0;
	for(i = b; ; i++)
	{
	 	int tmp   = convert_to_base(i, b);
		int sod = compute_sum_of_digits(tmp);
		if(i % sod == 0)
		{
			count++;
		} 
		else
		{
		    if(count == t)
		    {
		        break;
		    }
			count = 0;
		}
	}	
	cout << convert_to_base(i-t, b);
    return 0;
}