package com.example.interactivestory.model;

public class page {
    private int imageId ;
    private int textId ;
    private choice choice1 ;
    private choice choice2 ;
    private boolean isFinalpage = false ;

    public page(int imageId, int textId) {
        this.imageId = imageId;
        this.textId = textId;
        this.isFinalpage = true ;
    }

    public page(int imageId, int textId, choice choice1, choice choice2) {
        this.imageId = imageId;
        this.textId = textId;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public boolean isFinalpage() {
        return isFinalpage;
    }

    public void setFinalpage(boolean finalpage) {
        isFinalpage = finalpage;
    }

    public choice getChoice2() {
        return choice2;
    }

    public void setChoice2(choice choice2) {
        this.choice2 = choice2;
    }

    public choice getChoice1() {
        return choice1;
    }

    public void setChoice1(choice choice1) {
        this.choice1 = choice1;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
