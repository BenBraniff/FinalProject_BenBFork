import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");
        
        Label usernameLabel = new Label("Username:");
        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Enter your username");

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = usernameTextField.getText();
            String password = passwordField.getText();
            if (username.equals("user") && password.equals("password")) {
                openNewWindow();
                primaryStage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid username or password");
                alert.showAndWait();
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameTextField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);

        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openNewWindow() {
        Stage stage = new Stage();
        stage.setTitle("Welcome");
        Label label = new Label("Welcome!");
        Scene scene = new Scene(label, 200, 100);
        stage.setScene(scene);
        stage.show();
    }
}

