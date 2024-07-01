package com.agent;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String arguments, Instrumentation instrumentation) {
        instrumentation.addTransformer(new MyTransformer());

    }
}
