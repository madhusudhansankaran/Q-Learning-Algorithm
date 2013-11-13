import java.util.ArrayList;
import java.util.Random;

/*
 * This class contains the main method. This is the class that does most of the work as the Q matrix is calculated and updated here until it converges. The optimal path is also calculated and displayed here.
 */
public class QLearning 
{
	//This is the main method of the class which when executed, will display the shortest path from the source to the goal, the path itself and the final Q-Matrix.
	public static void main(String args[])
	{
		ArrayList<String> possibleStates = new ArrayList<String>();
		ArrayList<Integer> steplist = new ArrayList<Integer>();
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		
		int row=0;
		int currentState;
		int nextState = 0;
		int steps = 0;
		int min =0;
		
		final double gamma = 0.9;
		double q[][] = new double[20][20];
		int r[][] = new int[20][20];
		
		double max;
		
		Matrices m = new Matrices();
		m.matrixCreation(r);
		
		PossibleStates cq = new PossibleStates();
		currentState = row;
		
		//Since I did not want to use toolkits for checking whether the matrix Q has converged, I used a rough estimate that by 10000 iterations, the Q matrix would surely have reached convergence.
		for(int c=0;c<10000;c++)
		{
			//While the next state is not the goal state, do all the actions specified in this loop.
			while(nextState!=19)
			{
				steps++;
				min = steps;
				possibleStates = cq.States(currentState,r);
		
				nextState = Integer.parseInt(possibleStates.get(new Random().nextInt(possibleStates.size())));
				possibleStates = cq.States(nextState, r);
				max = q[nextState][Integer.parseInt(possibleStates.get(0))];
				
				for(int i=1;i<possibleStates.size();i++)
				{
					if(max < q[nextState][Integer.parseInt(possibleStates.get(i))])
					{
						max = q[nextState][Integer.parseInt(possibleStates.get(i))];
					}	
				}
				q[currentState][nextState] = m.roundTwoDecimals(r[currentState][nextState] + (gamma * max));
				
				currentState = nextState;
			}
			
			steplist.add(steps);
			nextState = 0;
			currentState = 0;
			steps = 0;
		}
		
		for(int i=0;i<steplist.size();i++)
		{
			if(min > steplist.get(i))
			{
				min = steplist.get(i);
			}
		}
		
		System.out.println("The optimal policy consists of a path of length " + min);
		System.out.println("");
		
		row = 0;
		
		//Add the initial state, 0, to the optimal path. 
		sequence.add(0);

		//Calculate the optimal path from the Q-Matrix.
		for(int j=1;j<=min;j++)
		{
			sequence.add(j, m.getMaxInRow(row,q));
			row = sequence.get(j);
		}
		
		System.out.print("The path is " );
		
		//Print the optimal path here.
		for(int i=0;i<sequence.size();i++)
		{
			System.out.print(sequence.get(i));
			
			if(i!=sequence.size()-1)
			{
				System.out.print("-");
			}
		}
		
		System.out.println(""+"\n");
		System.out.println("The final Q matrix is as follows : \n");
		
		//Print the final Q-Matrix here.
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				System.out.print(q[i][j]+" ");			
			}
			System.out.println("");
		}
	}
}
