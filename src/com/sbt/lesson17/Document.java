package com.sbt.lesson17;

/**
 * Created by Student on 05.09.2016.
 */
public class Document {
    private Client clientA;
    private Account accountA;

    private Client clientB;
    private Account accountB;

    private Long sum;

    private String user;

    private ExecBehavior execBehavior;

    public Document(ExecBehavior execBehavior) {
        this.execBehavior = execBehavior;
    }

    public Client getClientA() {
        return clientA;
    }

    public void setClientA(Client clientA) {
        this.clientA = clientA;
    }

    public Account getAccountA() {
        return accountA;
    }

    public void setAccountA(Account accountA) {
        this.accountA = accountA;
    }

    public Client getClientB() {
        return clientB;
    }

    public void setClientB(Client clientB) {
        this.clientB = clientB;
    }

    public Account getAccountB() {
        return accountB;
    }

    public void setAccountB(Account accountB) {
        this.accountB = accountB;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public ExecBehavior getExecBehavior() {
        return execBehavior;
    }

    public void setExecBehavior(ExecBehavior execBehavior) {
        this.execBehavior = execBehavior;
    }

    public void print() {
        System.out.println("Sum is:" + sum);
    }

    public void printUserInfo() {
        System.out.println("DocumentUser: " + user);
    }

    public void saveToDB() {
        System.out.println("Save document in DataBase...");
    }
}
