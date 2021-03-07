/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAOS.PhoneDAO;
import DAOS.UserDAO;
import DTOS.User;
import Utils.Validator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author takah
 */
public class ControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String formView = "ListPhone.jsp";
        
        try (PrintWriter out = response.getWriter()) {
            String username = "";
            String action = request.getParameter("action");
            try {
                if (action.equals("login")) {
                    UserDAO userDAO = new UserDAO();
                    username = (String) request.getParameter("Username");
                    if (username == null) {
                        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                        rd.forward(request, response);
                    } else {
                        String password = (String) request.getParameter("Password");
                        User user = new User(username, password);

                        if (userDAO.login(user)) {
                            HttpSession session = request.getSession();
                            session.setAttribute("userName", username);
                            RequestDispatcher rd = request.getRequestDispatcher("/landingPage.jsp");
                            rd.forward(request, response);
                        } else {
                            request.setAttribute("loginAlert", "Wrong username or password");
                            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                            rd.forward(request, response);
                        }
                    } 
               } else if (action.equals("register")) {
                    String newUID = String.valueOf(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
                    String newUsername = (String) request.getParameter("username");
                    String newUserPassword = (String) request.getParameter("password");
                    String repeatPass = (String) request.getParameter("repeatPass");
                    UserDAO register = new UserDAO();
                    if (Validator.checkUsername(newUsername) && Validator.checkPassword(newUserPassword) && newUserPassword.equals(repeatPass)) {
                        User newUser = new User(newUID, newUsername, newUserPassword);
                        if (register.addUser(newUser)) {
                            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                            rd.forward(request, response);
                        } else {
                            request.setAttribute("message", "Cannot register your account. Try again");
                            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                            rd.forward(request, response);
                        }
                    } else {
                        if (!Validator.checkUsername(newUsername)) {
                            if (register.searchUser(newUsername)) {
                                request.setAttribute("usernameAlert", "Username is already exist");
                            } else {
                                request.setAttribute("usernameAlert", "Username cannot be empty");
                            }
                        }
                        if (!Validator.checkPassword(newUserPassword)) {
                            request.setAttribute("passwordAlert", "Password cannot be empty");
                        }
                        if (!newUserPassword.equals(repeatPass)) {
                            request.setAttribute("repeatPassAlert", "Re-password does not match");
                        }
                        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                        rd.forward(request, response);
                    }
                } else if (action.equals("logout")) {
                    HttpSession session = request.getSession();
                    session.removeAttribute("userName");
//                    session.invalidate();
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
                
                else if(action.equals("listProduct")){
                    PhoneDAO dao = new PhoneDAO();
                    request.setAttribute("Phones", dao.getAllPhone());
                    RequestDispatcher rd = request.getRequestDispatcher(formView);
                    rd.forward(request, response);                 
                }
                
                else if(action.equals("delete")){
                    PhoneDAO dao = new PhoneDAO();
                    String id = request.getParameter("pid");
                    
                    dao.deletePhone(id);
                    
                    request.setAttribute("Phones", dao.getAllPhone());
                    RequestDispatcher rd = request.getRequestDispatcher(formView);
                    rd.forward(request, response);  
                }
                
                else if(action.equals("update")){
                    
                }
                
                else if(action.equals("add")){
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
