package com.gingo.spring.state.machine.demo01;

import com.gingo.spring.state.machine.demo01.state.Events;
import com.gingo.spring.state.machine.demo01.state.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private StateMachine<States, Events> stateMachine;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
    }
}