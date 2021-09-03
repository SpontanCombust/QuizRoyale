package cedro_celuch.quizroyale;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class QuizRoyaleApplication extends Application {

    public static Scene mainScene;

    @Override
    public void start(Stage window) {
        try {
            StackPane mainMenuPane = FXMLLoader.load( getClass().getResource("main-menu.fxml") );
            mainScene = new Scene( mainMenuPane );

            window.setTitle( "Quiz Royale" );
            window.setScene( mainScene );
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}