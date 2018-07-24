package com.example.hp.demo.Model;

public class UserModel {
    private String displayName;
    private String email;
    private long createdAt;
    public int compMarksB=0;
    public int compMarksI=0;
    public int compMarksE=0;
    public int hardwareMarksB=0;
    public int hardwareMarksI=0;
    public int hardwareMarksE=0;
    public int osMarksB=0;
    public int osMarksI=0;
    public int osMarksE=0;
    public int finalMarks=0;

    private String mRecipientId;

    public UserModel() {
    }

    public UserModel(String displayName, String email,long createdAt,int compMarksB,int compMarksI,int compMarksE,int hardwareMarksB,int hardwareMarksI,int hardwareMarksE,int osMarksB,int osMarksI,int osMarksE,int finalMarks) {
        this.displayName = displayName;
        this.email = email;
        this.createdAt = createdAt;
        this.compMarksB=compMarksB;
        this.compMarksI=compMarksI;
        this.compMarksE=compMarksE;
        this.hardwareMarksB=hardwareMarksB;
        this.hardwareMarksI=hardwareMarksI;
        this.hardwareMarksE=hardwareMarksE;
        this.osMarksB=osMarksB;
        this.osMarksI=osMarksI;
        this.osMarksE=osMarksE;
        this.finalMarks=finalMarks;
    }

    public int getCompMarksB() {
        return compMarksB;
    }

    public void setCompMarksB(int compMarksB) {
        this.compMarksB = compMarksB;
    }

    public int getCompMarksI() {
        return compMarksI;
    }

    public void setCompMarksI(int compMarksI) {
        this.compMarksI = compMarksI;
    }

    public int getCompMarksE() {
        return compMarksE;
    }

    public void setCompMarksE(int compMarksE) {
        this.compMarksE = compMarksE;
    }

    public int getHardwareMarksB() {
        return hardwareMarksB;
    }

    public void setHardwareMarksB(int hardwareMarksB) {
        this.hardwareMarksB = hardwareMarksB;
    }

    public int getHardwareMarksI() {
        return hardwareMarksI;
    }

    public void setHardwareMarksI(int hardwareMarksI) {
        this.hardwareMarksI = hardwareMarksI;
    }

    public int getHardwareMarksE() {
        return hardwareMarksE;
    }

    public void setHardwareMarksE(int hardwareMarksE) {
        this.hardwareMarksE = hardwareMarksE;
    }

    public int getOsMarksB() {
        return osMarksB;
    }

    public void setOsMarksB(int osMarksB) {
        this.osMarksB = osMarksB;
    }

    public int getOsMarksI() {
        return osMarksI;
    }

    public void setOsMarksI(int osMarksI) {
        this.osMarksI = osMarksI;
    }

    public int getOsMarksE() {
        return osMarksE;
    }

    public void setOsMarksE(int osMarksE) {
        this.osMarksE = osMarksE;
    }

    public int getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(int finalMarks) {
        this.finalMarks = finalMarks;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    private String getUserEmail() {
        //Log.e("user email  ", userEmail);
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRecipientId() {
        return mRecipientId;
    }

    public void setRecipientId(String recipientId) {
        this.mRecipientId = recipientId;
    }
}



