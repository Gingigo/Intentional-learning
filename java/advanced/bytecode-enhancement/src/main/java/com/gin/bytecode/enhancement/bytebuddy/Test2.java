package com.gin.bytecode.enhancement.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.function.Function;

public class Test2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<? extends java.util.function.Function> dynamicType = new ByteBuddy()
                .subclass(Function.class)
                .method(ElementMatchers.named("apply"))
                // 拦截
                .intercept(MethodDelegation.to(new GreetingInterceptor()))
                .make()
                .load(GreetingInterceptor.class.getClassLoader())
                .getLoaded();
        System.out.println(dynamicType.newInstance().apply("Byte Buddy"));
    }
}
