package com.cp;

public class PCData {

    private int intData;

    public int getIntData() {
        return intData;
    }

    public void setIntData(int intData) {
        this.intData = intData;
    }

    public PCData(int intData) {
        this.intData = intData;
    }

    public PCData(String intData) {
        this.intData = Integer.valueOf(intData);
    }
}
