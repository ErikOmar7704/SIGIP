/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dats.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.dats.modelo.daos.CuentasDao;
import mx.com.dats.modelo.pojos.Cuenta;

/**
 *
 * @author Erick Omar G Flores
 */
@WebServlet(value = "/security")
public class CtrlCuentas extends HttpServlet {
    String urlB="localhost:8090";
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
        CuentasDao daocuenta = new CuentasDao();
        List<Cuenta> cuentas = daocuenta.getTodasCuentas();
        System.out.println("Cuentas: " + cuentas.size());
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CtrlCuentas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("CUENTAS");

            for (Cuenta cuenta : cuentas) {
                out.println("<p>" + cuenta.toString() + "</p>");
            }
            out.println("<h1>Servlet CtrlCuentas at " + request.getContextPath() + "</h1>");
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
        String accion = "";
        if (request.getParameter("accion") != null) {
            accion = request.getParameter("accion").toString();
        }
        switch (accion) {
            case "cerrar":
                cerrarSession(request,response);
                break;
            case "seleccionar":
                goToCrudUser(request,response);
                break;
            case "inicio":
                goToAdmin(request,response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
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
        this.urlB=urlB+request.getContextPath();
        String accion = "";
        if (request.getParameter("accion") != null) {
            accion = request.getParameter("accion").toString();
        }
        switch (accion) {
            case "Entrar":
                validaUsuario(request, response);
                break;
            default:
                paginaError(request, response, "Accion no identificada");
        }
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

    public void validaUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        CuentasDao daoCuenta = new CuentasDao();
        String usuario = "", pass = "";
        if (req.getParameter("usuario") != null) {
            usuario = req.getParameter("usuario");
        }
        if (req.getParameter("pass") != null) {
            pass = req.getParameter("pass");
        }
        Cuenta cuenta = daoCuenta.getCuenta(usuario, pass);
        if (cuenta != null) {
            req.getSession().setAttribute("cuentaActual", cuenta);
            switch (cuenta.getTipo()) {
                case 1:
                    goToAdmin(req, res);
                    //res.sendRedirect(req.getContextPath() + "/admsis/" );
                    break;
                case 2:
                    res.sendRedirect(req.getContextPath() + "/validapub/" );
                    break;
                case 3:
                    res.sendRedirect(req.getContextPath() + "/editpubs/" );
                    break;
                case 4:
                    res.sendRedirect(req.getContextPath() + "/validapub/" );
                    break;
                default:
                    res.sendRedirect(req.getContextPath());
            }
        } else {
            paginaError(req, res, "Credenciales incorrectas, verifique sus datos");
        }

    }

    public void cerrarSession(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.getSession().removeAttribute("cuentaActual");
        req.getSession().invalidate();
        res.sendRedirect(req.getContextPath());
    }
    public void goToAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        CuentasDao daoCuenta= new CuentasDao();
        List<Cuenta> lstAllUsers;
        lstAllUsers=daoCuenta.getTodasCuentas();
        req.setAttribute("lstAllUsers", lstAllUsers);
        String mensaje=daoCuenta.getMensaje();
        req.setAttribute("mensaje", mensaje);
        req.getRequestDispatcher("/admsis/index.jsp").forward(req, res);
    }
    
    public void goToCrudUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id=0;
        if(req.getParameter("id")!=null){
            try{
                id=Integer.parseInt(req.getParameter("id"));
            }catch (Exception e){}
        }
        CuentasDao daoCuenta= new CuentasDao();
        List<Cuenta> lstAllUsers;
        lstAllUsers=daoCuenta.getTodasCuentas();
        req.setAttribute("lstAllUsers", lstAllUsers);
        Cuenta cnta=daoCuenta.getCuenta(id);
        if(cnta!=null){
            req.setAttribute("cuentaActual", cnta);
        }
        String mensaje=daoCuenta.getMensaje();
        req.setAttribute("mensaje", mensaje);
        req.getRequestDispatcher("/admsis/crudusuarios.jsp").forward(req, res);
    }
    
    
    public void paginaError(HttpServletRequest req, HttpServletResponse res, String mensaje) throws IOException {
        res.sendRedirect(req.getContextPath() + "/error.jsp?mensaje=" + mensaje);
    }

}
