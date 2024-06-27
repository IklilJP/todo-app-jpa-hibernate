package com.enigmacamp.serviceImp.user;

import com.enigmacamp.entity.User;
import com.enigmacamp.utility.Helper;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Scanner;

public class CheckUser {
   private static final Scanner Sc = new Scanner(System.in);

    public static boolean forumlogin() {
        System.out.println("-".repeat(50));
        System.out.println("Selamat datang di Login ");
        System.out.println("Tolong masukan username dan password");
        System.out.println("-".repeat(50));
        System.out.println("Username : ");
        String username = Sc.nextLine();
        System.out.println("Password : ");
        String password = Sc.nextLine();
        boolean check = checkUser(username, password);
        if (check) {
            System.out.println("Login Berhasil");
            return check;
        } else {
            System.out.println("Login gagal");
            return check;
        }

    }

    public static boolean checkUser(String username, String password) {
        TypedQuery<User> query = Helper.EM().createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> users = query.getResultList();

        return !users.isEmpty();
    }


}
