package com.enigmacamp.serviceImp.todo;


import com.enigmacamp.utility.Helper;
import jakarta.persistence.EntityManager;

import java.util.Scanner;


public class AddTodo {

  private static final Scanner scanner = new Scanner(System.in);

    public static void forumAdd() {
        String todo_name, priority, descripsion, is_active;

        do {
            System.out.println("masukan todo name : ");
            todo_name = scanner.nextLine();
            todo_name = todo_name.trim();
            if (todo_name.isBlank() || todo_name.isEmpty()) {
                System.out.println("Todo Name Tidak boleh kosong ! ");
            }
        } while (todo_name.isBlank() || todo_name.isEmpty());

        do {
            System.out.println("priority (high/medium/low)");
            System.out.println("masukan priority : ");
            priority = scanner.nextLine();
            priority = priority.toLowerCase();
            if (!priority.equals("high") && !priority.equals("medium") && !priority.equals("low")) {
                System.out.println("Priority Tidak Valid");
            }
        } while (!priority.equals("high") && !priority.equals("medium") && !priority.equals("low"));

        System.out.println("masukan descripsion : ");
        descripsion = scanner.nextLine();
        descripsion = descripsion.trim();

        do {
            System.out.println("apakah aktif (y/n) : ");
            is_active = scanner.nextLine();
            if (is_active.equals("y")) {
                is_active = "active";
            } else if (is_active.equals("n")) {
                is_active = "inactive";
            }
            if (!is_active.equals("active") && !is_active.equals("inactive")) {
                System.out.println("Status Tidak Valid");
            }
        } while (!is_active.equals("active") && !is_active.equals("inactive"));
        addTodo(todo_name, priority, descripsion, is_active);
    }


    public static void addTodo(String todoName, String priority, String description, String isActive) {
        EntityManager entityManager = Helper.EM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("INSERT INTO todo (todo_name, priority, descripsion, is_active, create_date) VALUES (?, ?, ?, ?, NOW())")
                .setParameter(1, todoName)
                .setParameter(2, priority)
                .setParameter(3, description)
                .setParameter(4, isActive)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
