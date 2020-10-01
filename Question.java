
public class Question {

	//need mc question type and TF question type
	
	public String question; //store question
    //A-E are for storing the options chosen by the student from MC Questions
	public String[] options;
    public String correctAnswer; //stores the correct answer of the question
    //t and f are for storing the options chosen by the student from T/F Questions
    public boolean t;
    public boolean f;
    public boolean tfCorrectAnswer; //stores the correct answer of the tf/question
    public String type; //t/f or mc

    //mc constructor
    public Question(String question, String[] options, String correctAnswer, String type) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.type = "Multiple Choice";
        this.options = options;
    }
    //t/f constructor 
    public Question(String question, boolean t, boolean f, boolean cA, String type) {
        this.question = question;
        this.t = true;
        this.f = false;
        this.tfCorrectAnswer = cA;
        this.type = "True/False";
    }
public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean isT() {
        return t;
    }

    public void setT(boolean t) {
        this.t = t;
    }

    public boolean isF() {
        return f;
    }

    public void setF(boolean f) {
        this.f = f;
    }

    public boolean iscA() {
        return tfCorrectAnswer;
    }

    public void setcA(boolean cA) {
        this.tfCorrectAnswer = cA;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}
	
}
