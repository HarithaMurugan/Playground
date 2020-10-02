#include<bits/stdc++.h>
using namespace std;
int main()
{
    int test_case, time, second, pn, result = -1;
    cin >> test_case;   
    cin >> time;   
    int arr[test_case][time+1];
    int i, j;
    for(i = 0; i < test_case; i++)
    {
        for(j = 0; j < time+1; j++)
        {
            cin >> arr[i][j];
        }
    }
    int sumlist[test_case];
    int winner[test_case]; 
    for(int i = 0; i < test_case; i++)
    {
      sumlist[i] = 0;
      winner[i] = 0;
    }
    int answer = INT_MIN;
    for(second = 2; second <= time; second+=2)
    {
         vector <int> maximum;
        for(pn = 0; pn < test_case; pn++)
        {
            sumlist[pn] += (arr[pn][second-2] + arr[pn][second-1]) * arr[pn][time];
           // cout << sumlist[pn] << " ";
            maximum.push_back(sumlist[pn]);            
        }
        int value = *max_element(maximum.begin(), maximum.end());
        for(int i = 0; i < test_case; i++)
        {
            if(value == maximum[i])
            {
                winner[i]++;
            }
        }
    }   
    for(int i = 0; i < test_case; i++)
    {
        if(answer < winner[i])
        {
            answer = winner[i];
            result = i;
        }
    }    
    cout << result+1;   
}