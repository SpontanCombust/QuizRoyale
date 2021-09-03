package cedro_celuch.quizroyale;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

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

    private Button getButtonFromAnswerVal( PossibleAnswer answer ) {
        switch( answer ) {
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

    private Button getCorrectAnswerButton() {
        PossibleAnswer correctAnswer = questionPrompt.getCorrectAnswer();
        return getButtonFromAnswerVal( correctAnswer );
    }

    private void goToMainMenu() {
        try {
            StackPane mainMenuPane = FXMLLoader.load( getClass().getResource("main-menu.fxml") );
            QuizRoyaleApplication.mainScene.setRoot( mainMenuPane );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onAnswerButtonClickInternal( PossibleAnswer answer ) {
        if( !isAnswerPending && !isAnswerFinished ) {
            Button btn = getButtonFromAnswerVal(answer);

            isAnswerPending = true;
            isAnswerFinished = false;
            btn.getStyleClass().add("answer-button-pending");

            new Sleeper(3000, () -> {
                if( questionPrompt.getCorrectAnswer() == answer ) {
                    btn.getStyleClass().add("answer-button-correct");
                    new Sleeper(2000, () -> {
                        goToMainMenu();
                    });
                } else {
                    btn.getStyleClass().add("answer-button-incorrect");
                    getCorrectAnswerButton().getStyleClass().add("answer-button-correct");
                }
                isAnswerPending = false;
                isAnswerFinished = true;
            });
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
        onAnswerButtonClickInternal( PossibleAnswer.ANSWER_A );
    }

    @FXML
    void onAnswerBButtonClick() throws InterruptedException {
        onAnswerButtonClickInternal( PossibleAnswer.ANSWER_B );
    }

    @FXML
    void onAnswerCButtonClick() {
        onAnswerButtonClickInternal( PossibleAnswer.ANSWER_C );
    }

    @FXML
    void onAnswerDButtonClick() {
        onAnswerButtonClickInternal( PossibleAnswer.ANSWER_D );
    }
}
