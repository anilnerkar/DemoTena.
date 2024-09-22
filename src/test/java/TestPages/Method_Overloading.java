package TestPages;

public class Method_Overloading {

	void add(int a,int b)
	{
		System.out.println("1st operation :" +(a+b));
		
		
	}
	
	void add(int a,int b,int c)
	{
		System.out.println("2nd opearion :" +(+a+b+c));
		
	}
	
	
	public static void main(String[] args) {
		
		Method_Overloading run = new Method_Overloading();
		run.add(10, 20);
		run.add(10, 20, 30);
		 
		
	}
	
	
	
}
