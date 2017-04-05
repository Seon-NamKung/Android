package com.example.mskir.fragmenthw;

/**
 * Created by mskir on 2017-04-05.
 */

public class Information {
    private String name;
    private String time;
    private int spagetti;
    private int pizza;
    private int membership; // 0: none, 1 : normal, 2: VIP

    public Information(String name,String time, int spagetti, int pizza, int membership){
        this.name = name;
        this.time = time;
        this.spagetti = spagetti;
        this.pizza = pizza;
        this.membership = membership;
    }

    String getName(){
        return this.name;
    }

    String getTime(){
        return this.time;
    }

    int getSpagetti(){
        return this.spagetti;
    }

    int getPizza(){
        return this.pizza;
    }

    int getMembership(){
        return this.membership;
    }


}
