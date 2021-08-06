package com.gin.bytecode.enhancement.javassist;

import com.gin.bytecode.enhancement.asm.Base;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class JavassistTest {
    public static void main(String[] args) throws Exception {
        Base b=new Base();
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.gin.bytecode.enhancement.asm.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{System.out.println(\"start\");}");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        Base h = (Base) c.newInstance();
        h.process();
    }
}
