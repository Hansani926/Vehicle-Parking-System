package model;

public class Van  extends Vehicle{
    public static String vanSlot[][];
    static {
        vanSlot=new String[6][2];
        vanSlot[0][0]="            1";
        vanSlot[1][0]="            2";
        vanSlot[2][0]="            3";
        vanSlot[3][0]="            4";
        vanSlot[4][0]="            12";
        vanSlot[5][0]="            13";

        for (int i=0;i<vanSlot.length;i++){
            vanSlot[i][1]="null";
        }
    }

    public static void addVanSlot(String vehicleNum) {
        int emptySlot = -1;
        for (int i = 0; i < vanSlot.length; i++) {
            if (vanSlot[i][1].equals("null")) {
                emptySlot = i;
                break;
            }
        }
        if (emptySlot == -1) {
            System.out.println("Van Slot is full..");
        } else {
            vanSlot[emptySlot][1] = vehicleNum;
        }


    }

    public static String getVanSlot(String vehicleNum) {
        int index=-1;
        String chooseVanSlot="  Park In Out Side";

        for (int i=0; i<vanSlot.length; i++){
            if (vehicleNum.equals(vanSlot[i][1])){
                index=i;
            }
        }
        if (index==-1){
            System.out.println("Van not found this slots");
        }else{
            chooseVanSlot=vanSlot[index][0];
        }
        return chooseVanSlot;

    }

    public static void removeVan(String vehicleNum) {
        for (int i = 0; i < vanSlot.length; i++) {
                if (vehicleNum.equals(vanSlot[i][1])) {
                    vanSlot[i][1] = "null";
                    break;
                }
            }
        }

    public Van(String vehicleNum, String vehicleType, String maxWeight, String numOfPassenger) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
        this.maxWeight = maxWeight;
        this.numOfPassenger = numOfPassenger;
    }

    @Override
    public void park() {

    }

    @Override
    public void leavePark() {

    }
}
