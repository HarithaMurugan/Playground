#include <iostream>
using namespace std;

int largestPower(int n, int p){
    
    int x = 0;
 
    while (n){
        n /= p;
        x += n;
    }
    return x;
}

int main(){
    int test;
    cin >> test;
    while(test--){
        int n, p;
        cin >> n >> p;
        
        cout << largestPower(n, p);
        cout << endl;
    }
}