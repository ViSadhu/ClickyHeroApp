package com.example.clickyhero;

import java.io.Serializable;

public class Combo implements Serializable {

    private int comboID;
    private String comboName;
    private String sequence;
    private int comboSize;
    private int isCompleted;

    public int getComboSize() {
        return comboSize;
    }

    public void setComboSize(int comboSize) {
        this.comboSize = comboSize;
    }

    private int isCorrect;

    public int getComboID() {
        return comboID;
    }

    public void setComboID(int comboID) {
        this.comboID = comboID;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public int isCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }

    public int isCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
}
