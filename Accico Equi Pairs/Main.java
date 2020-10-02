#include<iostream>
using namespace std;
int sum_num(int a, int b, int arr[], int N){
	int sum = 0;
	for(int i = a; i <= b; i++)
		sum = sum + arr[i];
	return sum;
}
int main(){
	int N;
	cin>>N;
	bool flag = false;
	int arr[N];
	for(int i = 0; i < N; i++)
		cin>>arr[i];
	int a, b, sum1 = 0, sum2 = 0, sum3 = 0;
	for(int i = 0; i < N-2; i++){
		a = i; 
		for(int j = i + 2; j < N; j++){
			b = j;
			sum1 = sum_num(0, a-1, arr, N);
			sum2 = sum_num(a+1, b-1, arr, N);
			sum3 = sum_num(b+1, N-1, arr, N);
			if(sum1 == sum2 && sum1 == sum3 && sum2 == sum3){
				cout<<"Indices which form equi pair "<<"{"<<a<<","<<b<<"}"<<endl;
				cout<<"Slices are {"<<"0,"<<a-1<<"},"<<"{"<<a+1<<","<<b-1<<"},"<<"{"<<b+1<<","<<N-1<<"}";
				flag = true;
				break;
			}
		}
		if(flag == true)
		    break;
    }
    if(flag == false){
        cout<<"Array does not contain any equi pair";
    }
    return 0;
}