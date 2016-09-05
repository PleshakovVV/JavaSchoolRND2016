package com.sbt.lesson17;

/**
 * Created by Student on 05.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Document document = new Document(new InfoDocExecImpl());

        Account accountA = new Account();
        accountA.setSaldo(100L);
        Account accountB = new Account();
        accountB.setSaldo(100L);

        DocumentExecutor documentExecutor = new DocumentExecutor();

        document.setAccountA(accountA);
        document.setAccountB(accountB);

        document.setSum(10L);

        documentExecutor.exec(document);
    }
}
