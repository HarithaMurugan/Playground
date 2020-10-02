#include <iostream>
using namespace std;
int recur(int curr_step, long int n, int results_cache[])
{
    if(curr_step > n)
    {
      return 0;
    }
    if(curr_step == n) 
    {
        return 1;
    }
 	if(results_cache[curr_step] != -1)
 	{
 		return results_cache[curr_step];
 	}
	int total_ways =recur(curr_step + 1, n, results_cache) + recur(curr_step + 2, n, results_cache);
    
	results_cache[curr_step] = total_ways;
    return total_ways;
}
int total_ways(long int n)
{
	int results_cache[n+1], i;
	for(i = 0; i <= n; i++)
	{
		results_cache[i] = -1;
	}
	
	return recur(0,n,results_cache);
}

int main() {
	long int n;
	cin>>n;
	cout<<total_ways(n);
	return 0;
}