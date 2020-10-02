#include<bits/stdc++.h> 
using namespace std; 
int minCans(int cans[], int m, int V) 
{ 
	int table[V+1]; 
	table[0] = 0; 
	for (int i=1; i<=V; i++) 
		table[i] = INT_MAX; 
	for (int i=1; i<=V; i++) 
	{ 
		for (int j=0; j<m; j++) 
		if (cans[j] <= i) 
		{ 
			int sub_res = table[i-cans[j]]; 
			if (sub_res != INT_MAX && sub_res + 1 < table[i]) 
				table[i] = sub_res + 1; 
		} 
	} 
	return table[V]; 
} 
int main() 
{ 
	int cans[] = {1,5,7,10}; 
	int m = sizeof(cans)/sizeof(cans[0]); 
	int V,i,n;
    cin>>n;   
  	for(i=0;i<n;i++)
      { 
        cin>>V; 
	    cout << minCans(cans, m, V)<<endl; 
      }
	return 0; 
} 