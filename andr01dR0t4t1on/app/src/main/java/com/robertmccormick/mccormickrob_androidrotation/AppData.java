package com.robertmccormick.mccormickrob_androidrotation;

import java.util.ArrayList;

public class AppData {

     static ArrayList<String> list = new ArrayList<>();

    public static ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}
