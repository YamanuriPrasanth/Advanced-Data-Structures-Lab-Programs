import java.util.Scanner;
class QProbing
{
    Scanner s=new Scanner(System.in);
    int n,h[];
    QProbing()
    {
        System.out.println("Enter the size of the hash table");
        n=s.nextInt();
        h=new int[n];
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
            int i,j=1;
            for(i=(p+j*j)%n;h[i]!=0 && h[i]!=-1;++j,i=(p+j*j)%n);
            h[i]=k;
        }
    }
    void search(int k)
    {
        int p=hashFunction(k);
        if(h[p]==k)
            System.out.println("key is found in its home bucket");
        else
        {
            if(h[p]==0)
                System.out.println("key not found");
            else
            {
                int i,j=1;
                for(i=(p+j*j)%n;h[i]!=0 && h[i]!=k;++j,i=(p+j*j)%n);
                if(h[i]==k)
                    System.out.println("The key found at the alternate location");
                else
                    System.out.println("key not found");
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
                int i,j=1;
                for(i=(p+j*j)%n;h[i]!=0 && h[i]!=k;++j,i=(p+j*j)%n);
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
class QProbingDemo
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        QProbing l=new QProbing();
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
