package com.gin.bytecode.enhancement.instrument;

import com.gin.bytecode.enhancement.asm.Base;

import java.lang.instrument.Instrumentation;

public class TestAgent {
    public static void agentmain(String args, Instrumentation inst) {
        inst.addTransformer(new TestTransformer(), true);
        try{
            //重定义类并载入新的字节码
            inst.retransformClasses(Base.class);
            System.out.println("Agent Load Done.");
        }catch (Exception e){
            System.out.println("agent load failed!");
        }
    }
}
