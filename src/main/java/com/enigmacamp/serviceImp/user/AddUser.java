package com.enigmacamp.serviceImp.user;

import com.enigmacamp.utility.Helper;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class AddUser {
    private static final Scanner sc = new Scanner(System.in);

    public static void forumAddUser() {
        String username, password;
        do {
            System.out.println("masukan username : ");
            username = sc.nextLine();
            username = username.trim();
            if (username.isBlank() || username.isEmpty()) {
                System.out.println("Username Tidak boleh kosong ! ");
            }
        } while (username.isBlank() || username.isEmpty());
        do {
            System.out.println("masukan password : ");
            password = sc.nextLine();
            password = password.trim();
            if (password.isBlank() || password.isEmpty()) {
                System.out.println("Password Tidak boleh kosong ! ");
            }
        } while (password.isBlank() || password.isEmpty());
        addUser(username, password);
    }


    public static void addUser(String username, String password) {
        EntityManager em = Helper.EM();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO m_user (user_name, password) VALUES (?, ?)")
                .setParameter(1, username)
                .setParameter(2, password)
                .executeUpdate();
        em.getTransaction().commit();
    }
}
