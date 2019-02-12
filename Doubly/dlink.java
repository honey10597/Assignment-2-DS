import java.util.*;
public class dlink
{
	public static void main(String args[])
	{
		Node head=null;
		Dlist l=new Dlist();
		for(int i=1;i<=5;i++)
		{
			head=l.ins_at_end(head,i);
		}
		System.out.print("Elements after insertion at end : ");
		l.display(head);
		
		head=l.ins_at_beg(head,99);
		System.out.print("\n\nElements after insertion at beg : ");
		l.display(head);
		
		head=l.delete_at_beg(head);
		System.out.print("\n\nElements after deletion from beagning : ");
		l.display(head);
		
		head=l.delete_at_end(head);
		System.out.print("\n\nElements after deletion at end: ");
		l.display(head);
		
		
		System.out.print("\n\nElements after reverse: ");
		l.reverse(head);
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

class Dlist
{
	Node tail=null;
	
	
	
	public Node ins_at_end(Node head,int d)
	{
		Node temp=new Node(d);
		if(head == null)
		{
			head=temp;
			tail=temp;
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
			tail=temp;
		}
		return head;
	}
	
	public void reverse(Node head)
	{
		Node t=tail;
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t=t.prev;
		}
		
	}
	
	
	public Node delete_at_beg(Node head)
	{
		head=head.next;
		head.prev=null;
		return head;
	}
	
	public Node delete_at_end(Node head)
	{
		Node del=head;
		Node p=null;
		while(del.next!=null)
		{
			del=del.next;
		}		
		tail=del.prev;
		del.prev.next=null;
		return head;
	}
	
	public Node ins_at_beg(Node head,int x)
	{
		Node t=new Node(x);
		
		if(head == null)
		{
			head=t;
		}
		
		Node th=head;
		head=t;
		head.next=th;
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

