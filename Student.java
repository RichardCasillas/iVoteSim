import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {

	//be able to submit answers
	//unique ID (String)
	
    public String iD;
    public boolean isCorrect;
    public char mcAnswer;
    public boolean tfAnswer;

    public Student( String iD, boolean isCorrect) {
        this.iD = iD;
        this.isCorrect = isCorrect;
    }

    public String getStudentId() {
        return iD;
    }

    public void setStudentId(String studentId) {
        this.iD = studentId;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean isTfAnswer() {
        return tfAnswer;
    }

    public void setTfAnswer(boolean tfAnswer) {
        this.tfAnswer = tfAnswer;
    }
}
