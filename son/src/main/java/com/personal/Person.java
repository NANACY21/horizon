package com.personal;

public class Person {
    private Axe axe;

    //人能用斧子
    public void useAxe() {
        axe.chop();
    }

    public void setAxe(Axe axe) {
        this.axe = axe;
    }
}
