import java.text.NumberFormat;
import java.util.ArrayList;

public class Graph
{
	int[][] adjMat = null;
	String[] vertices = null;
	
	public Graph(String[] s)
	{//s is a list of cities
		adjMat = new int[s.length][s.length];
		
		for(int x = 0; x < adjMat.length; x++)
			for(int y = 0; y < adjMat[x].length; y++)
				adjMat[x][y] = 0;
		
		vertices = s;
	}
	
	public void addEdge(int e1, int e2, int width)
	{
		//Undirected Graph
		adjMat[e1][e2] = width;
		adjMat[e2][e1] = width;
	}
	
	public int prims()
	{return prims(0);}
	
	public int prims(int n)
	{
		//init. total to -1 in case there is an err. 
		int total = -1;
		//int iterationCount = 0;
		StringBuilder MST_Path = new StringBuilder();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		int minIndex_X = -1;
		int minIndex_Y = -1;

		/*try{
			while(adjMat[minIndex_X][minIndex_Y] == 0)
				minIndex_Y++;
		}catch(IndexOutOfBoundsException e){
			System.out.println("No edges on n! Prim has failed.");
			return total;
		}
		
		System.out.print("\n\t(" + minIndex_X + ", " + minIndex_Y+ ")" + 
				" = " + adjMat[minIndex_X][minIndex_Y]);
		*/
		
		do{
		//System.out.println("\n\nIteration " + (++iterationCount));
		//Initialize cost as -1 in case there is an err.
		int cost = -1;
		
		//Mark current vertex as visited
		visited.add(n);
		
	/*//Print visited vertexes
		int nPrintVis = 0;
		System.out.print("Visited verts:\n\t");
		while(nPrintVis < visited.size())
		{
			System.out.print(visited.get(nPrintVis++));
			if(nPrintVis < visited.size())
			System.out.print(", ");
		}
		System.out.println();
	//----*/
		
		
		//System.out.print("Visitable edges: ");
		//For all visited nodes
		for(int x = 0; x < visited.size(); x++)
		{
			//For all potential edges of visited nodes
			for(int y = 0; y < adjMat[visited.get(x)].length; y++)
			{
				//There is an edge to an unvisited vertex
				if(adjMat[visited.get(x)][y] > 0 && !visited.contains(y))
				{
					//minIndexes reset for each do-while iteration
					if(minIndex_X == -1 || minIndex_Y == -1)
					{
						minIndex_X = visited.get(x);
						minIndex_Y = y;
						//System.out.print("r");
					}
					
					//System.out.print("\n\t" + visited.get(x) + "-" + y);
					//System.out.println("(" + visited.get(x) + ")" + vertices[y] + ": " + fmt.format(cost));
					
					//The smallest edge
					//System.out.print(" (" + adjMat[visited.get(x)][y] + " ? " + adjMat[minIndex_X][minIndex_Y] + ")");
					//If an unused edge is shorter than the current smallest edge
					if(adjMat[visited.get(x)][y] < adjMat[minIndex_X][minIndex_Y])
					{
						minIndex_Y = y;
						minIndex_X = visited.get(x);
						//System.out.print(" Yes!(" + minIndex_X + ", " + minIndex_Y + ")" + " = " + adjMat[minIndex_X][minIndex_Y]);
					}
				}
			}//End second for
		}//End first for
		//System.out.print("\n\t(" + minIndex_X + ", " + minIndex_Y+ ")" + " = " + adjMat[minIndex_X][minIndex_Y]);
		
		
		cost = adjMat[minIndex_X][minIndex_Y];
		total += cost;
		
		MST_Path.append(vertices[minIndex_X] + " - " + vertices[minIndex_Y] +
						": " + fmt.format(cost*1000) + "\n");
		
		//Changes for the next iteration
			n = minIndex_Y;
			minIndex_X = -1;
			minIndex_Y = -1;
		}while(visited.size() < vertices.length-1);
		
		
		MST_Path = MST_Path.reverse().replace(0, 2, "").reverse();
		System.out.println(MST_Path.toString());
		return ++total;	//Total was initialized as -1, pre-pended addition resolves that
	}
	
	//More of a service method, but doesn't change any values; should be okay for end-users to be able to see/use to better their understanding of whats happening in this class
	public void printTable()
	{
		StringBuilder message = new StringBuilder();
		message.append("\t\t");
		
		//Print horizontal labels
		for(int x = 0; x < vertices.length; x++)
		{
			//Limit the width
			if(vertices[x].length() > 7)
				message.append(vertices[x].substring(0, 7) + "\t");
			else
				message.append(vertices[x] + "\t");
			
		}
		
		//Print vertical labels & values
		for(int x = 0; x < adjMat.length; x++)
		{
			//Print vertical labels
			message.append("\n" + vertices[x] + "\t");
			
			//Ensure proper alignment
			if(vertices[x].length() < 8)
				message.append("\t");
			
			//Print values
			for(int y = 0; y < adjMat[x].length; y++)
				message.append(adjMat[x][y] + "\t");
		}

		message.append("\n");
		
		
		System.out.println(message.toString());
	}
}
