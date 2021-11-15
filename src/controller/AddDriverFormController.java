package controller;

import com.sun.deploy.net.MessageHeader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import static controller.MainFormController.driverArrayList;

public class AddDriverFormController {
    public TextField txtDriverName;
    public TextField txtNic;
    public TextField txtDLN;
    public TextField txtAddress;
    public TextField txtContactNo;
    public Button btnDriver;
    public AnchorPane AddDriverAnchorPane;

    String addDriver="null";
    Stage stage;


    public void AddDriverOnAction(ActionEvent actionEvent) {
        String addName=txtDriverName.getText();
        String addNIC=txtNic.getText();
        String addLi=txtDLN.getText();
        String addAddress=txtAddress.getText();
        String addContact=txtContactNo.getText();
        driverArrayList.add(new Driver(addName,addNIC,addLi,addAddress,addContact));
        stage= (Stage)AddDriverAnchorPane.getScene().getWindow();
        stage.close();;
    }



    public void closeStage(AnchorPane root) {
    }
}
