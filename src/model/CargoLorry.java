package model;

public class CargoLorry extends Vehicle {
    public static String cargoLorrySlot[][];

    public CargoLorry(String vehicleNum, String vehicleType, String maxWeight, String numOfPassenger) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
        this.maxWeight = maxWeight;
        this.numOfPassenger = numOfPassenger;
    }

    static {
        cargoLorrySlot=new String[7][2];
        cargoLorrySlot[0][0]="            5";
        cargoLorrySlot[1][0]="            6";
        cargoLorrySlot[2][0]="            7";
        cargoLorrySlot[3][0]="            8";
        cargoLorrySlot[4][0]="            9";
        cargoLorrySlot[5][0]="            10";
        cargoLorrySlot[6][0]="            11";

        for (int i=0;i<cargoLorrySlot.length;i++){
            cargoLorrySlot[i][1]="null";
        }
    }

    public static void addCargoLorrySlot(String vehicleNum) {
        int emptySlot = -1;
        for (int i = 0; i < cargoLorrySlot.length; i++) {
            if (cargoLorrySlot[i][1].equals("null")) {
                emptySlot = i;
                break;
            }
        }
        if (emptySlot == -1) {
            System.out.println("Cargo lorry Slot is full..");
        } else {
            cargoLorrySlot[emptySlot][1] = vehicleNum;
        }
    }

    public static String getCargoLorrySlot(String vehicleNum) {
        int index=-1;
        String chooseCargoLorrySlot="  Park In Out Side";

        for (int i=0; i<cargoLorrySlot.length; i++){
            if (vehicleNum.equals(cargoLorrySlot[i][1])){
                index=i;
            }
        }
        if (index==-1){
            System.out.println("Cargo lorry not found this slots");
        }else{
            chooseCargoLorrySlot=cargoLorrySlot[index][0];
        }
        return chooseCargoLorrySlot;
    }

    public static void removeCargoLorry(String vehicleNum) {
        for (int i=0; i<cargoLorrySlot.length; i++){
            if (vehicleNum.equals(cargoLorrySlot[i][1])){
                cargoLorrySlot[i][1]="null";
                break;
            }
        }
    }


    @Override
    public void park() {

    }

    @Override
    public void leavePark() {

    }
}
