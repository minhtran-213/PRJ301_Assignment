/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAOS.UserDAO;

/**
 *
 * @author ihtng
 */
public class Validator {
    public static boolean checkUsername(String username) {
        UserDAO checker = new UserDAO();
        if (username.length() < 1 || checker.searchUser(username)) {
            return false;
        }
        return true;
    }
    
    public static boolean checkPassword(String password) {
        return password.length() > 1;
    }
}
