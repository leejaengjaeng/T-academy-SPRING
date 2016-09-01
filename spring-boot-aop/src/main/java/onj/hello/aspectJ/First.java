package onj.hello.aspectJ;

public class First {

	public void one()
	{
		System.out.println(this.getClass().getName()+" : one called");
	}
	public void two()
	{
		System.out.println(this.getClass().getName()+" : two called");
	}
	public void oneTwo()
	{
		System.out.println(this.getClass().getName()+" : oneTwo called");
	}
	
	public int add(int a, int b)
	{
		System.out.println(this.getClass().getName()+" : add called");
		return a+b;
	}
}
