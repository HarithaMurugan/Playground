#include<iostream>
using namespace std;
#define MAX_ROW_SIZE 20
#define MAX_COL_SIZE 20

unsigned int compute_infec_time_wrapper(char house_layout[][MAX_COL_SIZE],
								int first_infec_room_row,
                                int first_infec_room_col,
                                int total_rows, int total_col);
unsigned int min(unsigned int t1, unsigned int t2, unsigned int t3, unsigned int t4);
void compute_infec_time(char house_layout[][MAX_COL_SIZE],
                        int current_row,
                        int current_col,
						int total_rows, int total_col,
                        unsigned int house_infec_time[][MAX_ROW_SIZE],
                        unsigned int current_time);


int main() {
    // Input
    int total_rows, total_col;
    int first_infec_room_row, first_infec_room_col;
	char house_layout[MAX_ROW_SIZE][MAX_COL_SIZE];

    int i,j;

    cin>>total_rows>>total_col;
    // fflush(stdin);
	for(i = 0; i < total_rows; i++)
	{
		for(j = 0; j < total_col; j++)
		{
			 cin>>house_layout[i][j];
		}
		//scanf("\n");
	}

    scanf("%d %d", &first_infec_room_row, &first_infec_room_col);

  
    int time_taken = compute_infec_time_wrapper(house_layout,
							   first_infec_room_row,
                               first_infec_room_col,
							   total_rows, total_col);

    cout<<time_taken<<" ";

    return 0;
}

unsigned int min(unsigned int t1, unsigned int t2, unsigned int t3, unsigned int t4)
{
    if(t1 < t2 && t1 < t3 && t1 < t4)
    {
        return t1;
    }
    else if(t2 < t3 && t2 < t4)
    {
        return t2;
    }
    else if(t3 < t4)
    {
        return t3;
    }
    else
    {
        return t4;
    }
}

void compute_infec_time(char house_layout[][MAX_COL_SIZE],
                        int current_row,
                        int current_col,
						int total_rows, int total_col,
                        unsigned int house_infec_time[][MAX_ROW_SIZE],
                        unsigned int current_time)
{
    if((current_row >= total_rows) || (current_row < 0)  ||
       (current_col >= total_col)  || (current_col < 0))
    {
        return;
    }

	if(house_layout[current_row][current_col] == 'c')
	{
		return;
	}


    // Current path to reach takes more time than the previous path
    if(current_time >= house_infec_time[current_row][current_col])
    {
        return;
    }

    house_infec_time[current_row][current_col] = current_time;

    compute_infec_time(house_layout,
                       current_row, current_col+1,
			           total_rows, total_col,
                       house_infec_time,
                       current_time + 1);

    compute_infec_time(house_layout,
                       current_row - 1, current_col,
                       total_rows, total_col,
                       house_infec_time,
                       current_time + 1);

    compute_infec_time(house_layout,
                       current_row, current_col - 1,
                       total_rows, total_col,
                       house_infec_time,
                       current_time + 1);

    compute_infec_time(house_layout,
                       current_row + 1, current_col,
                       total_rows, total_col,
                       house_infec_time,
                       current_time + 1);

    return;
}

unsigned int compute_infec_time_wrapper(char house_layout[][MAX_COL_SIZE],
								int first_infec_room_row,
                                int first_infec_room_col,
                                int total_rows, int total_col)
{
	// Tracking time for each room
    unsigned int house_infec_time[MAX_ROW_SIZE][MAX_COL_SIZE];

    int i,j;
    for(i = 0; i < total_rows; i++)
    {
        for(j = 0; j < total_col; j++)
        {
            // Init infinite time for each path
            // How -1 is infinite time??
            house_infec_time[i][j] = -1;
        }
    }

    compute_infec_time(house_layout,
					   first_infec_room_row,
                       first_infec_room_col,
					   total_rows, total_col,
                       house_infec_time,
                       1 /* Current time */);

    int max = 0;
	for(i = 0; i < total_rows; i++)
    {
        for(j = 0; j < total_col; j++)
        {
            if((house_infec_time[i][j] != -1) && (max < house_infec_time[i][j]))
			{
				max = house_infec_time[i][j];
			}
        }
    }

	return max;
}