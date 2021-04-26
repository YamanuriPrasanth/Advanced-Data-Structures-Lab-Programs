import java.util.Scanner;
class LProbing
{
    Scanner s=new Scanner(System.in);
    int n,h[];
    LProbing()
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
            int i;
            for(i=(p+1)%n; i!=p && h[i]!=0 && h[i]!=-1; i=(i+1)%n);
            if(h[i]==0 || h[i]==-1)
                h[i]=k;
            else
                System.out.println("Cannot insert the key");
        }

    }
    void search(int k)
    {
        int p=hashFunction(k);
        if(h[p]==k)
            System.out.println("Key found");
        else
        {
            if(h[p]==0)
                System.out.println("There is no such key");
            else
            {
                int i;
                for(i=(p+1)%n;h[i]!=0 && i!=p && h[i]!=k;i=(i+1)%n);
                if(h[i]==k)
                    System.out.println(k+" found at "+i);
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
                int i;
                for(i=(p+1)%n;h[i]!=k && h[i]!=0 && i!=p; i=(i+1)%n);
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
class LProbingDemo
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        LProbing l=new LProbing();
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
