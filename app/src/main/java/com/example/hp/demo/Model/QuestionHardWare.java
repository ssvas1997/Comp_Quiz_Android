package com.example.hp.demo.Model;

public class QuestionHardWare {

    private int ID2;
    private String QUESTION2;
    private String OPTA2;
    private String OPTB2;
    private String OPTC2;
    private String OPTD2;
    private String ANSWER2;
    private String CATEGORY2;

    public QuestionHardWare()
    {
        ID2 = 0;
        QUESTION2 = "";
        OPTA2 = "";
        OPTB2 = "";
        OPTC2 = "";
        OPTD2 = "";
        CATEGORY2="";
    }
    public QuestionHardWare(String qUESTION, String oPTA, String oPTB, String oPTC, String oPTD,
                            String aNSWER, String cATEGORY) {

        QUESTION2 = qUESTION;
        OPTA2 = oPTA;
        OPTB2 = oPTB;
        OPTC2 = oPTC;
        OPTD2 = oPTD;
        ANSWER2 = aNSWER;
        CATEGORY2=cATEGORY;
    }

    public int getID2() {
        return ID2;
    }

    public void setID2(int ID2) {
        this.ID2 = ID2;
    }

    public String getQUESTION2() {
        return QUESTION2;
    }

    public void setQUESTION2(String QUESTION2) {
        this.QUESTION2 = QUESTION2;
    }

    public String getOPTA2() {
        return OPTA2;
    }

    public void setOPTA2(String OPTA2) {
        this.OPTA2 = OPTA2;
    }

    public String getOPTB2() {
        return OPTB2;
    }

    public void setOPTB2(String OPTB2) {
        this.OPTB2 = OPTB2;
    }

    public String getOPTC2() {
        return OPTC2;
    }

    public void setOPTC2(String OPTC2) {
        this.OPTC2 = OPTC2;
    }

    public String getOPTD2() {
        return OPTD2;
    }

    public void setOPTD2(String OPTD2) {
        this.OPTD2 = OPTD2;
    }

    public String getANSWER2() {
        return ANSWER2;
    }

    public void setANSWER2(String ANSWER2) {
        this.ANSWER2 = ANSWER2;
    }

    public String getCATEGORY2() {
        return CATEGORY2;
    }

    public void setCATEGORY2(String CATEGORY2) {
        this.CATEGORY2 = CATEGORY2;
    }
}

