package controller;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public TextField txtUserName;
    public Button btnCancel;
    public Button btnLogin;
    public PasswordField txtPassword;
    public AnchorPane root;




    public void setUI(String location) throws IOException {

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+location))));
        stage.centerOnScreen();
    }


    public void CancelOnAction(ActionEvent actionEvent) {

    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();

        if (userName.length()>0 && password.length()>0){

            if (userName.equalsIgnoreCase("Admin")
                    && password.equalsIgnoreCase("1234")){


                URL resource = this.getClass().
                        getResource("/view/TableForm.fxml");

                Parent load = FXMLLoader.load(resource);
                Scene scene= new Scene(load);
                Stage stage= (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
               

            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again !!!!",
                        ButtonType.OK,ButtonType.NO).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty !!!!",
                    ButtonType.OK,ButtonType.NO).show();
        }


    }

    Stage stage;
    public void closeStage(AnchorPane root) {
        stage=(Stage) root.getScene().getWindow();
        stage.close();
    }

}


