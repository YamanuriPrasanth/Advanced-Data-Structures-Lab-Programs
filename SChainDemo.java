package com.prasanth.java;
import java.util.*;
class SNode
{
    int key;
    SNode next;
}
class SChain
{
    Scanner s=new Scanner(System.in);

    int n=s.nextInt();
    SNode h[]=new SNode[n];
    SNode l[]=new SNode[n];
    int hashFunction(int k)
    {
        return k%n;
    }
    void insert(int k)
    {
        int p=hashFunction(k);
        SNode temp=new SNode();
        temp.key=k;
        temp.next=null;
        if(h[p]==null)
            h[p]=l[p]=temp;
        else
        {
            l[p].next = temp;
            l[p]=temp;
        }
    }
    void search(int k)
    {
        int p=hashFunction(k);
        for(SNode temp=h[p];temp!=null;temp=temp.next)
        {
            if(temp.key==k)
            {
                System.out.println("Key found");
                return;
            }
            System.out.println("Key not found");
        }
    }
    void delete(int k)
    {
        SNode temp;
        int hv=hashFunction(k);
        temp=h[hv];
        SNode temp1;
        try
        {
            if (temp.key == k)
            {
                h[hv] = temp.next;
                temp = null;
                System.out.println("element deleted");
                return;
            }
            else if (l[hv].key == k)
            {
                temp = h[hv];
                temp1 = temp;
                while (temp.next != l[hv])
                {
                    temp = temp.next;
                }
                temp.next = null;
                l[hv] = temp;
                return;
            }
            else
            {
                for (temp1 = h[hv]; temp1.key != k && temp1 != null; temp1 = temp1.next)
                {
                    temp = temp1;
                }
                temp.next = temp1.next;
                temp1 = null;
                System.out.println("deletion completed");
                return;
            }
        }
        catch(Exception e)
        {
            System.out.println("key not found");
        }
    }
    void display()
    {
        for(int i=0;i<n;i++)
        {
            System.out.print("h["+i+"]=");
            for(SNode temp=h[i];temp!=null;temp=temp.next)
                System.out.print(temp.key+"->");
            System.out.println("null");
        }
    }

}
class SChainDemo
{
    public static void main(String[] args)
    {
        SChain d=new SChain();
        int ch,x;
        Scanner s=new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter your choice");
            ch=s.nextInt();
            switch(ch)
            {
                case 1:System.out.println("Enter the key to be inserted");
                    d.insert(s.nextInt());
                    break;
                case 2:System.out.println("Enter the key to be searched");
                    d.search(s.nextInt());
                    break;
                case 3:System.out.println("Enter the key to be deleted");
                    d.delete(s.nextInt());
                    break;
                case 4:d.display();
                    break;
                default:return;
            }
        }
    }
}




