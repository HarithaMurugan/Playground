#include <bits/stdc++.h>
using namespace std;
static int flag = 0;
void find(int a[], int n, int k){
    sort(a,a+n);
    for (int i = 0; i < n; i++) {
        int x = a[i];
        //now problem is reduced to find two numbers in an array whose sum = M
        //here M = k - x and array from index = 1 to end
        int M = k -x;
        int start = i + 1;
        int end = n-1;
        while(start<end){
            int sum = a[start] + a[end];
            if(sum==M){
                cout<<"TRUE";
                flag = 1;
                return;
            }else if(sum<M)
                start++;
            else //sum>M
                end--;
        }
    }
}
int main() {
    int a[30],n,k;
    cin>>n;
    for(int i = 0; i<n; i++) {
        cin>>a[i];
    }
    cin>>k;
    find(a,n,k);
    if(flag == 0) {
        cout<<"FALSE";
    }
    return 0;
}