module cedro_celuch.quizroyale {
    requires javafx.controls;
    requires javafx.fxml;


    opens cedro_celuch.quizroyale to javafx.fxml;
    exports cedro_celuch.quizroyale;
}