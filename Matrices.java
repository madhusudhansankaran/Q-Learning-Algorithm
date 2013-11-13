import java.text.DecimalFormat;

/*
 * This class is used to create the R-Matrix from the model world given in the assignment. I have assigned a reward of 0 to all immediate states, a reward of 100 on reaching the goal state, and a reward of
 * -1 to the states that are not accessible via a particular state.
 */
public class Matrices 
{
	//This method takes the R-Matrix and constructs it based on the specifications provided.
	public void matrixCreation(int r[][])
	{
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				if(i==0)
				{
					if(j==0||j==1||j==5)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==1)
				{
					if(j==0||j==1||j==2||j==6)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==2)
				{
					if(j==1||j==2||j==3||j==7)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==3)
				{
					if(j==2||j==3||j==4||j==8)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==4)
				{
					if(j==3||j==4||j==9)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==5)
				{
					if(j==0||j==6||j==5||j==10)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==6)
				{
					if(j==7||j==1||j==5||j==11||j==6)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==7)
				{
					if(j==6||j==2||j==8||j==12||j==7)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==8)
				{
					if(j==7||j==8||j==9||j==3||j==13)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==9)
				{
					if(j==8||j==9||j==4||j==14)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==10)
				{
					if(j==10||j==15||j==5||j==11)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==11)
				{
					if(j==10||j==11||j==12||j==6||j==16)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==12)
				{
					if(j==11||j==12||j==13||j==7||j==17)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==13)
				{
					if(j==12||j==13||j==14||j==8||j==18)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==14)
				{
					if(j==13||j==14||j==9)
					{
						r[i][j]=0;
					}
					else if(j==19)
					{
						r[i][j]=100;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==15)
				{
					if(j==10||j==15||j==16)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==16)
				{
					if(j==17||j==16||j==15||j==11)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==17)
				{
					if(j==16||j==17||j==18||j==12)
					{
						r[i][j]=0;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else if(i==18)
				{
					if(j==17||j==18||j==13)
					{
						r[i][j]=0;
					}
					else if(j==19)
					{
						r[i][j]=100;
					}
					else
					{
						r[i][j]=-1;
					}
				}
				else
				{
					if(j==18||j==14)
					{
						r[i][j]=0;
					}
					else if(j==19)
					{
						r[i][j]=100;
					}
					else
					{
						r[i][j]=-1;
					}
				}
			}
		}	
	}
	
	//This method is used to round decimal values to two places. It is used to round the values in the Q-Matrix.
	public double roundTwoDecimals(double d) 
	{
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        
        return Double.valueOf(twoDForm.format(d));
	}
	
	//This method is used to get the column value, that has the largest Q-value in every row.
	public int getMaxInRow(int r, double q[][])
	{
		int val = 0;
		double max = q[r][0];
		
		for(int j=0;j<20;j++)
		{
			if(max<q[r][j])
			{
				val = j;
			}
		}
		
		return val;
	}
}
