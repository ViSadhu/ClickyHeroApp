package com.example.clickyhero;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable {

    private int comboID;
    private ArrayList<Integer> sequenceImages;
    private String comboName;
    private int comboSize;
    private boolean isCompleted;
    private int isCorrect;

    public Combo(int comboID, String comboName, ArrayList<Integer> sequenceImages, int comboSize, boolean isCompleted, int isCorrect) {
        this.comboID = comboID;
        this.comboName = comboName;
        this.sequenceImages = sequenceImages;
        this.comboSize = comboSize;
        this.isCompleted = isCompleted;
        this.isCorrect = isCorrect;
    }

    public ArrayList<Integer> getSequenceImages() {
        return sequenceImages;
    }

    public void setSequenceImages(ArrayList<Integer> sequenceImages) {
        this.sequenceImages = sequenceImages;
    }

    public int getComboSize() {
        return comboSize;
    }

    public void setComboSize(int comboSize) {
        this.comboSize = comboSize;
    }

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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public int isCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
}
