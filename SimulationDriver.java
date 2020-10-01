
public class SimulationDriver {

	//create a question type and configure answers
	//configure quesiton for iVote service
	//randomly generate a number of students and answers
	//submit all generated students answers to iVote service
	//call the iVote service to output function to display the result
	 public static void main(String[] args){
	        VotingService vs = new VotingService();
	        System.out.println("Here are the ID's of the current players! ");
	        vs.addStudents();
	        vs.addQuestions();
	        vs.answerQuestion();
	        System.out.println("/nStatistics");
	        vs.statistics();
	        System.out.println("FIN!");

	    }
}
