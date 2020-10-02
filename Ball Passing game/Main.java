#include<iostream>
using namespace std;

#define MAX_ROW 20
#define MAX_COL 20

#define FWD_SLASH 1
#define BACK_SLASH 2

#define DIRECTION_UP    0
#define DIRECTION_DOWN  1
#define DIRECTION_RIGHT 2
#define DIRECTION_LEFT  3

int main()
{
	int K;
	int a_pos_row, a_pos_col;
	int b_pos_row, b_pos_col;
	int play_field[MAX_ROW][MAX_COL];
	int i,j;
	
	cin>>K;
	cin>>a_pos_row>>a_pos_col;
	cin>>b_pos_row>>b_pos_col;
	
	for(i = 0; i < K; i++)
	{
		for(j = 0; j < K; j++)
		{
			cin>>play_field[i][j];
		}
	}
	
	unsigned int min_step = -1, min_barriers = -1;
	for(i = 0; i <= 3; i++)
	{
		int direction = i;
		int curr_row = b_pos_row, curr_col = b_pos_col;
		unsigned int step = 0, barrier_count = 0;
		while(1)
		{
			if(curr_col < 0 || curr_col >= K || curr_row < 0 || curr_row >= K)
			{
				break;
			}
			
			if(curr_row == a_pos_row && curr_col == a_pos_col)
			{
				if(min_step > step)
				{
					min_step = step;
					min_barriers = barrier_count;
				}
				else if (min_step == step && min_barriers > barrier_count)
				{
					min_barriers = barrier_count;
				}
				
				break;
			}
			
			step++;
			if(play_field[curr_row][curr_col] == FWD_SLASH ||
			   play_field[curr_row][curr_col] == BACK_SLASH)
			{
				barrier_count++;
			}
			
			switch(direction)
			{
				case DIRECTION_UP:
					if(play_field[curr_row][curr_col] == FWD_SLASH)
					{
						curr_col++;
						direction = DIRECTION_RIGHT;
					}
					else if(play_field[curr_row][curr_col] == BACK_SLASH)
					{
						curr_col--;
						direction = DIRECTION_LEFT;
					}
					else
					{
						curr_row--;
					}
				break;
				
				case DIRECTION_DOWN:
					if(play_field[curr_row][curr_col] == FWD_SLASH)
					{
						curr_col--;
						direction = DIRECTION_LEFT;
					}
					else if(play_field[curr_row][curr_col] == BACK_SLASH)
					{
						curr_col++;
						direction = DIRECTION_RIGHT;
					}
					else
					{
						curr_row++;
					}
				break;
				
				case DIRECTION_LEFT:
					if(play_field[curr_row][curr_col] == FWD_SLASH)
					{
						curr_row++;
						direction = DIRECTION_DOWN;
					}
					else if(play_field[curr_row][curr_col] == BACK_SLASH)
					{
						curr_row--;
						direction = DIRECTION_UP;
					}
					else
					{
						curr_col--;
					}
				break;
				
				case DIRECTION_RIGHT:
					if(play_field[curr_row][curr_col] == FWD_SLASH)
					{
						curr_row--;
						direction = DIRECTION_UP;
					}
					else if(play_field[curr_row][curr_col] == BACK_SLASH)
					{
						curr_row++;
						direction = DIRECTION_DOWN;
					}
					else
					{
						curr_col++;
					}
				break;
			}
		}
	}
	
  if(min_step != -1)
  {
	cout<<min_step<<" "<<min_barriers;
  }
  else
  {
	cout<<"-1";
  }
  
  return 0;
}