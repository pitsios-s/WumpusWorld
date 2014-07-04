package wumpus.xml_parsing;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Stamatis Pitsios
 *
 * This class is responsible for parsing the xml file that contains
 * the information about the world.
 */
public class WumpusWorldParser
{
	/**
	 * The path of the xml file.
	 */
	private String file;
	
	
	/**
	 * Constructor.
	 * 
	 *  @param file The path and the name of the xml file.
	 */
	public WumpusWorldParser(String file)
	{
		this.file = file;
	}
	
	
	/**
	 * Parses the xml file and returns the board and the agent's initial
	 * position in an object array.
	 * 
	 * @return contents An object array that in keeps in it's first position
	 * a String[][] that is the world and in the second, the agent's initial
	 * position.
	 */
	public Object[] parse()
	{
		Object[] contents = new Object[2];
		
		try
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			WumpusWorldHandler handler = new WumpusWorldHandler();
			parser.parse(this.file, handler);
			
			contents[0] = handler.getBoard();
			contents[1] = handler.getPosition();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return contents;
	}
}