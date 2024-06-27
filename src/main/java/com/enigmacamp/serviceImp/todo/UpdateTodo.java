package com.enigmacamp.serviceImp.todo;

import com.enigmacamp.utility.Helper;
import jakarta.persistence.EntityManager;

import java.util.Date;
import java.util.Scanner;

public class UpdateTodo {

    private static final Scanner scanner = new Scanner(System.in);

    public static void forumedit() {
        String id, todo_name, priority, descripsion, is_active;
        System.out.println("Masukan id yang ingin di edit : ");
        id = scanner.nextLine();

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

        edit(Integer.parseInt(id), todo_name, priority, descripsion, is_active);

    }


    public static void edit(int id, String todoName, String priority, String description, String isActive) {
        EntityManager em = Helper.EM();
        em.getTransaction().begin();
        em.createQuery("UPDATE Todo t SET t.todoName = :todoName, t.priority = :priority, t.description = :description, t.isActive = :isActive , t.editeDate = :editeDate WHERE t.id = :id")
                .setParameter("todoName", todoName)
                .setParameter("priority", priority)
                .setParameter("description", description)
                .setParameter("isActive", isActive)
                .setParameter("editeDate", new Date())
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();

    }
}
