package cedro_celuch.quizroyale;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private StackPane mainPane;

    @FXML
    protected void onPlayButtonClick() {
        try {
            StackPane gamePane = FXMLLoader.load( getClass().getResource("game-panel.fxml") );

            mainPane.getChildren().setAll( gamePane );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onExitButtonClick() {
        Stage mainStage = (Stage)mainPane.getScene().getWindow();
        mainStage.close();
    }
}