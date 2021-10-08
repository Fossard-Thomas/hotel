import model.entites.User;
import model.repositories.UserDAO;
import wils.SQL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class run {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        System.out.println("---------MENU---------");
        System.out.println("1. Se connecter");
        System.out.println("2. Quitter");

        Scanner scanChoix = new Scanner(System.in);
        int choix = scanChoix.nextInt();
        switch (choix){
            case 1: //Se connecter
                ArrayList<User> userList = UserDAO.getAllUser();

                System.out.println("Votre email");
                Scanner scEmail = new Scanner(System.in);
                String email = scEmail.nextLine();

                System.out.println("Votre mot de passe");
                Scanner scMdp = new Scanner(System.in);
                String mdp = scEmail.nextLine();

                UserDAO.login(email, mdp);
        }


    }

}
