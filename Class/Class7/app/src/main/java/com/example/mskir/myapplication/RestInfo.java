package com.example.mskir.myapplication;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mskir on 2017-04-13.
 */

public class RestInfo {
    private String name;
    private String tel;
    private int imgno = 0;

    public RestInfo(String name, String tel, int imgno){
        this.name = name;
        this.tel = tel;
        this.imgno = imgno;
    }

    public void setData(String name, String tel, int imgno) {
        this.name = name;
        this.tel = tel;
        this.imgno = imgno;
    }
    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public int getImgno() {
        return imgno;
    }

}
