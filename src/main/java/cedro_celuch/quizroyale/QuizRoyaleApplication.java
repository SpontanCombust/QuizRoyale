package cedro_celuch.quizroyale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizRoyaleApplication extends Application {
    @Override
    public void start(Stage window) {
        try {
            Scene mainMenuScene = new Scene( FXMLLoader.load( getClass().getResource("main-menu.fxml") ) );

            window.setTitle( "Quiz Royale" );
            window.setScene( mainMenuScene );
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}