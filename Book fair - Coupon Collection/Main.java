#include <iostream>
#include <bits/stdc++.h> 
using namespace std;
#define MAX_STALLS 50

#define MAX(a, b) (a>b) ? a : b

int opt_coupon_collect(int coupons[], 
					   int N, 
					   int K, 
					   int curr_stall,
					   int results_cache[])
{
	// Reached end. No more stalls, return.
    if(curr_stall >= N)
    {
        return 0;
    }
    
	if(results_cache[curr_stall] != -1)
	{
		return results_cache[curr_stall];
	}
	
    int prize_if_picked = coupons[curr_stall] + 
                          opt_coupon_collect(coupons, 
										     N, 
											 K, 
											 curr_stall + K + 1,
											 results_cache);
    int prize_if_not_picked = opt_coupon_collect(coupons, 
												 N, 
												 K, 
												 curr_stall + 1,
												 results_cache);
    
    results_cache[curr_stall] = MAX(prize_if_picked, prize_if_not_picked);
	return results_cache[curr_stall];
}

int opt_coupon_collect_wrapper(int coupons[], 
							   int N, 
							   int K)
{
	int results_cache[N], i;
	for(i = 0; i < N; i++)
	{
		results_cache[i] = -1;
	}
	
	return opt_coupon_collect(coupons, 
							  N, 
							  K, 
							  0 /* Starting stall no*/,
							  results_cache);
}

int main() {
	//code
	string firstline;
    int N,K;
    int coupons[MAX_STALLS], i;
	cin>>firstline;
    stringstream ss(firstline);
    vector<int> v; 
  
    for (int i; ss >> i;) 
    { 
       v.push_back(i); 
    if (ss.peek() == ',') 
       ss.ignore(); 
    } 
  
    N = v[0];
    K = v[1];
    
	for(i = 0; i < N; i++)
	{
	    cin>>coupons[i];
	}
	
	cout<<opt_coupon_collect_wrapper(coupons, N, K);
	return 0;
}