Write a Java Program to implement Separate chaining Technique

Aim:To implement separate chaining technique using java Programming

Description:

Program:
import java.util.*;
class Snode
{
    int key;
    Snode next;
}
class Schain
{
    Scanner s=new Scanner(System.in);
    int n;
    Snode h[],l[];
    Schain()
    {
        System.out.println("enter the size of the hashtable");
        n=s.nextInt();
        h=new Snode[n];
        l=new Snode[n];
    }
    int hashfunction(int k)
    {
        return k%n;
    }
    void insert(int k)
    {
        int p=hashfunction(k);
        Snode temp=new Snode();
        temp.key=k;
        temp.next=null;
        if(h[p]==null)
            h[p]=l[p]=temp;
        else
        {
            l[p].next=temp;
            l[p]=temp;
        }
    }
    void display()
    {
        for(int i=0;i<n;i++)
        {
            System.out.print("h["+i+"]=");
            for(Snode temp=h[i];temp!=null;temp=temp.next)
                System.out.print(temp.key+"------>");
            System.out.println("null");
        }
    }
    void search(int k)
    {
        int p=hashfunction(k);
        for(Snode temp=h[p];temp!=null;temp=temp.next)
        {
            if(temp.key==k)
            {
                System.out.println("element founf");
                return;
            }
        }
        System.out.println("elements not found");
    }
    void delete(int k)
    {
        int p=hashfunction(k);
        Snode temp,temp1;
        temp=h[p];
        temp1=h[p];
        while(temp!=null)
        {
            if(temp.key==k)
            {
                if(h[p].key==l[p].key)
                {
                    h[p]=null;
                    System.out.println("element found");
                    return;
                }
                else if(temp.next!=null&&h[p].key==k)
                {
                    h[p]=h[p].next;
                    return;
                }
                else if(temp.next==null)
                {
                    temp1.next=null;
                    l[p]=temp1;
                    System.out.println("element found");
                    return;
                }
                else
                {
                    temp1.next=temp.next;
                    System.out.println("element found");
                    return;
                }
            }
            temp1=temp;
            temp=temp.next;
        }
        System.out.println("element not found");
    }
}
class Schaindemo
{
    public static void main(String arg[])
    {
        Scanner s=new Scanner(System.in);
        Schain  d= new Schain();
        int ch,k;
        while(true)
        {
            System.out.println("enter ur choice");
            ch=s.nextInt();
            switch(ch)
            {
                case 1:System.out.println("enter ele to be inserted");
                    d.insert(s.nextInt());
                    break;
                case 2:System.out.println("enter ele to be deleted");
                    d.delete(s.nextInt());
                    break;
                case 3:System.out.println("enter ele to be searched");
                    d.search(s.nextInt());
                    break;
                case 4:System.out.println("the elements in the array are:");
                    d.display();
                    break;
                default :return;
            }
        }
    }
}

Input and Output:
10
Enter your choice
1
Enter the key to be inserted
10
Enter your choice
1
Enter the key to be inserted
20
Enter your choice
1
Enter the key to be inserted
55
Enter your choice
1
Enter the key to be inserted
68
Enter your choice
1
Enter the key to be inserted
89
Enter your choice
4
h[0]=10->20->null
h[1]=null
h[2]=null
h[3]=null
h[4]=null
h[5]=55->null
h[6]=null
h[7]=null
h[8]=68->null
h[9]=89->null
Enter your choice
2
Enter the key to be searched
10
Key found
Enter your choice
2
Enter the key to be searched
69
Key not found
Enter your choice
3
Enter the key to be deleted
68
element deleted
Enter your choice
4
h[0]=10->20->null
h[1]=null
h[2]=null
h[3]=null
h[4]=null
h[5]=55->null
h[6]=null
h[7]=null
h[8]=null
h[9]=89->null
Enter your choice
3
Enter the key to be deleted
30
key not found
Enter your choice
10





