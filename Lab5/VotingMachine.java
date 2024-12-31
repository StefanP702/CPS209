public class VotingMachine
{
	/* 
	 * party1Name and party2Name each store the name of a political party
	 * numVotes1 and numVotes2 are used to record number of votes for each political party
	 */
	String party1Name;
	String party2Name;
	int numVotes1, numVotes2;


	/**
      Create a constructor method that has 2 String arguments which 
      are used to initialize the name of each political party
      Set the number of votes for each party to 0
	 */
	//$start
	public VotingMachine(String name1, String name2)
	{
		party1Name = name1;
		party2Name = name2;
		numVotes1 = numVotes2 = 0;
	}
	//$end

	//$start Create accessor methods for each instance variable (i.e. "getters")
	public String getParty1Name()
	{
		return party1Name;
	}

	public String getParty2Name()
	{
		return party2Name;
	}

	public int getNumVotes1()
	{
		return numVotes1;
	}

	public int getNumVotes2()
	{
		return numVotes2;
	}
	//$end


	/**
      Create a public method voteParty1() which adds one vote for political
      party 1
	 */
	//$start
	public void voteParty1()
	{
		numVotes1++;
	}
	//$end



	/**
     Create a public method voteParty2() which adds one vote for political
      party 2
	 */
	//$start
	public void voteParty2()
	{
		numVotes2++;
	}
	//$end



	/**
	 * Create a public method newElection() that sets the current number of votes for 
	 * each political party to 0
	 */
	//$start
	public void newElection()
	{
		numVotes1 = numVotes2 = 0;
	}
	//$end



	/**
	 * Create a public method getWinner() that returns a String.
	 * If party 1 has more votes than party 2 then return the string 
	 * containing: the name of party 1 followed by " win the election with "
	 * followed by the number of votes for party 1 followed by " votes"
	 * 
	 * If party 2 has more votes than party 1 then return the string 
	 * containing: the name of party 2 followed by " win the election with "
	 * followed by the number of votes for party 2 followed by " votes"
	 * 
	 * If party 2 has the same votes as party 1 then return the string 
	 * containing: the name of party 1 followed by " and " followed by
	 * the name of party 2 followed by " tied with " followed by the 
	 * number of votes for party 1 followed by " votes"
	 */
	//$start
	public String getWinner()
	{
		if (numVotes1 > numVotes2)
		{
			return party1Name + " win the election with " + numVotes1 + " votes";
		}
		else if (numVotes2 > numVotes1)
		{
			return party2Name + " win the election with " + numVotes2 + " votes";
		}
		else
			return party1Name + " and " + party2Name + " tied with " + numVotes1 + " votes";
	}
	//$end



	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
