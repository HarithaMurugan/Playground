#include<iostream>
#include<string.h>
#include <bits/stdc++.h>
using namespace std;
int main()
{
       //step 1 : getting encoded password and the list of characters
       string encoded_password,listofchar;
       cin>>encoded_password>>listofchar;
       //check if the input is taken properly
       //cout<<encoded_password<<endl<<listofchar;
       //step 2 : converting the string into character array
        int n = encoded_password.length();
        char char_array[n + 1];
        char final_array[n];
        int pass_array[10];
        strcpy(char_array, encoded_password.c_str());
        int count = 0;
        int i = 0;
        int cnt1=0;
        //to check if it has been converted properly to a char array
        //cout << char_array[i];
        for(i = 0; i < n; i++)
        {
            if(char_array[i] == '|' && char_array[i+1] == '|')
            {
                break;
            }
            else
            count++;
        }
       int j,pos,val,cnt=0,p1,p2;
       int cnt_arr[10];
       //cout<<count<<endl;
        for(i = 0; i < count; i++)
        {
            cnt=0;
            if(char_array[i] == '|')
            {
                j = i+1;
                p1 = j;
                while(char_array[j] != '|')
                {
                    j++;
                    cnt++;
                }
               // cout<<cnt<<endl;
                p2 = j-1;
                // if(cnt>1)
               // cout<<p1<<" "<<p2<<endl;
            }
            
            if(cnt>1)
            {
                for(int m = p1; m<p2;m++)
                {
                    int pos = char_array[m]-48;
                    int val = char_array[p2]-48;
                    pass_array[pos] = val;
                    //cout<<pos<<","<<pass_array[pos]<<endl;
                    cnt1++;
                }
            }
        }
       for(i = 0; i<cnt1;i++)
       //cout<<pass_array[i]<<"  ";
      // cout<<endl;
       pos = 0;
       for(i = 0;i<n;i++)
       {
           if(char_array[i] == '|' && char_array[i+1] == '|')
           {
               pos = i+2;
               break;
           }
       }
       int A = char_array[n-1]-48;
       //cout<<pos<<A<<endl;
      while(n-(pos-1)!=0)
      {
           val = char_array[pos]-48;
           pass_array[val] += 10;
           pos++;
      }
    //   for(i = 0; i<cnt1;i++)
    //   cout<<pass_array[i]<<"  ";
      val = A;
      int upd_pas[cnt1];
      upd_pas[0] = A;
      for(i = 1;i<cnt1;i++)
      {
          upd_pas[i] = pass_array[i-1]-upd_pas[i-1]; 
      }
      pass_array[0] = A;
    //   for(i = 0; i<cnt1;i++)
    //   cout<<upd_pas[i]<<"  ";
    //   cout<<endl;
      char list_array[11];
      strcpy(list_array, listofchar.c_str());
      for(i = 0;i<cnt1;i++)
      cout<<list_array[upd_pas[i]];
       return 0;
}