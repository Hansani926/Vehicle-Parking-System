package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.OnDeliveryShiftTM;
import view.tm.ParkingTM;

import java.io.IOException;
import java.net.URL;


import static controller.MainFormController.vehicleInParkingList;
import static controller.MainFormController.vehicleOnDeliveryList;

public class TableFormController {
    public Button btnAD;
    public Button btnLO;
    public Button btnAV;
    public AnchorPane root;
    public AnchorPane parkingAnchorPane;
    public TableColumn colvehicleType;
    public TableColumn colvehicleNumber;
    public TableView tableparking;
    public TableColumn colparkingSlot;
    public TableColumn colparkedTime;
    public TableView tableOnDelivery;
    public TableColumn colVNum;
    public TableColumn colVType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public  String  type="In Parking";
    public ComboBox cmbpd;
    public TableColumn colVehicleNum;


    public  void  initialize() throws IOException{
        resultcmb();

        cmbpd.getItems().addAll("In Parking","On Delivery");

        cmbpd.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            type= String.valueOf(newValue);
            try {
                resultcmb();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        ObservableList<ParkingTM> obVehicleInParking = FXCollections.observableArrayList(vehicleInParkingList);
        colVehicleNum.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        colvehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colparkingSlot.setCellValueFactory(new PropertyValueFactory("parkingSlot"));
        colparkedTime.setCellValueFactory(new PropertyValueFactory("parkedTime"));
        tableparking.setItems(obVehicleInParking);

        ObservableList<OnDeliveryShiftTM> obDeliveryShift = FXCollections.observableArrayList(vehicleOnDeliveryList);
        colVNum.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        colVType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory("leftTime"));
        tableOnDelivery.setItems(obDeliveryShift);




    }

    private void resultcmb() throws IOException {
        if (type.equals("On Delivery")){
            tableparking.setVisible(false);
            tableOnDelivery.setVisible(true);


        }if(type.equals("In Parking")){
            tableparking.setVisible(true);
            tableOnDelivery.setVisible(false);
        }
    }


    public void btnAVOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/AddVehicleForm.fxml"));
        Parent parent=loader.load();
        AddVehicleFormController controller=loader.getController();
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        controller.closeStage(root);
        stage.setScene(scene);
        stage.setTitle("AddVehicleForm");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }



    public void btnADOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/AddDriverForm.fxml"));
        Parent parent=loader.load();
        AddDriverFormController controller=loader.getController();
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        controller.closeStage(root);
        stage.setScene(scene);
        stage.setTitle("AddDriverForm");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
       initUi("MainForm.fxml");

    }



    public void initUi(String location) throws IOException {

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+location))));
        stage.centerOnScreen();

    }



}
