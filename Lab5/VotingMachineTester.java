import java.util.Random;

public class VotingMachineTester 
{
	public static void main(String[] args)
	{
		VotingMachine vm = new VotingMachine("Democrats","Republicans");
		
		int  votes1 = 7736;
		for (int i = 0; i < votes1; i++)
			vm.voteParty1();
		
		int votes2 = 7624;
		for (int i = 0; i < votes2; i++)
			vm.voteParty2();
		
		System.out.println("Party1 votes " + vm.getNumVotes1());
		System.out.println("Party2 votes " + vm.getNumVotes2());
		System.out.println(vm.getWinner());
		System.out.println("Expected:\nParty1 votes 7736\nParty2 votes 7624\nDemocrats win the election with 7736 votes");
		
		vm.newElection();
		vm.voteParty1();vm.voteParty1();
		vm.voteParty2();vm.voteParty2();
		System.out.println("Party1 votes " + vm.getNumVotes1());
		System.out.println("Party2 votes " + vm.getNumVotes2());
		System.out.println(vm.getWinner());
		System.out.println("Expected:\nParty1 votes 2\nParty2 votes 2\nDemocrats and Republicans tied with 2 votes");
	}
}
