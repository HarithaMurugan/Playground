#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(){
    int r1, r2, r3;
    int c1, c2, c3;
    int w1, w2, w3;
    cin>>c1>>w1>>r1;
    cin>>c2>>w2>>r2;
    cin>>c3>>w3>>r3;
    int h[5];
    for(int i = 0; i < 5; i++){
        cin>>h[i];
    }
    int r[3] = {r1, r2, r3};
    int w[3] = {w1, w2, w3};
    int c[3] = {c1, c2, c3};
    int total_cost = 0;
    for(int i = 0; i < 5; i++){
        int cost = 0;
        vector<int> v;
        for(int j = 0; j < 3; j++){
            int hr = h[i] * 730;
            cost  = hr * r[j];
            int bc = 1;
            while(hr > w[j]){
                hr = hr - w[j];
                bc++;
            }
            cost = cost + (bc * c[j]);
            v.push_back(cost);
        }
        //for(auto i = v.begin(); i != v.end(); i++)
            //cout<<*i<<" ";
        //cout<<endl;
        int min_cost = (*min_element(v.begin(), v.end()));
        if(i == 1 || i == 2 || i == 3){
            min_cost  *= 2;
        }
        total_cost = total_cost + min_cost;
    }
    cout<<total_cost;
}