package com.sbt.lesson17;

/**
 * Created by Student on 05.09.2016.
 */
public class RealDocExecImpl implements ExecBehavior {
    @Override
    public void exec(Document document) {
        document.getAccountA().setSaldo(document.getAccountA().getSaldo() - document.getSum());
        document.getAccountB().setSaldo(document.getAccountB().getSaldo() + document.getSum());

        System.out.println("From accountA to accountB: " + document.getSum());
    }
}
