package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyy HH:mm");
    Date date=new Date();

    public String getTime() {
        return formatter.format(date);
    }
}
