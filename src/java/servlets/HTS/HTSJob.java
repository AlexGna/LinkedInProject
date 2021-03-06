/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.HTS;

import dao.UserDAOImpl;
import dao.JobDAOImpl;
import dao.ProfessionalExperienceDAOImpl;
import dao.UserHasLanguageDAOImpl;
import java.text.DateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.Job;
import model.ProfessionalExperience;

/**
 *
 * @author alex
 */
@WebServlet(name = "HTSJob", urlPatterns = {"/job"})
public class HTSJob extends HttpServlet {

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

        try (PrintWriter out = response.getWriter()) {
            // add prefix
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");

            //***************************************************
            //---------------------------------------------------
            //-----------------------JOB------------------------
            //---------------------------------------------------
            UserDAOImpl udao = new UserDAOImpl();
            ProfessionalExperienceDAOImpl dao = new ProfessionalExperienceDAOImpl();

            JobDAOImpl jdao = new JobDAOImpl();

            User me = new User();
            me.setUserId(6);

            UserHasLanguageDAOImpl uhl = new UserHasLanguageDAOImpl();
            ProfessionalExperienceDAOImpl pe = new ProfessionalExperienceDAOImpl();
            ProfessionalExperience experience = new ProfessionalExperience();

            Integer jobId = 1;
            String dateStarted = "2010-10-10";
            String dateEnded = "2010-10-10";

            Job job = new Job();
            job.setJobId(jobId);

            experience.setUserId(me);
            experience.setJobId(job);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1;
            Date date2;
            try {
                date1 = dateFormat.parse(dateStarted);
                date2 = dateFormat.parse(dateEnded);
                experience.setDateStarted(date1);
                experience.setDateEnded(date2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            pe.create(experience);

            try {
                pe.create(experience);
                out.println("<p>Exp created (correct)</p>");
            } catch (Exception ex) {
                out.println("<p>Exp not created (error)</p>");
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
