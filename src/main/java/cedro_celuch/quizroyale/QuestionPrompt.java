package cedro_celuch.quizroyale;

public class QuestionPrompt {
    private String questionText;
    private String answerAText;
    private String answerBText;
    private String answerCText;
    private String answerDText;
    private PossibleAnswer correctAnswer;

    QuestionPrompt() {

    }

    public void setQuestionText( String text ) {
        questionText = text;
    } 

    public String getQuestionText() {
        return questionText;
    }
    
    public void setAnswerText( PossibleAnswer answer, String text ) {
        switch( answer ) {
            case ANSWER_A:
                answerAText = text;
                break;
            case ANSWER_B:
                answerBText = text;
                break;
            case ANSWER_C:
                answerCText = text;
                break;
            case ANSWER_D:
                answerDText = text;
                break;
        }
    }

    public String getAnswerText( PossibleAnswer answer ) {
        switch( answer ) {
            case ANSWER_A:
                return answerAText;
            case ANSWER_B:
                return answerBText;
            case ANSWER_C:
                return answerCText;
            case ANSWER_D:
                return answerDText;
            default:
                return answerAText;
        }
    }

    public void setCorrectAnswer( PossibleAnswer answer ) {
        correctAnswer = answer;
    }

    public PossibleAnswer getCorrectAnswer() {
        return correctAnswer;
    }
}
