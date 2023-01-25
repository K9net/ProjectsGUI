package Serialize.FleshCards;

public class QuizCard {
    private String question;
    private String answer;

    QuizCard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}
