package checkers;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	static HashMap<Integer,List<Integer>> dic = new HashMap<>();
	public boolean res;
	public static ArrayList<String> matrix1=new ArrayList<String>(8);
	public String[] matrix2;
	public static Integer counter;
    public Solution()
    {
        
        
    }
	public static void main(String[] args) 
	{
		Scanner myObj = new Scanner(System.in);
		String userName = myObj.nextLine();
		String[] parts=userName.split(" ");
		int inputs = Integer.parseInt(parts[1]);
		Solution solution= new Solution();
		counter=1;
		for(int i=0;i<matrix1.size();i++) 
		{
			ArrayList<String> file=new ArrayList<String>();
			for(int j=0;i<matrix1.size();j++) 
			{
				int controller=(i+j)%2;
				if(controller==1) 
				{
					file.add(".");
					Integer[] values= {i,j};
					dic.put(counter,Arrays.asList(values));
					counter++;
				}
				else 
				{
					file.add("-");
				}
			}
			matrix1.addAll(file);
		}
		
		for(int i=0;i<inputs;i++)
		{
			String moves = myObj.nextLine();
			boolean x=solution.verify(moves);
			if(x==true) 
			{
				System.out.println("es un move");
			}
			else if(x==false)
			{
				System.out.println("es un jump");
			}
		}
	}

	public String solu(char player,String[] moves)
	{
	    return ("johann es gurrero");
	}
	public  boolean verify(String moves) 
	{
		for(int i=0;i<moves.length();i++) 
		{
			
			if(moves.charAt(i)=='-') 
			{
				 res=true;
				 
			}
			else if(moves.charAt(i)=='x')
			{
			
				res=false;
					 
			}
		}
		return res;
		
	}
}