package com.enigmacamp;

import com.enigmacamp.menu.MenuTodo;
import com.enigmacamp.menu.MenuUser;


public class Main {
    public static void main(String[] args) {
        MenuTodo menuTodo = new MenuTodo();
        MenuUser menuUser = new MenuUser();
        boolean check = menuUser.displayMenu();

        if (check) {

            menuTodo.displayMenu();
        } else {
            menuUser.displayMenu();
        }


    }
}