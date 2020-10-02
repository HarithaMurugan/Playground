#include<iostream> 
#include<stdlib.h>
using namespace std;
struct Node
{   int num;
    struct Node* link;
};
void insertAtBeginning(struct Node** head_ref, int new_data) 
{ 
	struct Node* new_node = (struct Node*) malloc(sizeof(struct Node)); 
	new_node->num = new_data; 
	new_node->link = (*head_ref); 
	(*head_ref) = new_node; 
}
int printNthFromLast(struct Node* head, int n)
{
      int len = 0, i; 
	struct Node *temp = head;
	while (temp != NULL) 
	{ 
		temp = temp->link; 
		len++; 
	} 
	if (len < n) 
		return 0; 
	temp = head; 
	for (i = 1; i < len-n+1; i++) 
		temp = temp->link; 
	
	cout<<temp->num; 
	return 1; 
} 
int main() 
{
      struct Node* head = NULL; 
      int total_elem_to_insert, tmp, i,n; 
      cin>>total_elem_to_insert; 
      
	for(i=0;i<total_elem_to_insert;i++) 
	{ 
	    cin>>tmp; 
	    insertAtBeginning(&head, tmp); 
	} 
	scanf("%d",&n); 
	
	if(0==(printNthFromLast(head, n))) 
	    cout<<"No node found"<<endl; 
	return 0; 
} 
