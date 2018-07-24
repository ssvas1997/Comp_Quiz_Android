package com.example.hp.demo.Model;

public class QuestionCompFunda {
    private int ID1;
    private String QUESTION1;
    private String OPTA1;
    private String OPTB1;
    private String OPTC1;
    private String OPTD1;
    private String ANSWER1;
    private String CATEGORY1;


    public QuestionCompFunda() {
        ID1 = 0;
        QUESTION1 = "";
        OPTA1 = "";
        OPTB1 = "";
        OPTC1 = "";
        OPTD1 = "";
        CATEGORY1="";
    }

    public QuestionCompFunda(String qUESTION1, String oPTA1, String oPTB1, String oPTC1, String oPTD1,
                             String aNSWER1,String cATEGORY1) {

        QUESTION1 = qUESTION1;
        OPTA1 = oPTA1;
        OPTB1 = oPTB1;
        OPTC1 = oPTC1;
        OPTD1 = oPTD1;
        ANSWER1 = aNSWER1;
        CATEGORY1=cATEGORY1;
    }

    public int getID1() {
        return ID1;
    }

    public void setID1(int ID1) {
        this.ID1 = ID1;
    }

    public String getQUESTION1() {
        return QUESTION1;
    }

    public void setQUESTION1(String QUESTION1) {
        this.QUESTION1 = QUESTION1;
    }

    public String getOPTA1() {
        return OPTA1;
    }

    public void setOPTA1(String OPTA1) {
        this.OPTA1 = OPTA1;
    }

    public String getOPTB1() {
        return OPTB1;
    }

    public void setOPTB1(String OPTB1) {
        this.OPTB1 = OPTB1;
    }

    public String getOPTC1() {
        return OPTC1;
    }

    public void setOPTC1(String OPTC1) {
        this.OPTC1 = OPTC1;
    }

    public String getOPTD1() {
        return OPTD1;
    }

    public void setOPTD1(String OPTD1) {
        this.OPTD1 = OPTD1;
    }

    public String getANSWER1() {
        return ANSWER1;
    }

    public void setANSWER1(String ANSWER1) {
        this.ANSWER1 = ANSWER1;
    }

    public String getCATEGORY1() {
        return CATEGORY1;
    }

    public void setCATEGORY1(String CATEGORY1) {
        this.CATEGORY1 = CATEGORY1;
    }
}
