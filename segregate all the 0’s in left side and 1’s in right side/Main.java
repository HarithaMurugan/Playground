#include <iostream>
using namespace std;
void segregate0and1(int arr[], int n)
{   
	int left = 0, right = n-1;       
	while(1)     
	{       
		if(left >= right)              
			break;       
		if(arr[left] == 0) 
			left++;          
		else if(arr[right] == 1) 
			right--; 
		else
		{         
			arr[left]  = 0;         
			arr[right] = 1;         
			left++;         
			right--;       
		}     
	}
} 
int main() 
{ 
	int n;
	cin>>n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin>>arr[i];
	segregate0and1(arr, n); 
	for(int i=0;i<n;i++)
		cout<<arr[i];
	return 0; 
} 
