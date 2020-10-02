#include<iostream>
using namespace std;

struct Node
{
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void push_back(int value)
{
    Node *last = head;
    Node *newnode = new Node;
    newnode->data = value;
    newnode->next = NULL;
    
    if(head == NULL)
        head = newnode;
    else
    {
        while(last->next != NULL)
            last = last->next;
            
        last->next = newnode;
    }
}

void push_front(int value)
{
    Node *newnode = new Node;
    newnode->data = value;
    newnode->next = head;
    head = newnode;
}
void printList()
{
    Node *temp = head;
    if(head == NULL)
    {
      cout <<"Linked list is empty.";
    }
  else
  {
    while(temp != NULL)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
  }
}

int pop_front()
{
 	if(head == NULL)
    {
      return -1;
      
    } 
  
    Node *temp = head;
    int element = temp->data;
    head = temp->next;
    delete(temp);
    return element;
}

int pop_back()
{
    Node *temp = head;
    int element;
    if(head->next == NULL)
    {
        element = head->data;
        head = NULL;
        return element;
    }
    while(temp->next->next != NULL)
    {
        temp = temp->next;
    }
    element = temp->next->data;
    temp->next = NULL;
    delete(temp->next);
    return element;
}
int main()
{
    int choice;
    while(1)
    {
        cin >> choice;
        if(choice == 1)
        {
            int x;
            cout <<"Enter value of element\n";
            cin >> x;
            push_front(x);
        }
        else if(choice == 2)
        {
            int x;
            cout <<"Enter value of element\n";
            cin >> x;
            push_back(x);
        }
        else if(choice == 3)
        {
            printList();
        }
        else if(choice == 4)
        {
            int x = pop_front();
            if(x != -1)
            cout << x <<" deleted from beginning successfully.\n";
            else
            cout <<"Linked list is empty.";
        }
        else if(choice == 5)
        {
            int x = pop_back();
            cout << x <<" deleted from end successfully.\n";
        }
        else
        {
            break;
        }
    }
}