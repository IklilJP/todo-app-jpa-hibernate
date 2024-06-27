package com.enigmacamp.serviceImp.todo;

import com.enigmacamp.utility.Helper;
import jakarta.persistence.EntityManager;

import java.util.Scanner;


public class DeleteTodo {
    private static final Scanner scanner = new Scanner(System.in);

    public static void forumDelete() {
        String id;
        System.out.println("Masukan id yang ingin di hapus : ");
        id = scanner.nextLine();
        delete(Integer.parseInt(id));
    }

    public static void delete(int id) {
        EntityManager em = Helper.EM();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Todo t WHERE t.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
    }
}
