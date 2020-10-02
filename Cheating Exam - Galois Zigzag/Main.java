#include <iostream>
#include <cstring>
using namespace std;

#define MAX_LEN 1000

int main()
{
	string crypted_str;
	char decrypted_str[MAX_LEN];
	int str_len, depth, decrypted_index = 0;
	
	cin>>depth;
	cin>>crypted_str;
	
	if(depth == 1)
	{
	    cout<<crypted_str;
	    return 0;
	}
	str_len = crypted_str.length();
	int n = (str_len - 1)/(depth + (depth - 2));
	
	int col, row;
	for(col = 0; col < 2*n; col++)
	{
		int is_even_col = (col % 2) == 0;
		for(row = is_even_col ? 0 : (depth - 1); 
		          is_even_col ? (row < depth) : (row >= 0);
				  is_even_col ? row++ : row--)
		{
			int is_first_row = (row == 0);
			int is_last_row  = (row == (depth - 1));
			
			if(is_first_row && is_even_col && col != 0)
			{
			 //   printf("Skipping - 1 %d %d\n", col, row);
				continue;
			}
			
			if(is_last_row && !is_even_col)
			{
			 //   printf("Skipping - 2 %d %d\n", col, row);
				continue;
			}
			
			int elem_to_skip = is_first_row ? (col / 2) : (n - 1);
			elem_to_skip += is_last_row ? ((col + 1) / 2): 0;
			
			decrypted_str[decrypted_index++] = crypted_str[row * 2 * n + col - elem_to_skip];
		}
	}
	decrypted_str[decrypted_index] = '\0';

	// Remove the padded X
	int i;
	for(i = decrypted_index - 1; i >= 0; i--)
	{
	    if(decrypted_str[i] != 'X')
	    {
	        decrypted_str[i + 1] = '\0';
	        break;
	    }
	}
	cout<<decrypted_str;
	
	return 0;
}