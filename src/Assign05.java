import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Assign05
{
	public static void main(String[] args)
	{
		Graph g = buildGraph();
	
		int cost = g.prims(0) * 1000;
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		System.out.println("Total Cost: " + fmt.format(cost));
		
		//g.printTable();
	}
	
	private static Graph buildGraph()
	{
		String names[] = {"Seattle", "San Francisco",
				"Las Vegas", "Los Angeles", "Denver",
				"Minneapolis", "Dallas", "Chicago",
				"Washington DC", "Boston", "New York",
				"Miami"};
		
		Graph g = new Graph(names);
		g.addEdge(0, 1, 1306);
		g.addEdge(0, 4, 2161);
		g.addEdge(0, 5, 2661);
		g.addEdge(1, 2, 919);
		g.addEdge(1, 3, 629);
		g.addEdge(2, 3, 435);
		g.addEdge(2, 4, 1225);
		g.addEdge(4, 5, 1483);
		g.addEdge(4, 6, 1258);
		g.addEdge(5, 6, 1532);
		g.addEdge(5, 7, 661);
		g.addEdge(6, 8, 2113);
		g.addEdge(6, 11, 2161);
		g.addEdge(7, 8, 1145);
		g.addEdge(7, 9, 1613);
		g.addEdge(8, 9, 725);
		g.addEdge(8, 10, 383);
		g.addEdge(8, 11, 1709);
		g.addEdge(9, 10, 338);
		g.addEdge(10, 11, 2145);
		return g;
	}
	
	

}
