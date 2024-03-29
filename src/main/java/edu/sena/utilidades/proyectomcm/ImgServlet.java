/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.utilidades.proyectomcm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 
 */
@WebServlet(name = "ImgServlet", urlPatterns = {"/ImgServlet/*"})
public class ImgServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ImgServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImgServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String archivoNombre = request.getPathInfo().substring(1);
        if (!archivoNombre.isEmpty()) {
            File carpeta = new File("C:\\mcm\\usuarios\\fotoperfil\\" + archivoNombre);
            response.setHeader("Content-Type", getServletContext().getMimeType(archivoNombre));
            response.setHeader("Content-Length", String.valueOf(carpeta.length()));
            response.setHeader("Content-Disposition", "inline; filename =\"" + archivoNombre + "\"");

            try {
                Files.copy(carpeta.toPath(), response.getOutputStream());
                processRequest(request, response);
            } catch (IOException | ServletException e) {
                System.out.println("ImgServlet.doGet() :: " + e.getMessage());
            }

        }

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