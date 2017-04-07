package com.example.mskir.fragmenttask;

/**
 * Created by mskir on 2017-04-06.
 */

public class Information {
    private String name;
    private String time;
    private int spagetti;
    private int pizza;
    private int membership; // 0: none, 1 : normal, 2: VIP
    private int status ; // 0 : none 1 : have

    final int costSpagetti = 10000;
    final int costPizza = 12000;

    public Information(String name,String time, int spagetti, int pizza, int membership){
        this.name = name;
        this.time = time;
        this.spagetti = spagetti;
        this.pizza = pizza;
        this.membership = membership;
        this.status = 0;
    }

    /*
        0 = 비어있음
        1 = 차있음
     */
    public void setStatus(int i){
        status = i;
    }

    public int getStatus(){
        return status;
    }

    public void setName(String name){
        this.name = name;
    }
    public   String getName(){
        return this.name;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return this.time;
    }

    public void setSpagetti(int spagetti){
        this.spagetti = spagetti;
    }

    public int getSpagetti(){
        return this.spagetti;
    }

    public void setPizza(int pizza){
        this.pizza = pizza;
    }

    public int getPizza(){
        return this.pizza;
    }

    public void setMembership(int membership){
        this.membership = membership;
    }

    public String getMembership(){
        if(membership == 0){
            return "No";
        }
        else if(membership == 1){
            return "Normal";
        }else{
            return "VIP";
        }

    }

    public int getCost(){
        if(membership == 0){
            return (costSpagetti * spagetti + costPizza * pizza);
        }
        else if(membership == 1){
            return (costSpagetti * spagetti + costPizza * pizza)*9/10;
        }else{
            return (costSpagetti * spagetti + costPizza * pizza)*7/10;
        }
    }

    public void clearAll(){
        name = "";
        time = "";
        spagetti = 0;
        pizza = 0;
        membership = 0;
    }
}
