package com.enigmacamp.menu;

import com.enigmacamp.serviceImp.todo.AddTodo;
import com.enigmacamp.serviceImp.todo.DeleteTodo;
import com.enigmacamp.serviceImp.todo.ShowTodo;
import com.enigmacamp.serviceImp.todo.UpdateTodo;

import java.util.Scanner;

public class MenuTodo {
    private final Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("-".repeat(50));
        System.out.println("Selamat Datang di menu ToDo App");
        System.out.println("-".repeat(50));
        System.out.println("1. Add Task");
        System.out.println("2. View Task");
        System.out.println("3. Edit Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.println("-".repeat(50));
        System.out.println("masukan pilihan : ");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                System.out.println("-".repeat(50));
                System.out.println("Tambah Task");
                System.out.println("-".repeat(50));
                AddTodo.forumAdd();
                displayMenu();
            case "2":
                System.out.println("-".repeat(50));
                System.out.println("Tampilkan Task");
                System.out.println("-".repeat(50));
                ShowTodo.show();
                displayMenu();
            case "3":
                System.out.println("-".repeat(50));
                System.out.println("Edit Task");
                System.out.println("-".repeat(50));
                UpdateTodo.forumedit();
                displayMenu();
            case "4":
                System.out.println("-".repeat(50));
                System.out.println("Delete Task");
                System.out.println("-".repeat(50));
                DeleteTodo.forumDelete();
                displayMenu();
            case "5":
                System.out.println("Keluar");
                break;
            default:
                System.out.println("Invalid choice");
                displayMenu();
        }

    }
}


