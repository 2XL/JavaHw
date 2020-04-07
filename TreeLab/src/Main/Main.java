package Main;


public class Main {
	public static void main(String[] args)
	{
		
		
		int x,y,z, t;
		x = 0;
		y = 0;
		z = 10;
		t = 0;
		
	do{	
		if(x < 0)
			t = t+1;
			y = y+2;;
			x++;
	}while(x<z);	
		System.out.println(t);
		System.out.println(y);
		
		
		
		int b = 0;
		actualitza(b);
		System.out.println(b);
	
		
		
		
		
		
		
		
		
	}
	public static void actualitza(int a)
	{
		if(a<10)
			a=(a+1)*(a+1);
	}
	
}
