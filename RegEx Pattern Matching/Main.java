#include<iostream>
#include<cstring>
using namespace std;

#define MAX_LEN 40

int main()
{
    string sentence_str;
    cin>>sentence_str;
    
    string regex_str;
    cin>>regex_str;
    
    int sentence_idx, regex_index = 0, isMatch = 1;
    for(sentence_idx = 0; sentence_str[sentence_idx] != '\0'; sentence_idx++)
    {
        if(regex_str[regex_index] == '\0')
        {
            isMatch = 0;
            break;
        }
        
        char curr_sentence_char = sentence_str[sentence_idx];
        if(regex_str[regex_index] != '+')
        {
            if(regex_str[regex_index] == curr_sentence_char)
            {
                regex_index++;
            }
            else
            {
                isMatch = 0;
                break;
            }   
        }
        else if(regex_str[regex_index] == '+') 
        {
            char regex_prev_char = regex_str[regex_index - 1];
            char regex_next_char = regex_str[regex_index + 1];
            if(regex_prev_char == curr_sentence_char)
            {
                // Matches with prev char
                // Do nothing
            }
            else if (regex_next_char == '\0')
            {
                // No more regex char
                // Match failed
                isMatch = 0;
                break;
            }   
            else if (regex_next_char == curr_sentence_char)
            {
                // Matches with next char
                regex_index += 2;
            }
            else
            {
                isMatch = 0;
                break;
            }
        }
    }
    
    while(regex_str[regex_index] != '\0')
    {
        if(regex_str[regex_index] != '+')
        {
            break;
        }
        
        regex_index++;
    }
    
    if((isMatch == 1) && regex_str[regex_index] == '\0')
    {
        cout<<"Matched";
    }
    else
    {
        cout<<"Does not match";
    }
    
    return 0;
}