Write a java program to implement the Double Hashing Technique

Aim: To implement the Double Hashing Technique using Java programming

Description:

Program:
import java.util.Scanner;
class DoubleHash
{
    Scanner s=new Scanner(System.in);
    int n,h[],q;
    DoubleHash()
    {
        System.out.println("Enter the size of the hash table");
        n=s.nextInt();
        h=new int[n];
        System.out.println("Enter the prime number which is less than "+n);
        q=s.nextInt();
    }
    int hashFunction(int k)
    {
        return k%n;
    }
    void insert(int k)
    {
        int p=hashFunction(k);
        if(h[p]==0 || h[p]==-1)
            h[p]=k;
        else
        {
            int h1,i,j=1;
            h1=q-(k%q);
            for(i=(p+j*h1)%n;h[i]!=0 && h[i]!=-1;++j,i=(p+j*h1)%n);
            h[i]=k;
        }
    }
    void search(int k)
    {
        int p=hashFunction(k);
        if(h[p]==k)
            System.out.println(k+" is found in its home bucket");
        else
        {
            if(h[p]==0)
                System.out.println("There is no such key");
            else
            {
                int h1,i,j=1;
                h1=q-(k%q);
                for(i=(p+j*h1)%n;h[i]!=k && h[i]!=0;++j,i=(p+j*h1)%n);
                if(h[i]==k)
                    System.out.println(k+" is found at the alternate location "+i);
                else
                    System.out.println("There is no such key");
            }
        }
    }
    void delete(int k)
    {
        int p=hashFunction(k);
        if(h[p]==k)
            h[p]=-1;
        else
        {
            if(h[p]==0)
                System.out.println("There is no such key");
            else
            {
                int h1,i,j=1;
                h1=q-(k%q);
                for(i=(p+j*h1)%n;h[i]!=k && h[i]!=0;++j,i=(p+j*h1)%n);
                if(h[i]==k)
                    h[i]=-1;
                else
                    System.out.println("There is no such key");
            }
        }
    }
    void display()
    {
        for(int i=0;i<n;i++)
            System.out.println("h["+i+"]="+h[i]);
    }
}
class DoubleHashDemo
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        DoubleHash l=new DoubleHash();
        int ch,k;
        while(true)
        {
            System.out.println("Enter your choice");
            ch=s.nextInt();
            switch(ch)
            {
                case 1:System.out.println("Enter the key to be inserted");
                    l.insert(s.nextInt());
                    break;
                case 2:l.display();
                    break;
                case 3:System.out.println("Enter the key to be search");
                    l.search(s.nextInt());
                    break;
                case 4:System.out.println("Enter the key to be deleted");
                    l.delete(s.nextInt());
                    break;
                default:return;
            }
        }
    }
}

Input And Output:
Enter the size of the hash table
11
Enter the prime number which is less than 11
7
Enter your choice
1
Enter the key to be inserted
13
Enter your choice
1
Enter the key to be inserted
26
Enter your choice
1
Enter the key to be inserted
5
Enter your choice
1
Enter the key to be inserted
37
Enter your choice
1
Enter the key to be inserted
16
Enter your choice
1
Enter the key to be inserted
15
Enter your choice
1
Enter the key to be inserted
21
Enter your choice
2
h[0]=15
h[1]=0
h[2]=13
h[3]=0
h[4]=26
h[5]=5
h[6]=21
h[7]=0
h[8]=0
h[9]=37
h[10]=16
Enter your choice
3
Enter the key to be search
26
26 is found in its home bucket
Enter your choice
3
Enter the key to be search
15
15 is found at the alternate location 0
Enter your choice
3
Enter the key to be search
2
There is no such key
Enter your choice
4
Enter the key to be deleted
37
Enter your choice
2
h[0]=15
h[1]=0
h[2]=13
h[3]=0
h[4]=26
h[5]=5
h[6]=21
h[7]=0
h[8]=0
h[9]=-1
h[10]=16
Enter your choice
4
Enter the key to be deleted
15
Enter your choice
2
h[0]=-1
h[1]=0
h[2]=13
h[3]=0
h[4]=26
h[5]=5
h[6]=21
h[7]=0
h[8]=0
h[9]=-1
h[10]=16
Enter your choice
4
Enter the key to be deleted
77
There is no such key
Enter your choice
10
