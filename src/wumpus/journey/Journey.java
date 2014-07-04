package wumpus.journey;

/**
 * @author Stamatis Pitsios
 */
public class Journey 
{
	public static void main(String[] args)
	{
		Agent agent=new Agent("res/world.xml");
		agent.FindGold();
	}
}