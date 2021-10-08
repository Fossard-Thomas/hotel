package model.repositories;

import model.entites.User;
import wils.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO {

    public static ArrayList<User> getAllUser() throws SQLException {

        try {
            Connection conn = SQL.getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * from user");

            ResultSet result = statement.executeQuery();

            ArrayList<User> array = new ArrayList<User>();
            while (result.next()){
                /*
                System.out.println(result.getString("id_user"));
                System.out.println(result.getString("email"));
                System.out.println(result.getString("password"));
                 */

                array.add(new User(result.getInt("id_user"),
                                   result.getString("email"),
                                   result.getString("password")));

            }
            return array;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;

    }

    public static boolean login(String email, String password) throws SQLException, ClassNotFoundException {

        Connection conn = SQL.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) as count_user from user where email = '"+email+"' and password = '"+password+"'");
        ResultSet result = statement.executeQuery();

        System.out.println(result.getString("count_user"));
        return true;

        /*ArrayList<User> array = new ArrayList<User>();
        while (result.next()){
            array.add(new User(result.getInt("id_user"),
                                result.getString("email"),
                                result.getString("password")));
        }

        if (array.size() == 1){
            System.out.println("Vous êtes connecté !");
            return true;
        }else{
            System.out.println("Connexion refusée");
            return false;
        }*/

        /*
        int i;
        for (i=0; i< list.size(); i++){
            if (list.get(i).getEmail().equals(email) && list.get(i).getPassword().equals(password)){
                System.out.println("vous etes connecté");
                return true;
            }else{
                System.out.println("email ou mdp incorrect");
                return false;
            }
        }
        return false;
        */
    }

}
