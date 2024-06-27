package com.enigmacamp.menu;

import com.enigmacamp.serviceImp.user.AddUser;
import com.enigmacamp.serviceImp.user.CheckUser;

import java.util.Scanner;

public class MenuUser {
    private final Scanner sc = new Scanner(System.in);

    public boolean displayMenu() {
        boolean check;
        System.out.println("1. Daftar");
        System.out.println("2. Login");
        System.out.println("3. Keluar");
        check = menuUser();
        return check;
    }

    public boolean menuUser() {
        String menu;
        boolean check = false;
        do {
            System.out.println("Pilih menu : ");
            menu = sc.nextLine();

            switch (menu) {
                case "1":
                    System.out.println("Daftar");
                    AddUser.forumAddUser();
                    break;
                case "2":
                    System.out.println("Login");
                    check=CheckUser.forumlogin();
                    break;
                case "3":
                    System.out.println("Keluar");
                    return check;
                default:
                    System.out.println("pilihan tidak tersedia tolong pilih kembali ");
            }
        } while (!menu.equals("3") && !check);
        return check;
    }
}
