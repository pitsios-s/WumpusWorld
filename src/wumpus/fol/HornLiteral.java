package wumpus.fol;

import java.util.ArrayList;

/**
 * @author Stamatis Pitsios
 * 
 * Every instance of this class represents a horn literal in First Order Logic.
 */
public class HornLiteral
{
	//the name of the current literal.
	private String name;
	
	//The negation of the clause
	private boolean negation;
	
	//can be either a Variable or a Constant or a Function. 
	private ArrayList<Term> terms;
	
	
	
	
	public HornLiteral()
	{
		name="";
		negation = true;
		terms = new ArrayList<Term>();
	}
	
	
	
	
	public HornLiteral(String Name , boolean Negation , Term term1)
	{
		name = Name;
		negation = Negation;
		terms = new ArrayList<Term>();
		terms.add(term1);
	}
	
	
	
	
	public HornLiteral(String Name , boolean Negation , Term term1 , Term term2)
	{
		name = Name;
		negation = Negation;
		terms = new ArrayList<Term>();
		terms.add(term1);
		terms.add(term2);
	}
	
	
	
	
	public void setName(String Name)
	{
		name = Name;
	}
	
	
	
	
	public String getName()
	{
		return name;
	}
	
	
	
	
	public void setNegation(boolean Negation)
	{
		negation = Negation;
	}
	
	
	
	
	public boolean getNegation()
	{
		return negation;
	}
	
	
	
	
	//adds a term to the literal.
	public void addTerm(Term term)
	{
		this.terms.add(term);
	}
	
	
	
	
	//returns a list that contains all the terms of the literal.
	public ArrayList<Term> getTerms()
	{
		return this.terms;
	}
	
	
	
	
	//checks if the given literal is a negation of the current literal.
	public boolean isNegation(HornLiteral literal)
	{
		return (this.name.equals(literal.name) && this.terms.equals(literal.terms) && this.negation!=literal.negation);
	}
	
	
	
	
	//returns true if the literal is a horn fact.
	public boolean isFact()
	{
		return negation;
	}
	
	
	
	
	@Override
	public String toString()
	{
		String Negation = (negation)?"":"not ";
		
		String args = "";
		
		for(Term term : terms)
		{
			if(!args.equals("")) args+=",";
			args+=term.toString();
		}
		
		return ( Negation+""+name+"("+args+")");
	}
	
	
	
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj.getClass()!=this.getClass()) return false;
		
		HornLiteral literal = (HornLiteral)obj;
		
		
		if(literal.name.equals(this.name) && literal.negation==this.negation && literal.terms.equals(this.terms)) return true;
		
		return false;
	}
	
	
	
	
	@Override
	public int hashCode()
	{
		int hash = this.name.hashCode();
		
		for(Term term : terms)
		{
			hash += term.hashCode();
		}
		
		return hash;
	}

}