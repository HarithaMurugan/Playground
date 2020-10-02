#include<iostream>
#include<iomanip>
using namespace std;
void pattern(int N, int k){
    int color[2] = {1,2};
    for(int i=1;i<=N;i++){	
      int temp = color[0];
      color[0] = color[1];
      cout<< setw(k);
      for(int j=(2*i+1);j>=1;j--)cout<< "*";
      cout<<endl;
      k-=1;
      color[1] = temp;
    }
}
int main(){
    int t;
      int N,k;
      cin>>N;
      k = N;
      int l=0;
      if(N<=1)cout<<"You cannot generate christmas tree\n";
      else if(N>20)cout<<"Tree is no more\n";
      else{
        cout<<setw(k+1)<<"*"<<endl;
        pattern(N,k);
        for(int i=2;i<N;i++,l++){	
          pattern(N-1-l, k);
        }
        cout<<setw(k+1)<<"*"<<endl;
        cout<<setw(k+1)<<"*"<<endl;
      }
}