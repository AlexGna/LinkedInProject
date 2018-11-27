package servlets.navigation;

import dao.AdDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ad;
import model.User;

/**
 *
 * @author alex
 */
@WebServlet(name = "ExamineAdsServlet", urlPatterns = {"/examineads"})
public class ExamineAdsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        User me = (User) request.getSession(false).getAttribute("me");

        AdDAOImpl adao = new AdDAOImpl();
        
        List<Ad> adlist = adao.list();
        List<Ad> myadlist = new ArrayList<>();


        if (!(adlist == null)) {
                for (Ad ad : adlist) {
                    if ((ad.getUserId().getUserId().equals(me.getUserId()))) {
                        myadlist.add(ad);
                    }
                }
        }
       
        
        request.getSession(false).setAttribute("myadlist", myadlist);
        request.setAttribute("myadlist", myadlist); 

        
        String nextJSP = "/WEB-INF/complete/examineads.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
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