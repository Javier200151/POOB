package checkers;


/**
 * Write a description of class CheckersContest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheckersContest
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class CheckersContest
     */
    public CheckersContest()
    {
        // initialise instance variables
        
    }

    public String solve(char player,String[] moves){
        Solution sol = new Solution();
        String res=sol.solu(player,moves);
        return res;
    }
    public void simulate(char player,String[] moves, boolean slow){
        Checkers checks = new Checkers(8);
    } 
}
