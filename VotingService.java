import java.util.*;


public class VotingService {

	//configure to have a given question type and candidate answers
	//start accepting submissions from student
	//each student can only submit one answer
	//if multiple submissions received, only the last is counted
	//output statistics of submission results

	public Random rand = new Random();
	public LinkedList<Student> studentBank = new LinkedList<>(); //a linkedlist of the Student type
	public LinkedList<Question> questionBank = new LinkedList<>(); //an linkedlist of the Question type
	char[][] mcAnswers = new char[10][5]; 	// 10 = number of students, 5 = number of mc questions
	boolean[][] tfAnswers = new boolean[10][2];
	public int counter = 0;

	//method to generate a random 9 digit string id
	public String genID() {
		String numbs = "0123456789";
		int n = 9;
		StringBuilder sb = new StringBuilder(n);
		for(int j = 0; j < n; j++) {
			int index = (int) (numbs.length() * Math.random());
			sb.append(numbs.charAt(index));
		}
		return sb.toString();
	}
	
	public void addStudents() {
		//make Student objects to add to linked list
		Student s0 = new Student(genID(), false);
		Student s1 = new Student(genID(), false);
		Student s2 = new Student(genID(), false);
		Student s3 = new Student(genID(), false);
		Student s4 = new Student(genID(), false);
		Student s5 = new Student(genID(), false);
		Student s6 = new Student(genID(), false);
		Student s7 = new Student(genID(), false);
		Student s8 = new Student(genID(), false);
		Student s9 = new Student(genID(), false);

		//add to Linked list
		studentBank.add(s0);
		studentBank.add(s1);
		studentBank.add(s2);
		studentBank.add(s3);
		studentBank.add(s4);
		studentBank.add(s5);
		studentBank.add(s6);
		studentBank.add(s7);
		studentBank.add(s8);
		studentBank.add(s9);

		//print out all the ID's of the students
		for (Student s: studentBank){
			System.out.println(s.getStudentId());
		}

	}
	public void addQuestions() {
		//make string arrays for question options A-E
		String[] q1op = new String[] {"A: Zelda", "B: Pikachu", "C: Sonic", "D: Mario"};
		String[] q2op = new String[] {"A: Iron Man", "B: Hulk", "C: Spider Man", "D: Shazam"};
		String[] q3op = new String[] {"A: 4", "B: 1", "C: 8", "D: 20", "E: 7"};
		String[] q4op = new String[] {"A: Superman", "B: Batman", "C: The Flash", "D: Wonderwoman"};
		String[] q5op = new String[] {"A: Luke Skywalker", "B: Darth Vader", "C: Princess Leia", "D: Yoda"};

		
		//make questions with correct answer and corresponding options 
		//mc questions
		Question q1 = new Question("Which game character is the face of Nintendo? ", q1op, "D: Mario", "Multiple Choice");
		Question q2 = new Question("Which hero is not from Marvel? ", q2op, "D: Shazam", "Multiple Choice");
		Question q3 = new Question("How many generations of Pokemon games are there? ", q3op, "C: 8", "Multiple Choice");
		Question q4 = new Question("Who is considered the strongest DC hero? ", q4op, "A: Superman", "Multiple Choice");
		Question q5 = new Question("Which Star Wars character speaks in Anastrophe? ",q5op , "D: Yoda", "Multiple Choice");
		//t/f questions
		Question q6 = new Question("TRUE or FALSE: In the Pokemon games, the Unova region is primarily based on the geography of the Japanese island of Hokkaido. ", true, false, false, "True/False");
		Question q7 = new Question("TRUE or FALSE: Batman and Superman both have hero dogs. ", true, false, true, "True/False");

		//add to Linked List
		questionBank.add(q1);
		questionBank.add(q2);
		questionBank.add(q3);
		questionBank.add(q4);
		questionBank.add(q5);
		questionBank.add(q6);
		questionBank.add(q7);
	}



	public void answerQuestion() {
		for (Question q : questionBank){
			System.out.println("\n" + q.getQuestion());
			if (q.getType().contains("Multiple Choice")) {
					System.out.println(Arrays.toString(q.options));
			}
			else{
				System.out.println(q.isT() + " or " + q.isF() + " ?");
			}
			for(Student s : studentBank) {
				if (q.getType().contains("Multiple Choice")) {
					for (int i = 0; i < mcAnswers.length; i++) { //10 rows of students
						for ( int j = 0; j < mcAnswers[i].length; j++) { //7 columns for questions
							char mcA = (char) (rand.nextInt(4) + 'a');
							mcAnswers[i][j] = mcA;
							boolean questionResult = Objects.equals(mcA, q.getCorrectAnswer()); //if the student's answer is equal to the correct answer
							if (questionResult) { //if it is the correct answer
								s.isCorrect = true;

							}
						}
					}
				}
				else {
					for(int i = 0; i < tfAnswers.length; i++) {
						for(int j = 0; j < tfAnswers[i].length; j++) {
							boolean tfA = rand.nextBoolean();
							if(tfA){
								tfAnswers[i][j] = true; //for true
							}
							else{
								tfAnswers[i][j] = false; //for false
							}
							if (tfA == q.tfCorrectAnswer) { //if it is the correct answer
								s.isCorrect = true; 
							}
						}
					}
				}
			}
		}
	}


	public void statistics() {
		int counterA = 0;
		int counterB = 0;
		int counterC = 0;
		int counterD = 0;
		int arrA[] = new int[5];
		int arrB[] = new int[5];
		int arrC[] = new int[5];
		int arrD[] = new int[5];
		for (Question q : questionBank) {
			if (q.getType().contains("Multiple Choice")) {
				System.out.println(q.getQuestion()); 
				System.out.println(q.getCorrectAnswer());
				//how many students voted for each letter
				
				for(int i = 0; i < mcAnswers.length; i++) { 
					for(int j = 0; j < mcAnswers[i].length; j++) {
						if (mcAnswers[i][j] == 'a'){
							arrA[j] = counterA++;
						}
						else if(mcAnswers[i][j] == 'b'){
							arrB[j] = counterB++;
						}
						else if(mcAnswers[i][j] == 'c'){
							arrC[j] = counterC++;
						}
						else if(mcAnswers[i][j] == 'd'){
							arrD[j] = counterD++;
						}

					}
					
					counterA = 0;
					counterB = 0;
					counterC = 0;
					counterD = 0;
				}
				for(int i = 0; i < 5; i++) {
					System.out.println(arrA[i] + " Students chose option A.");
					System.out.println(arrB[i] + " Students chose option B.");
					System.out.println(arrC[i] + " Students chose option C.");
					System.out.println(arrD[i] + " Students chose option D.");
				}

			} else {
				System.out.println(q.getQuestion()); //print the T/F question
				System.out.println(q.iscA());
				//counters
				int Tcount = 0;
				int Fcount = 0;
				for(int i = 0; i < tfAnswers.length; i++) { 
					for (int j = 0; j < tfAnswers[i].length; j++) { 
						if (tfAnswers[i][j] == true){
							Tcount++;
						}
						else{
							Fcount++;
						}
					}
				}
				System.out.println("The Number of students that voted True are: " + Tcount);
				System.out.println("The Number of students that voted False are: " + Fcount);
			}
		}
	}
}
