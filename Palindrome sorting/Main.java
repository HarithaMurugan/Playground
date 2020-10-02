#include <iostream>
#include <cstdlib>
#include <cstring>
using namespace std;
int palindrome(char *s)
{
    int i,j,flag=0;
    int length= strlen(s);
    i=0;
    j=length-1;
    while(i<=j)
    {
        if(s[i]==s[j])
        {
            i++;
            j--;
        }
        else
        {
            flag=1;
            break;
        }
    }
    if(flag==0)
        return 1;
    else
        return 0;
}
 
/* Following function is needed for library function qsort(). */
int compare(const void *a, const void * b)
{
    return ( *(char *)a - *(char *)b );
}
 
// A utility function two swap two characters a and b
void swap(char* a, char* b)
{
    char t = *a;
    *a = *b;
    *b = t;
}

int findCeil(char str[], char first, int l, int h)
{
    // initialize index of ceiling element
    int ceilIndex = l,i;
 
    // Now iterate through rest of the elements and find
    // the smallest character greater than 'first'
    for (i = l+1; i <= h; i++)
        if (str[i] > first && str[i] < str[ceilIndex])
            ceilIndex = i;
 
    return ceilIndex;
}
 
// Print all permutations of str in sorted order
void sortedPermutations(char str[])
{
    // Get size of string
    int size = strlen(str);
 	int i;
    // Sort the string in increasing order
    qsort(str, size, sizeof( str[0] ), compare);
 
    // Print permutations one by one
    int isFinished = 0;
    while (!isFinished)
    {
        // print this permutation
        static int x = 1;
        if(palindrome(str))
            cout<<str<<endl;
        // Find the rightmost character which is smaller than its next
        // character. Let us call it 'first char'
        
        for (i = size - 2; i >= 0; --i)
            if (str[i] < str[i+1])
                break;
 
        // If there is no such chracter, all are sorted in decreasing order,
        // means we just printed the last permutation and we are done.
        if (i == -1)
            isFinished = 1;
        else
        {
            // Find the ceil of 'first char' in right of first character.
            // Ceil of a character is the smallest character greater than it
            int ceilIndex = findCeil(str, str[i], i + 1, size - 1);
 
            // Swap first and second characters
            swap(&str[i], &str[ceilIndex]);
 
            // Sort the string on right of 'first char'
            qsort(str + i + 1, size - i - 1, sizeof(str[0]), compare);
        }
    }
}
 
int main()
{
    char str[25];
    int n;
    cin>>n;
    while(n--)
    {
        cin>>str;
        if(!palindrome(str))
            cout<<"Not a palindrome "<<endl;
        sortedPermutations(str );
    }
    return 0;
}