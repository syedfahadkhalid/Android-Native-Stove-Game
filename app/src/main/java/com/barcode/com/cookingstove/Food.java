package com.barcode.com.cookingstove;

/**
 * Created by fahad on 4/23/2017.
 */

public class Food {
    private int id;
    private int timeOfCook;
    private String nameOfCook;
    private int tempOfCook;
    public Food()
    {
    }
    public Food(int time,String name,int temp)
    {
        this.timeOfCook=time;
        this.nameOfCook=name;
        this.tempOfCook=temp;
    }
    public void setTime(int time) {
        this.timeOfCook = time;
    }
    public void setName(String name) {
        this.nameOfCook = name;
    }

    public void setTemp(int temp) {
        this.tempOfCook = temp;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public int getTime() {
        return timeOfCook;
    }
    public String getName() {
        return nameOfCook;
    }
    public int getTemp() {
        return tempOfCook;
    }
}
