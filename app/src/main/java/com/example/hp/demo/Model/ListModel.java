package com.example.hp.demo.Model;



public class ListModel {

    public String question;
    public String selectedAnswer;
    public String actualAnswer;

    public ListModel(){

    }

    public ListModel(String qstn, String selectedANS, String actualANS)
    {
        question = qstn;
        selectedAnswer = selectedANS;
        actualAnswer = actualANS;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public String getActualAnswer() {
        return actualAnswer;
    }

    public void setActualAnswer(String actualAnswer) {
        this.actualAnswer = actualAnswer;
    }
}
