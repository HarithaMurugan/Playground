#include<bits/stdc++.h>
#include <sstream> 
using namespace std;
long int arr[1000000]; 
int convertStrtoArr(string str) 
{ 
    arr[100] = {0};
    // get length of string str 
    int str_length = str.length(); 
    
    // create an array with size as string 
    // length and initialize with 0 
  
    int j = 0, i, sum = 0; 
    // Traverse the string 
    for (i = 0; str[i] != '\0'; i++) { 
         if(str[i] == ' '){ 
            j++; 
        } 
        else { 
            // subtract str[i] by 48 to convert it to int 
            // Generate number by multiplying 10 and adding 
            // (int)(str[i]) 
            arr[j] = arr[j] * 10 + (str[i] - 48); 
        } 
    } 
    return j;
} 
int main()
{
    string str1,dummy,str2;
    getline(cin,str1);
    int slabcount = convertStrtoArr(str1);
    int slabs[slabcount+1];
    for (int i = 0; i <= slabcount; i++) { 
        slabs[i] = arr[i];
        arr[i] = 0;
    } 
    arr[slabcount] = 0;
    slabcount += 1;
    //cout<<slabcount<<endl;
    int taxper[slabcount+1];
    taxper[0] = 0;
    for(int i = 0; i < slabcount; i++){
        cin>>taxper[i];
    }
    //for(int i = 0; i < slabcount; i++){
      //  cout<<taxper[i]<<" ";
    //}
    int rebate;
    cin>>rebate;
    //cout<<"rebate : "<<rebate<<endl;
    cin.ignore();
    getline(cin,str2);
    //cout<<str2<<" ";
    int taxcount = convertStrtoArr(str2);
    taxcount += 1;
    //cout<<taxcount<<" ";
    int tax[taxcount];
    for(int i = 0; i < taxcount; i++){
        //cout<< arr[i] <<" ";
        tax[i] = arr[i];
        arr[i] = 0;
    }
     float max_tax[taxcount];
     max_tax[0] = 0.0;
     for(int i = 1; i < slabcount; i++)
     {
         //cout<<"slabs :"<<slabs[i];
         max_tax[i] = (slabs[i]-slabs[i-1]) * (taxper[i-1]/100.0);
         //cout<<"max_tax"<<i<<"  :"<<max_tax[i];
     }
     //cout<<"Max tax done"<<endl;
     
     long long int total = 0;
     for(int i = 0; i < taxcount; i++)
     {
         long long int sal = 0;
         //cout<<i<<endl;
         int count = 1;
         while(tax[i] != 0)
         {
          
             if(count< slabcount)
             {
                 //cout<<count<<" "<<tax[i]<<" "<<max_tax[count]<<endl;
                 if(tax[i] >= max_tax[count])//90000>=30000
                 {
                     sal = slabs[count];//sal = 600000
                    
                     tax[i] = tax[i] - max_tax[count];//90000 - 30000
                    
                 }
                  count++;//count = 2 
             }
                else
                {
                    //cout<<count<<" "<<tax[i]<<" "<<taxper[count-1]<<" "<<slabs[count-1]<<endl;
                    sal = slabs[count-1] + (tax[i]*100.0/taxper[count-1]);
                    tax[i] = 0;
                    break;
                }
         }
         sal = sal + rebate;
         total = total + sal;
         //cout<<sal<<endl;
     }
     if(total == (taxcount * rebate))
       cout<<"The salaries are not more than 3,00,000 or there are no slabs";
     else
     cout<<total;
     
    return 0;
}