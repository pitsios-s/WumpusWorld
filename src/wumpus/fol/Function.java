package wumpus.fol;

/**
 * @author Stamatis Pitsios
 * 
 *  Every instance of this class represents a function that can be an arguement of a HornLiteral.
 *  Such functions can be ADD or SUB , which means adding or subtracting a specified value to a number.
 */
public class Function extends Term
{
	//The name of the function i.e. ADD or SUB.
	private String function_name;
	
	//The first arguement of the function. It can be either a Variable or a Constant.
	private Term first;
	
	//The second arguement of the function. It is a constant value.
	private Constant second;
	
	
	
	
	public Function()
	{
		this.function_name = "ADD";
		this.first = null;
		this.second = null;
	}
	
	
	
	
	public Function(String name , Term var ,  Constant value )
	{
		this.function_name = name;
		this.second = value;
		this.first = var;
	}
	
	
	
	
	public void setName(String s)
	{
		this.function_name = s;
	}
	
	
	
	
	public String getName()
	{
		return this.function_name;
	}
	
	
	
	
	public void setFirst(Term first)
	{
		this.first = first;
	}
	
	
	
	
	public Term getFirst()
	{
		return this.first;
	}
	
	
	
	
	public void setSecond(Constant con)
	{
		this.second = con;
	}
	
	
	
	
	public Term getSecond()
	{
		return this.second;
	}
	
	
	
	
	//adds the variable with the number and returns the result.
	public int getAbsoluteNumber()
	{
		//if we have for example ADD(X , 1) we can not return a value.
		if(first instanceof Variable) return Integer.MIN_VALUE;
		
		else if(first instanceof Constant)
		{
			Constant t = (Constant)first;
			return second.getConstant() + t.getConstant();
		}
		
		else return Integer.MIN_VALUE;
	}
	
	
	
	
	@Override
	public boolean equals(Object ob1)
	{
		if(this.getClass() != ob1.getClass()) return false;
		
		Function f = (Function)ob1;
		
		return ( (f.function_name.equalsIgnoreCase(this.function_name)) && (f.first.equals(this.first)) && f.second.equals(this.second) );
	}
	
	
	
	
	@Override
	public String toString()
	{
		return ( this.function_name+"("+first.toString()+","+second.toString()+")" );
	}
	
	
	
	
	@Override
	public int hashCode()
	{
		return ( this.function_name.hashCode() + this.first.hashCode() + this.second.hashCode() );
	}


}