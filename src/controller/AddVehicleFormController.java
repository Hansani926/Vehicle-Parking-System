package controller;

import com.sun.deploy.net.MessageHeader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Bus;
import model.CargoLorry;
import model.Van;

import static controller.MainFormController.parkedList;
import static controller.MainFormController.vehicleArrayList;
public class AddVehicleFormController {
    public TextField txtVNumber;
    public TextField txtMWeight;
    public TextField txtNoP;
    public ComboBox cmbVehicleType;
    public Button btnAV;
    String vehicleTypeAdd="null";
    public void AddVehicleOnAction(ActionEvent actionEvent) {
        String vehicleNewNum = txtVNumber.getText();
        String vehicleNewType = vehicleTypeAdd;
        String vehicleNewWeight = txtMWeight.getText();
        String vehicleNewPassenger = txtNoP.getText();
        switch (vehicleTypeAdd) {
            case "Bus":vehicleArrayList.add(new Bus(vehicleNewNum,vehicleNewType,vehicleNewWeight,vehicleNewPassenger));
                parkedList.add(txtVNumber.getText());break;
            case "Van":vehicleArrayList.add(new Van(vehicleNewNum,vehicleNewType,vehicleNewWeight,vehicleNewPassenger));
                parkedList.add(txtVNumber.getText());break;
            case "CargoLorry":vehicleArrayList.add(new CargoLorry(vehicleNewNum,vehicleNewType,vehicleNewWeight,vehicleNewPassenger));
                parkedList.add(txtVNumber.getText());
        }
        txtVNumber.clear();
        txtMWeight.clear();
        txtNoP.clear();

    }

    public void initialize(){
        ObservableList<String> addVehicleType= FXCollections.observableArrayList();
        addVehicleType.add("Bus");
        addVehicleType.add("Van");
        addVehicleType.add("Cargo Lorry");
        cmbVehicleType.setItems(addVehicleType);

        cmbVehicleType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            vehicleTypeAdd= (String) newValue;

        });

    }

    public void closeStage(AnchorPane root) {
    }
}
