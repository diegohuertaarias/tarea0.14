import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Ventana de registro
        VBox registerLayout = new VBox(10);
        registerLayout.setPadding(new Insets(20));
        registerLayout.setAlignment(Pos.CENTER);

        Label registerTitleLabel = new Label("Registro de Usuario");
        registerTitleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField emailField = new TextField();
        emailField.setPromptText("Correo electrónico");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Contraseña");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirmar contraseña");

        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Fecha de alta");

        CheckBox privacyCheckBox = new CheckBox("Acepto la política de privacidad");

        Button registerButton = new Button("Registrarse");
        registerButton.setOnAction(e -> {
            if (emailField.getText().isEmpty() || passwordField.getText().isEmpty() ||
                    confirmPasswordField.getText().isEmpty() || datePicker.getValue() == null ||
                    !privacyCheckBox.isSelected()) {
                showAlert("Por favor, complete todos los campos y acepte la política de privacidad.");
            } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
                showAlert("Las contraseñas no coinciden.");
            } else {
                showAlert("Usuario registrado correctamente.");
            }
        });

        // Ventana de inicio de sesión
        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(20));
        loginLayout.setAlignment(Pos.CENTER);

        Label loginTitleLabel = new Label("Inicio de Sesión");
        loginTitleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Nombre de usuario");

        PasswordField loginPasswordField = new PasswordField();
        loginPasswordField.setPromptText("Contraseña");

        Button loginButton = new Button("Iniciar sesión");
        loginButton.setOnAction(e -> {
            if (usernameField.getText().equals("admin@gmail.com") && loginPasswordField.getText().equals("123")) {
                showAlert("Inicio de sesión correcto.");
            } else {
                showAlert("Nombre de usuario o contraseña incorrectos.");
            }
        });

        loginLayout.getChildren().addAll(loginTitleLabel, usernameField, loginPasswordField, loginButton);

        // Botón para abrir la ventana de inicio de sesión
        Button loginWindowButton = new Button("Iniciar Sesión");
        loginWindowButton.setOnAction(e -> {
            Stage loginStage = new Stage();
            loginStage.setTitle("Inicio de Sesión");
            Scene loginScene = new Scene(loginLayout, 300, 200);
            loginStage.setScene(loginScene);
            loginStage.show();
            primaryStage.hide();
        });

        // Crear diseño de la ventana de registro
        registerLayout.getChildren().addAll(registerTitleLabel, emailField, passwordField, confirmPasswordField,
                datePicker, privacyCheckBox, registerButton, loginWindowButton);

        // Configurar escena y mostrar ventana principal
        Scene registerScene = new Scene(registerLayout, 300, 350);
        primaryStage.setScene(registerScene);
        primaryStage.setTitle("Registro e Inicio de Sesión");
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
