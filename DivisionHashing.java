import java.util.*;
class DivisionHashing
{
	Scanner s=new Scanner(System.in);
	int ht[],n;
	DivisionHashing()
	{
		System.out.println("Enter array size");
		n=s.nextInt();
		ht=new int[n];
	}
	void insert(int k)
	{
		int hv=hashFunction(k);
		ht[hv]=k;
	}
	void search(int k)
	{
		int hv=hashFunction(k);
		if(ht[hv]==k)
			System.out.println("Element found");
		else
			System.out.println("Element not found");
	}
	void delete(int k)
	{
		int hv=hashFunction(k);
		if(ht[hv]==k)
			ht[hv]=-1;
		else
			System.out.println("key not found");
	}
	int hashFunction(int k)
	{
		return k%n;
	}
	void display()
	{
		for(int i=0;i<n;i++)
			System.out.print(ht[i]+"\t");
	}
}
class DivisionHashingDemo
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		DivisionHashing d=new DivisionHashing();
		int ch;
		while(true)
		{
			System.out.println("Enter your choice");
			ch=s.nextInt();
			switch(ch)
			{
				case 1:System.out.println("Enter key to be insert");
				d.insert(s.nextInt());
				break;
				case 2:System.out.println("Enter key to be search");
				d.search(s.nextInt());
				break;
				case 3:System.out.println("Enter key to be deleted");
				d.delete(s.nextInt());
				break;
				case 4:d.display();
				break;
				default:return;
			}
		}
	}
}
					
		
		