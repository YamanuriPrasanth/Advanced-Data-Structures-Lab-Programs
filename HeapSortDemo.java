Write a java program to implement Heap sort technique

Aim:To implement Heap sort technique using java programming

Description:

Program:
import java.util.Scanner;
class HeapSort
{
    Scanner s=new Scanner(System.in);
    int n,h[],max;
    HeapSort()
    {
        System.out.println("Enter max");
        max=s.nextInt();
        n=0;
        h=new int[max];
    }
    void percolateDown(int x,int m)
    {
        int e,c;
        e=h[x];
        for(;x*2<=m;x=c)
        {
            c=x*2;
            if(c!=m && h[c+1]>h[c])
                c++;
            if(e<h[c])
                h[x]=h[c];
            else
                break;
        }
        h[x]=e;
    }
    void buildHeap()
    {
        int i;
        System.out.println("Enter n value which should be less than "+max);
        n=s.nextInt();
        System.out.println("Enter n elements");
        for(i=1;i<=n;i++)
        {
            h[i]=s.nextInt();
        }
        for(i=n/2;i>0;i--)
            percolateDown(i,n);
    }
    void heapSort()
    {
        int t,size;
        size=n;
        for(int i=1;i<n;i++)
        {
            t = h[1];
            h[1] = h[size];
            h[size] = t;
            size--;
            percolateDown(1, size);
        }

    }
    void display()
    {
        for(int i=1;i<=n;i++)
        {
            System.out.println(h[i]);
        }
    }
}
class HeapSortDemo
{
    public static void main(String[] args)
    {
        HeapSort hs=new HeapSort();
        hs.buildHeap();
        System.out.println("Elements before sorting");
        hs.display();
        hs.heapSort();
        System.out.println("Elements after sorting");
        hs.display();
    }
}

Input and Output:
Enter max
20
Enter n value which should be less than 20
7
Enter n elements
24 13 48 17 20 56 70
Elements before sorting
70
20
56
17
13
24
48
Elements after sorting
13
17
20
24
48
56
70


