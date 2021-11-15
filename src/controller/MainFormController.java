package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import view.tm.OnDeliveryShiftTM;
import view.tm.ParkingTM;


import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;




public class MainFormController extends Vehicle{
    public ComboBox cmbVehicle;
    public TextField txtVehicleType;
    public ComboBox cmbDriver;
    public Label lblPSN;
    public Label lblTime;
    public Label lblDate;
    public Button btnPV;
    public Button btnODS;
    public Button btnML;
    public AnchorPane root;



    public Text slotNum;
    public TextField txtSlotNum;
    public TextField txtDate;
    public TextField txtTime;

    boolean b;
    public String vehicleNum="null";
    public String vehicleType;
    public String driverName="null";
    int index;

    static ArrayList <Vehicle>vehicleArrayList=new ArrayList();
    static ArrayList <Driver>driverArrayList=new ArrayList();
    static  ArrayList<DriverShift> driverShiftList=new ArrayList<>();
    static ArrayList<String>  parkedList =new ArrayList<>();

   static ArrayList<ParkingTM> vehicleInParkingList=new ArrayList<>();
    static ArrayList<OnDeliveryShiftTM> vehicleOnDeliveryList=new ArrayList<>();

    Time time=new Time();



    static {
        vehicleArrayList.add(new Bus("NA-3434", "Bus", "3500", "60"));
        vehicleArrayList.add(new Van("KA-4563", "Van", "1000", "7"));
        vehicleArrayList.add(new Van("58-3567", "Van", "1500", "4"));
        vehicleArrayList.add(new Van("GF-4358", "Van", "800", "4"));
        vehicleArrayList.add(new Van("CCB-3568", "Van", "1800", "8"));
        vehicleArrayList.add(new Van("LM-6679", "Van", "1500", "4"));
        vehicleArrayList.add(new Van("QA-3369", "Van", "1800", "6"));
        vehicleArrayList.add(new CargoLorry("KB-3668", "Cargo Lorry", "2500", "2"));
        vehicleArrayList.add(new CargoLorry("JJ-9878", "Cargo Lorry", "3000", "2"));
        vehicleArrayList.add(new CargoLorry("GH-5772", "Cargo Lorry", "4000", "3"));
        vehicleArrayList.add(new CargoLorry("XY-4456", "Cargo Lorry", "3500", "2"));
        vehicleArrayList.add(new CargoLorry("YQ-3536", "Cargo Lorry", "2000", "2"));
        vehicleArrayList.add(new CargoLorry("CCB-3566", "Cargo Lorry", "2500", "2"));
        vehicleArrayList.add(new CargoLorry("QH-3444", "Cargo Lorry", "5000", "4"));



      driverArrayList.add(new Driver("Amila Pathirana","8826253734V","B3354674","Galle","0717573583"));
        driverArrayList.add(new Driver("Jithmal Perera","9283289272V","B3674589","Horana","0772452457"));
        driverArrayList.add(new Driver("Sumith Dissanayaka","9425245373V","B8366399","Kaluthara","0782686390"));
        driverArrayList.add(new Driver("Sumanasiri Herath","8976544373V","B3537538","Beruwala","0772534436"));
        driverArrayList.add(new Driver("Awantha Fernando","9173537839V","B3554789","Colombo 5","0714534356"));
        driverArrayList.add(new Driver("Charith Sudara","9573536833V","B6835836","Baththaramulla","0771536662"));
        driverArrayList.add(new Driver("Prashan Dineth","9362426738V","B2683536","Wadduwa","0715353434"));
        driverArrayList.add(new Driver("Chethiya Dilan","9162353436V","B6836836","Panadura","0772436737"));
        driverArrayList.add(new Driver("Dushantha Perera","9255556343V","B3334435","Matara","0777245343"));
        driverArrayList.add(new Driver("Sumith Udayanga","8735354355V","B3573783","Galle","0703635442"));
        driverArrayList.add(new Driver("Dinesh Udara","9026344373V","B5343783","Hettimulla","0713456878"));
        driverArrayList.add(new Driver("Udana Chathuranga","9692653338V","B7888632","Kottawa","0772442444"));
        driverArrayList.add(new Driver("Mohommad Riaz","9124537733V","B3638537","Kaluthara","0777544222"));
        driverArrayList.add(new Driver("Sandun Kumara","9563524267V","B2263333","Panadura","0772325544"));
        driverArrayList.add(new Driver("Priyanga Perera","9135343537V","B3853753","Matara","0723344562"));

        for (int i=0; i<vehicleArrayList.size(); i++) {
            parkedList.add(vehicleArrayList.get(i).vehicleNum);
        }
    }



    public void initialize() throws IOException{
        txtDate.setText((String.valueOf(LocalDate.now())));
        setTime();

        ObservableList<String> ob= FXCollections.observableArrayList();
        for (Vehicle v:vehicleArrayList){
            ob.add(v.vehicleNum);

        }
        cmbVehicle.setItems(ob);



        cmbVehicle.getSelectionModel().selectedItemProperty().addListener((observable , oldValue, newValue) -> {

            vehicleNum = String.valueOf(newValue);

            for (int i = 0; i < vehicleArrayList.size(); i++) {
                if (vehicleNum.equals(vehicleArrayList.get(i).vehicleNum)) {
                    txtVehicleType.setText(vehicleArrayList.get(i).vehicleType);
                    break;
                }

            }
            vehicleType=txtVehicleType.getText();

            b=false;
            for (int i=0; i<driverShiftList.size(); i++){
                if (vehicleNum.equals(driverShiftList.get(i).getVehicleNumber())){
                    cmbDriver.setValue(driverShiftList.get(i).getDriverName());
                    b=true;
                    break;
                }
            }
            if (b==false){
                cmbDriver.setValue("");
            }

            b=false;

            for (int i = 0; i<parkedList.size(); i++){
                if (vehicleNum.equals(parkedList.get(i))){
                    btnPV.setDisable(true);
                    b=true;
                    break;
                }
            }
            if (b==false){
                btnPV.setDisable(false);
            }

        });
        ObservableList<String> dr= FXCollections.observableArrayList();
        for (Driver d:driverArrayList){
            dr.add(d.getdName());

        }
        cmbDriver.setItems(dr);


        cmbDriver.getSelectionModel().selectedItemProperty().addListener((observable , oldValue, newValue) -> {
            driverName= (String) newValue;
            b=false;
            for (int i=0; i<driverShiftList.size(); i++){
                if (driverName.equals(driverShiftList.get(i).getDriverName()) | vehicleNum.equals(driverShiftList.get(i).getVehicleNumber())){
                    btnODS.setDisable(true);
                    b=true;
                    break;
                }
            }
            if (b==false){
                btnODS.setDisable(false);
            }
        });



    }






    private void setTime() {
        Timeline timeLine = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            txtTime.setText(LocalDateTime.now().format(formatter));
        }),
                new KeyFrame(Duration.seconds(1)));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }






    public void parkOnAction(ActionEvent actionEvent) {
        if (parkedList.isEmpty()) {
            park();
            new Alert(Alert.AlertType.CONFIRMATION, "Parking completed", ButtonType.CLOSE).show();

            System.out.println("Hello Hansi");

        } else {
            int index = -1;
            for (int i = 0; i < parkedList.size(); i++) {
                if (vehicleNum.equals(parkedList.get(i))) {
                    index = i;
                }
            }
            if (vehicleNum.equals("null") | vehicleNum.equals("")) {
                new Alert(Alert.AlertType.WARNING, "Please Select Vehicle", ButtonType.CLOSE).show();

            } else if (index == -1) {
                park();
                vehicleInParkingList.add(new ParkingTM(vehicleNum, vehicleType, txtSlotNum.getText(), time.getTime()));
                new Alert(Alert.AlertType.CONFIRMATION, "Parking Completed", ButtonType.CLOSE).show();
                cmbVehicle.setValue("");
                txtVehicleType.setText("");
                cmbDriver.setValue("");
                txtTime.setText(" ");


            } else {
                new Alert(Alert.AlertType.WARNING, "This vehicle already parked", ButtonType.CLOSE).show();
            }
        }
    }


    public void OnDiliveryShiftOnAction(ActionEvent actionEvent) {
        leavePark();
        cmbVehicle.setValue("");
        txtVehicleType.setText("");
        cmbDriver.setValue("");

    }

 public void ManagementLoginOnAction(ActionEvent actionEvent) throws IOException {
   /*  Stage window=(Stage)root.getScene().getWindow();
     window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));*/
     FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/LoginForm.fxml"));
     Parent parent=loader.load();
     LoginFormController controller=loader.getController();
     Scene scene=new Scene(parent);
     Stage stage=new Stage();
    controller.closeStage(root);
     stage.setScene(scene);
     stage.setTitle("Login");
     stage.setResizable(false);
     stage.centerOnScreen();
     stage.show();

    }



    public void cmbVNumberOnAction(ActionEvent actionEvent) {
    }


    @Override
    public void park() {
        for (int i=0; i<driverShiftList.size(); i++){
            if (vehicleNum.equals(driverShiftList.get(i).getVehicleNumber())){

                driverShiftList.remove(i);
            }
        }
        switch(vehicleType){

            case "Bus" : Bus.addBusSlot(vehicleNum);
                txtSlotNum.setText(Bus.getBusSlot(vehicleNum));
                break;
            case "Van" :  Van.addVanSlot(vehicleNum);
                txtSlotNum.setText(Van.getVanSlot(vehicleNum));
                break;
            case "Cargo Lorry" : CargoLorry.addCargoLorrySlot(vehicleNum);
                txtSlotNum.setText(CargoLorry.getCargoLorrySlot(vehicleNum));

        }
        parkedList.add(vehicleNum);

    }







    @Override
    public void leavePark() {
        boolean b = false;
        for (int i = 0; i < driverShiftList.size(); i++) {
            if (driverName.equals(driverShiftList.get(i).getDriverName())) {
                b = true;
                new Alert(Alert.AlertType.WARNING, "Driver not found", ButtonType.CLOSE).show();
            }
        }
        if (b == false) {

            if (parkedList.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Park is Empty", ButtonType.CLOSE).show();


            } else {
                int index=-1;
                for (int i = 0; i < parkedList.size(); i++) {

                    if (vehicleNum.equals(parkedList.get(i))) {
                        index=i;
                    }
                }
                if(vehicleNum.equals("null") | vehicleNum.equals("")){
                    new Alert(Alert.AlertType.WARNING, "Please Select Vehicle", ButtonType.CLOSE).show();
                }else if (index==-1){
                    new Alert(Alert.AlertType.ERROR, "Vehicle not available", ButtonType.CLOSE).show();

                }else {
                    if (driverName.equals("null")|driverName.equals("")){
                        new Alert(Alert.AlertType.WARNING, "Please Select Driver", ButtonType.CLOSE).show();

                    }else {
                        parkedList.remove(index);

                        switch (vehicleType) {

                            case "Bus":
                                Bus.removeBus(vehicleNum);
                                break;

                            case "Van":
                                Van.removeVan(vehicleNum);
                                break;

                            case "Cargo Lorry":
                                CargoLorry.removeCargoLorry(vehicleNum);
                                break;

                        }

                        driverShiftList.add(new DriverShift(driverName ,vehicleNum));
                        vehicleOnDeliveryList.add(new OnDeliveryShiftTM(vehicleNum,vehicleType,driverName,time.getTime()));
                        new Alert(Alert.AlertType.CONFIRMATION, "Delivery completed", ButtonType.CLOSE).show();

                    }
                }
            }
        }
    }
}
