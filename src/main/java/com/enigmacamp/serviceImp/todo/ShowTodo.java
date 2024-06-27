package com.enigmacamp.serviceImp.todo;

import com.enigmacamp.entity.Todo;
import com.enigmacamp.utility.Helper;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ShowTodo {

    public static void show() {
        int i = 1;
        TypedQuery<Todo> query = Helper.EM().createQuery("SELECT t FROM Todo t", Todo.class);
        System.out.println("todo list");
        List<Todo> todos = query.getResultList();
        for (Todo todo : todos) {
            System.out.println("-".repeat(50));
            System.out.println("NO : " + i);
            System.out.println("ID : " + todo.getId());
            System.out.println("Todo Name : " + todo.getTodoName());
            System.out.println("Priority : " + todo.getPriority());
            System.out.println("Description : " + todo.getDescription());
            System.out.println("Is Active : " + todo.getIsActive());
            System.out.println("-".repeat(50));
            i++;
        }

    }
}
