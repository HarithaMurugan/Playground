#include<iostream>
using namespace std;
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int r;
        cin>>r;
        int count = 0;
        int duration = 0;
        int tasks[r][3];
        int min = 0;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                cin>>tasks[i][j];
            }
        }
        for(int i = 0; i < r; i++)
        {
            for(int j = i+1; j < r; j++)
            {
                if((tasks[i][2] == tasks[j][2]) && tasks[i][2] > 0)
                {
                    if(tasks[i][1]<tasks[j][1])
                    min = i;
                    else
                    min = j;
                    tasks[min][1] = 0;
                    continue;
                }
            } 
          duration += tasks[i][1];
        }
        cout<<duration<<endl;
      duration = 0;
    }
}