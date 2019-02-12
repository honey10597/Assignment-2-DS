import java.util.*;
public class link
{
	public static void main(String args[])
	{
		Node head=null;
		Linklist l=new Linklist();
		for(int i=1;i<=5;i++)
		{
			head=l.ins_at_end(head,i);
		}
		System.out.print("Elements after insertion at end : ");
		l.display(head);
		
		head=l.ins_at_beg(head,99);
		System.out.print("\n\nElements after insertion at beg : ");
		l.display(head);
		
		head=l.ins_at_spec(head,46,5);
		System.out.print("\n\nElements after insertion at specific position : ");
		l.display(head);
		
		head=l.del(head,3);
		System.out.print("\n\nElements after deletion at specific position : ");
		l.display(head);
		
		head=l.reverse(head);
		System.out.print("\n\nElements after reverse: ");
		l.display(head);
		
	}
}
class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
	}
}

class Linklist
{
	
	public Node ins_at_spec(Node head,int ele,int p)
	{
		Node t=new Node(ele);
		if(p == 1)
		{
			Node th=head;
			head=t;
			head.next=th;
		}else
		{
			Node te=head;
			int count=2;
			while(te!=null)
			{
				if( count == p )
			{
				Node tn=new Node(ele);
				Node hold=te.next;
				te.next=tn;
				tn.next=hold;
				count++;
				break;
			}
			else
			{
				te=te.next;
			    count++;
			}
			}
			
		}
		
				
		return head;
	}
	
	public Node ins_at_end(Node head,int d)
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
		}
		return head;
	}
	
	public Node reverse(Node head)
	{
		Node current=head;
		Node prev=null;
		Node temp=null;
		while(current!=null)
		{
			temp=current.next;
			current.next=prev;
			prev=current;
			current=temp;
		}
		head=prev;
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
	
	public Node del(Node head,int pos)
	{
		if(pos == 1)
		{
			head=head.next;
		}
		else{
		int count=2;
		Node t=head;
		while(t!=null)
		{
			if(count==pos)
			{
				t.next=t.next.next;
				break;
			}
			t=t.next;
			count++;
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

