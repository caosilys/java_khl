package day12;

public class ExbEqualEx1 {

	
	public static void main(String[] args) {
		
		ExbTestA a1 = new ExbTestA(1,1);
		ExbTestA a2 = new ExbTestA(1,1);		
		System.out.println(a1);

		ExbTestB b1 = new ExbTestB(1,1);
		System.out.println(b1);
		
		if(a1.equals(a2))
		{
			System.out.println("같음");
		}
		else
		{
			System.out.println("다름");
		}
		
	}	
	
}
class ExbTestB{
	private int num1;
	private int num2;
	
	public ExbTestB(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExbTestB other = (ExbTestB) obj;
		if (num1 != other.num1)
			return false;
		if (num2 != other.num2)
			return false;
		return true;
		
	}

	@Override
	public String toString() {
		return "ExbTestB [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
	
	
}
class ExbTestA{
	
	private int num1;
	private int num2;
	
	public ExbTestA (int num1, int num2)
	{
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj)
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		if(obj instanceof ExbTestA)
		{
			ExbTestA tmp = (ExbTestA)obj;
			if(this.num1 == tmp.num1 && this.num2 == tmp.num2)
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "num1=" + num1 + ", num2=" + num2 ;
	}
	
	
	
	
}