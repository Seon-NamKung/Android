package com.example.mskir.class6;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mskir on 2017-04-06.
 */

public class Student implements Parcelable{
    private String name = "";
    private String hakno = "";
    private int age = 0;
    private int isman = 1;

    public Student(String name, String hakno,int age,int isman){
        this.name = name;
        this.hakno = hakno;
        this.age = age;
        this.isman = isman;
    }

    protected Student(Parcel in) {
        name = in.readString();
        hakno = in.readString();
        age = in.readInt();
        isman = in.readInt();
    }

    @Override
    public String toString() {
        String str = name + ":" + hakno + ":" + age+ ":"+isman;
        return str;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public void setStudent(String name, String hakno, int age,int isman){
        this.name = name;
        this.hakno = hakno;
        this.age = age;
        this.isman = isman;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(hakno);
        dest.writeInt(age);
        dest.writeInt(isman);
    }
}
