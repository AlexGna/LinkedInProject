/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.AdministratorDAOImpl;
import dao.UserDAOImpl;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import parsers.UserAdapter;

/**
 *
 * @author alex
 */
@WebServlet(name = "MainServlet2", urlPatterns = {"/t"})
public class MainServlet2 extends HttpServlet {

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

        Map<String, String[]> params = request.getParameterMap();

        try {
            if (!params.isEmpty()) {
                if (!params.containsKey("confirm_password")) {
                    /* ***************** LOGIN **************** */
                    String email = params.get("email")[0];
                    String password = params.get("password")[0];

                    UserDAOImpl dao = new UserDAOImpl();
                    AdministratorDAOImpl dao2 = new AdministratorDAOImpl();
                            
                    User user = dao.find(email);
  
                    
                     if (user.getPassword().equals(password)) {


                        HttpSession newsession = request.getSession(true);
                        newsession.setAttribute("me", user);
                        
                        if(user.getUserId()==2){
                            response.sendRedirect(String.format("%s%s", request.getContextPath(), "/admin"));
                            return;
                            
                        }                        

                           response.sendRedirect(String.format("%s%s", request.getContextPath(), "/xronologio"));
                           return;

                    }
                    
                    
                    
                } else {
                    /* ***************** REGISTER **************** */
                    String password = params.get("password")[0];
                    String confirm_password = params.get("confirm_password")[0];

                    if (password.equals(confirm_password)) {
                        UserDAOImpl dao = new UserDAOImpl();
                        User user = UserAdapter.mapToUser(params);
                        
                        
                        try {
                            dao.create(user);
                        } catch (Exception ex) {
                             request.setAttribute("result", "The email you have entered already exists. Please enter another email.");
                             getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                             return;
                             
                        }                        

                        HttpSession newsession = request.getSession(true);
                        newsession.setAttribute("me", user);

                        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/xronologio"));

                        return;
                    }
                }
            }
        } catch (Exception ex) {
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue()[0];

                request.setAttribute(key, value);
            }

        }

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
