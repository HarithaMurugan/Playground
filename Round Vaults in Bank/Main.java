#include <iostream>
using namespace std;

#define MAX_VAULTS 30

#define MAX(a, b) (a>b) ? a : b

int can_i_steal(int stolen_vaults[],
			    int n,
				int curr_vault)
{
    int vault_idx, j;
	for(vault_idx = curr_vault - 4; vault_idx <= curr_vault; vault_idx++)
	{
        int count = 0;
        for(j = vault_idx; j < (vault_idx + 5); j++)
        {
            int idx = j;
            if(idx < 0)
            {
                idx = n + idx;
            }
            else if(idx >= n)
            {
                idx = idx % n;
            }
            
            if(stolen_vaults[idx] == 1)
            {
                count++;
            }
        }
    
        if(count >= 2)
        {
            return 0;
        }
	}
	
	return 1;
}

int max_stealing_opt(int vault_values[], 
					 int n, 
					 int stolen_vaults[],
					 int current_vault)
{
	// Have reached the end of street
    if(current_vault >= n)
    {
		int i, values = 0;
		for(i = 0; i < n; i++)
		{
			if(stolen_vaults[i] == 1)
			{
				values += vault_values[i];
			}
		}
		
        return values;
    }
	
    int if_stolen = 0;
	if(can_i_steal(stolen_vaults, n, current_vault))
    {        
        stolen_vaults[current_vault] = 1;
        if_stolen = max_stealing_opt(vault_values, 
									 n, 
									 stolen_vaults,
									 current_vault + 1);
    }
    
	// If not stolen
	stolen_vaults[current_vault] = 0;
	int if_not_stolen = max_stealing_opt(vault_values, 
								         n, 
										 stolen_vaults,
								         current_vault + 1);
    
    return MAX(if_stolen, if_not_stolen);
}

int max_stealing_opt_wrapper(int vault_values[], int n)
{	
	int stolen_vaults[n], i;
	for(i = 0; i < n; i++)
	{
		stolen_vaults[i] = 0;
	}
	
	return max_stealing_opt(vault_values, 
						    n,
							stolen_vaults,
						    0/* Starting from 0th house*/);
}

int main() {
	//code
	int n, vault_values[MAX_VAULTS], i;
	
	// Total houses
	cin>>n;
	
	// Values at each house
	for(i = 0; i < n; i++)
	{
	    cin>>vault_values[i];
	}
	
	cout<<max_stealing_opt_wrapper(vault_values, n);
	return 0;
}