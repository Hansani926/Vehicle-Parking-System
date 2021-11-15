package model;

public class Bus extends Vehicle {

    public static String busSlot[][];
    static {
        busSlot = new String[1][2];
        busSlot[0][0] = "            14";
        for (int i = 0; i < busSlot.length; i++) {
            busSlot[i][1] = "null";
        }
    }
    public Bus(String vehicleNum, String vehicleType, String maxWeight, String numOfPassenger) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
        this.maxWeight = maxWeight;
        this.numOfPassenger = numOfPassenger;
    }

    public static void addBusSlot(String vehicleNum) {
        int emptySlot = -1;
        for (int i = 0; i < busSlot.length; i++) {
            if (busSlot[i][1].equals("null")) {
                emptySlot = i;
                break;
            }
        }
        if (emptySlot == -1) {
            System.out.println("Bus Slot is full..");
        } else {
            busSlot[emptySlot][1] = vehicleNum;
        }
    }

    public static String getBusSlot(String vehicleNum) {
        int index=-1;
        String chooseBusSlot="  Park In Out Side";

        for (int i=0; i<busSlot.length; i++){
            if (vehicleNum.equals(busSlot[i][1])){
                index=i;
            }
        }
        if (index==-1){
            System.out.println("Bus not found this slots");
        }else{
            chooseBusSlot=busSlot[index][0];
        }
        return chooseBusSlot;
    }

    public static void removeBus(String vehicleNum) {
        for (int i=0; i<busSlot.length; i++){
            if (vehicleNum.equals(busSlot[i][1])){
                busSlot[i][1]="null";
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
