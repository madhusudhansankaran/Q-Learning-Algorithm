import java.util.ArrayList;

/*
 * This class is used to calculate the states that can be reached when in a particular state.
 */
public class PossibleStates 
{	
	//This method takes the current row in the matrix r and checks the possible states that can be reached by looking at the row. 
	public ArrayList<String> States(int row, int r[][])
	{
		//An ArrayList possibleStates is used to keep track of the states that can be visited from another state.
		ArrayList<String> possibleStates = new ArrayList<String>();
		
		int i=row;
		{
			for(int j=0;j<20;j++)
			{
				if(r[i][j]>=0)
				{
					possibleStates.add(""+j);
				}
			}
		}
		return possibleStates;
	}
}
