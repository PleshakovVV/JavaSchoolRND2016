package com.sbt.lesson17;

/**
 * Created by Student on 05.09.2016.
 */
public class DocumentExecutor {
    public void exec(Document document) {
        document.getExecBehavior().exec(document);
    }
}

