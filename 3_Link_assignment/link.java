import java.util.*;
public class link
{
	public static void main(String args[])
	{
		Node head=null;
		List l=new List();
		head=l.insert(head,7);
		head=l.insert(head,-3);
		head=l.insert(head,5);
		head=l.insert(head,-7);
		head=l.insert(head,1);
		head=l.insert(head,3);
		
		head=l.solve(head);
		l.display(head);
	}
}
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
		this.data=data;
	}
}

class List
{
	public Node insert(Node head,int d)
	{
		Node temp=new Node(d);
		if(head == null)
		{
			head=temp;
		}
		else
		{
			Node temp1=head;
			while(temp1.next!=null)
			{
				temp1=temp1.next;
			}
			temp1.next=temp;
			temp.prev=temp1;
		}
		return head;
	}
	
	public Node solve(Node head)
	{
		Node t1=head;
		Node t2=head.next;
		while(t1.next!=null)
		{
			t2=t1.next;
			while(t2!=null)
			{
				
				if( (t1.data-t2.data) == 0 || (t1.data+t2.data) == 0 )
				{
					head=delete(head,t1.data);
					head=delete(head,t2.data);
				}
				t2=t2.next;
			}
			t1=t1.next;
		}
		return head;
	}
	
	public Node delete(Node head,int d)
	{
			
		Node temp=head;
		if(head.data==d)
		{
			head=head.next;
		}
		else
		{
		while(temp!=null)
		{
			if(temp.data == d)
			{
				if(temp.next!=null)
				{
					temp.prev.next=temp.next;
				}
				else{
					temp.prev.next=null;
				}
			}
			temp=temp.next;
		}
		}
		return head;
	}
	
	public void display(Node head)
	{
		if(head == null)
		{
			System.out.print("Linklist is empty");
		}
		Node temp1=head;
		while(temp1!=null)
		{
			System.out.print(temp1.data+" ");
			temp1=temp1.next;
		}
	}
}
