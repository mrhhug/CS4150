package MichaelHug;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class LexicalAnalyzer
{

	private List<Token> tokens;
	
	/**
	 * precondition: fileName is not null
	 * @param fileName
	 * @throws LexException 
	 * @throws FileNotFoundException if file is not found
	 * @throws IllegalArgumentException is fileName is null
	 */
	public LexicalAnalyzer(String fileName) throws LexException, FileNotFoundException
	{
		if (fileName == null)
			throw new IllegalArgumentException ("null string argument");
		tokens = new LinkedList<>();
		Scanner input = new Scanner (new File (fileName));
		int lineNum = 0;
		while (input.hasNext())
		{
			String line = input.nextLine();
			lineNum++;
			processLine (line, lineNum);
		}
		tokens.add(new Token (TokenType.EOS, "$", lineNum + 1, 1));
		input.close();
	}
	
	private void processLine(String line, int rowNum) throws LexException
	{
		assert line != null;
		assert rowNum > 0;
		int index = 0;
		boolean done = false;
		do
		{
			index = skipWhiteSpace (line, index);
			if (index == line.length())
				done = true;
			else
			{
				int columnNum = index + 1;
				String lexeme;
				TokenType tok;
				if (Character.isLetter(line.charAt(index)))
				{
					int i = index;
					while (i < line.length() && (Character.isLetter(line.charAt(i)) || Character.isDigit (line.charAt(i))))
						i++;
					lexeme = line.substring(index, i);
					index = i;
					tok = TokenType.IDENT;
				}
				else if (Character.isDigit(line.charAt(index)))
				{
					int i = index;
					while (i < line.length() && Character.isDigit(line.charAt(i)))
						i++;
					lexeme = line.substring(index, i);
					index = i;
					tok = TokenType.INT_LIT;
				}
				else
				{
					switch (line.charAt(index))
					{
						case '+':
							tok = TokenType.ADD_OP;
							break;
						case '-': 
							tok = TokenType.SUB_OP;
							break;
						case '*':
							tok = TokenType.MULT_OP;
							break;
						case '/':
							tok = TokenType.DIV_OP;
							break;
						default:
							throw new LexException ("invalid lexeme", rowNum, columnNum);
					}
					lexeme = (new Character (line.charAt(index))).toString();
					index++;
				}
				Token t = new Token (tok, lexeme, rowNum, columnNum);
				tokens.add(t);
			}
		}
		while (!done);
	}

	private int skipWhiteSpace(String line, int index)
	{
		assert line != null;
		assert index >= 0;
		while (index < line.length() && Character.isWhitespace(line.charAt(index)))
			index++;
		return index;
	}

	/**
	 * precondition: tokens is not empty
	 * @return token at front of list removing the token from the list
	 * @throws RuntimeException if tokens is empty
	 */
	public Token getNextToken()
	{
		if (tokens.isEmpty())
			throw new RuntimeException ("no more tokens");
		return tokens.remove(0);
	}
	
	/**
	 * precondition: tokens is not empty
	 * @return token at front of list leaving token on list
	 * @throws RuntimeException if tokens is empty
	 */
	public Token getLookaheadToken()
	{
		if (tokens.isEmpty())
			throw new RuntimeException ("no more tokens");
		return tokens.get(0);
	}
	
	/**
	 * @return true if there are more tokens - false otherwise
	 */
	public boolean moreTokens ()
	{
		return !tokens.isEmpty();
	}
}
