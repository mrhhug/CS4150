package MichaelHug;

public class LiteralInteger implements UnaryExpression
{

	private int value;

	public LiteralInteger(int value)
	{
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see Expression#evaluate()
	 */
	public int evaluate ()
	{
		return value;
	}
}
