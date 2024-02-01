package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean(name = "toDo")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgress")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "done")
    public TaskList getDoneList() {
        return new TaskList();
    }

    @Bean
    public Board board() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }
}
