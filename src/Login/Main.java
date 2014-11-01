package Login;
/**
 * Created by abner on 11/1/14.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    final static String user = "abner";
    final static String pw = "me";
    String checkUser, checkPW;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hotel Toro");

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 50, 50, 50));

        //adding HBox
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 30));

        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //Implementing Nodes for GridPane
        Label labelUsName = new Label("Username");
        final TextField txtUsName = new TextField();
        Label labelPassword = new Label("Password");
        final PasswordField passwordField;
        passwordField = new PasswordField();
        Button btnLogin = new Button("Login");
        Button btnReg = new Button("Sign Up");
        final Label labelMessage = new Label();

        //Adding Nodes to GridPane layout
        gridPane.add(labelUsName, 0, 0);
        gridPane.add(txtUsName, 1, 0);
        gridPane.add(labelPassword, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(btnReg, 2, 0);
        gridPane.add(labelMessage, 1, 2);

        //Reflection for GridPane
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7f);
        gridPane.setEffect(reflection);

        //DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //Adding text and DropShadow effect
        Text text = new Text("Hotel Toro");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);

        //Adding text to HBox
        hBox.getChildren().add(text);

        //Add ID's to Nodes
        borderPane.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        btnReg.setId("btnReg");
        text.setId("text");

        //Action for btnLogin
        btnLogin.setOnAction(actionEvent -> {
            checkUser = txtUsName.getText();
            checkPW = passwordField.getText().toString();
            if (checkUser.equals(user) && checkPW.equals(pw)) {
                labelMessage.setText("Congratulation!");
                labelMessage.setTextFill(Color.GREEN);
            } else {
                labelMessage.setText("Incorrect Username or Password");
                labelMessage.setTextFill(Color.GREEN);
            }
            txtUsName.setText("");
            passwordField.setText("");
        });

        btnReg.setOnAction(actionEvent -> new Registration().Username(""));

        //Add HBox and GridPane layout to BorderPane Layout
        borderPane.setTop(hBox);
        borderPane.setCenter(gridPane);

        //Adding BorderPane to the scene and loading CSS
        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}