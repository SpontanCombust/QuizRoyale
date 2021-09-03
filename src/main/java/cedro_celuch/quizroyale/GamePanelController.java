package cedro_celuch.quizroyale;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GamePanelController {

    private QuestionPrompt questionPrompt;

    boolean isAnswerPending; 
    boolean isAnswerFinished; 

    @FXML
    private Label playerNameLabel;
    @FXML
    private Label questionLabel;

    @FXML
    private Button answerAButton;
    @FXML
    private Button answerBButton;
    @FXML
    private Button answerCButton;
    @FXML
    private Button answerDButton;


    @FXML
    public void initialize() {
        questionPrompt = new QuestionPrompt();

        isAnswerPending = false;
        isAnswerFinished = false;

        // temporary - start
        playerNameLabel.setText("(you)");
        
        questionPrompt.setQuestionText("What is an answer to this question?");

        questionPrompt.setAnswerText(PossibleAnswer.ANSWER_A, "Answer A");
        questionPrompt.setAnswerText(PossibleAnswer.ANSWER_B, "Answer B");
        questionPrompt.setAnswerText(PossibleAnswer.ANSWER_C, "Answer C");
        questionPrompt.setAnswerText(PossibleAnswer.ANSWER_D, "Answer D");

        questionPrompt.setCorrectAnswer( PossibleAnswer.ANSWER_B );
        // temporary - end

        setupQuestionPromptPanelLabels();
    }

    private void setupQuestionPromptPanelLabels() {
        questionLabel.setText( questionPrompt.getQuestionText() );

        answerAButton.setText( "A. " + questionPrompt.getAnswerText( PossibleAnswer.ANSWER_A ) );
        answerBButton.setText( "B. " + questionPrompt.getAnswerText( PossibleAnswer.ANSWER_B ) );
        answerCButton.setText( "C. " + questionPrompt.getAnswerText( PossibleAnswer.ANSWER_C ) );
        answerDButton.setText( "D. " + questionPrompt.getAnswerText( PossibleAnswer.ANSWER_D ) );
    }

    private Button getCorrectAnswerButton() {
        PossibleAnswer correctAnswer = questionPrompt.getCorrectAnswer();

        switch( correctAnswer ) {
            case ANSWER_A:
                return answerAButton;
            case ANSWER_B:
                return answerBButton;
            case ANSWER_C:
                return answerCButton;
            case ANSWER_D:
                return answerDButton;
            default:
                return null;
        }
    }

    @FXML
    protected void onAnswersResetClick() {
        if( isAnswerFinished ) {
            answerAButton.getStyleClass().removeAll( "answer-button-pending", "answer-button-correct", "answer-button-incorrect" );
            answerBButton.getStyleClass().removeAll( "answer-button-pending", "answer-button-correct", "answer-button-incorrect" );
            answerCButton.getStyleClass().removeAll( "answer-button-pending", "answer-button-correct", "answer-button-incorrect" );
            answerDButton.getStyleClass().removeAll( "answer-button-pending", "answer-button-correct", "answer-button-incorrect" );
            isAnswerFinished = false;
        }
    }

    @FXML
    protected void onAnswerAButtonClick() {
        if( !isAnswerPending && !isAnswerFinished ) {

            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        isAnswerPending = true;
                        isAnswerFinished = false;
                        answerAButton.getStyleClass().add("answer-button-pending");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
                @Override
                protected void succeeded() {
                    if( questionPrompt.getCorrectAnswer() == PossibleAnswer.ANSWER_A ) {
                        answerAButton.getStyleClass().add("answer-button-correct");
                    } else {
                        answerAButton.getStyleClass().add("answer-button-incorrect");
                        getCorrectAnswerButton().getStyleClass().add("answer-button-correct");
                    }
                    isAnswerPending = false;
                    isAnswerFinished = true;
                }
            };

            new Thread(sleeper).start();
        }
    }

    @FXML
    void onAnswerBButtonClick() {
        if( !isAnswerPending && !isAnswerFinished ) {
            
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        isAnswerPending = true;
                        isAnswerFinished = false;
                        answerBButton.getStyleClass().add("answer-button-pending");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
                @Override
                protected void succeeded() {
                    if( questionPrompt.getCorrectAnswer() == PossibleAnswer.ANSWER_B ) {
                        answerBButton.getStyleClass().add("answer-button-correct");
                    } else {
                        answerBButton.getStyleClass().add("answer-button-incorrect");
                        getCorrectAnswerButton().getStyleClass().add("answer-button-correct");
                    }
                    isAnswerPending = false;
                    isAnswerFinished = true;
                }
            };

            new Thread(sleeper).start();
        }
    }

    @FXML
    void onAnswerCButtonClick() {
        if( !isAnswerPending && !isAnswerFinished ) {

            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        isAnswerPending = true;
                        isAnswerFinished = false;
                        answerCButton.getStyleClass().add("answer-button-pending");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
                @Override
                protected void succeeded() {
                    if( questionPrompt.getCorrectAnswer() == PossibleAnswer.ANSWER_C ) {
                        answerCButton.getStyleClass().add("answer-button-correct");
                    } else {
                        answerCButton.getStyleClass().add("answer-button-incorrect");
                        getCorrectAnswerButton().getStyleClass().add("answer-button-correct");
                    }
                    isAnswerPending = false;
                    isAnswerFinished = true;
                }
            };

            new Thread(sleeper).start();
        }
    }

    @FXML
    void onAnswerDButtonClick() {
        if( !isAnswerPending && !isAnswerFinished ) {

            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        isAnswerPending = true;
                        isAnswerFinished = false;
                        answerDButton.getStyleClass().add("answer-button-pending");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
                @Override
                protected void succeeded() {
                    if( questionPrompt.getCorrectAnswer() == PossibleAnswer.ANSWER_D ) {
                        answerDButton.getStyleClass().add("answer-button-correct");
                    } else {
                        answerDButton.getStyleClass().add("answer-button-incorrect");
                        getCorrectAnswerButton().getStyleClass().add("answer-button-correct");
                    }
                    isAnswerPending = false;
                    isAnswerFinished = true;
                }
            };

            new Thread(sleeper).start();
        }
    }
}
