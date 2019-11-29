/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dats.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.dats.modelo.daos.AreaDao;
import mx.com.dats.modelo.daos.CuentasDao;
import mx.com.dats.modelo.pojos.Cuenta;
import mx.com.dats.modelo.pojos.Area;

/**
 *
 *
 */
@WebServlet(value = "/security")
public class CtrlCuentas extends HttpServlet {

    String urlB = "localhost:8090";

    //<editor-fold defaultstate="collapsed" desc="processRequest y getServletInfo">
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="doGET.">
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
        String accion = "",pj="";
        if (request.getParameter("accion") != null) {
            accion = request.getParameter("accion").toString();
        }
        if (request.getParameter("pj") != null) {
            pj = request.getParameter("pj").toString();
        }
        switch (accion) {
            case "cerrar":
                cerrarSession(request, response);
                break;
            case "seleccionar":
                if(pj.equals("cuenta"))goToCrudUser(request, response);
                if(pj.equals("area"))goToCrudArea(request, response);
                break;
            case "inicio":
                goToAdmin(request, response);
                break;
            case "nueva":
                if(pj.equals("cuenta"))cargaCrudUsuarios(request, response);
                if(pj.equals("area"))cargaCrudAreas(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
        processRequest(request, response);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="doPOST.">
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
        this.urlB = urlB + request.getContextPath();
        String accion = "",pj="";
        if (request.getParameter("accion") != null) {
            accion = request.getParameter("accion").toString();
        }
        if (request.getParameter("pj") != null) {
            pj = request.getParameter("pj").toString();
        }
        switch (accion) {
            case "Entrar":
                validaUsuario(request, response);
                break;
            case "Agregar":
                if(pj.equals("cuenta"))agregaCuenta(request, response);
                if(pj.equals("area"))agregaArea(request, response);
                break;
            case "Editar":
                if(pj.equals("cuenta"))editarCuenta(request, response);
                if(pj.equals("area"))editarArea(request, response);
                break;
            case "Borrar":
                if(pj.equals("cuenta"))borrarCuenta(request, response);
                if(pj.equals("area"))borrarArea(request, response);
                break;

            default:
                paginaError(request, response, "Accion no identificada");
        }
    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos de navegacion">
     /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void goToAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        CuentasDao daoCuenta = new CuentasDao();
        AreaDao daoArea = new AreaDao();
        List<Cuenta> lstAllUsers;
        List<Area> lstAllAreas;
        lstAllUsers = daoCuenta.getTodasCuentas();
        lstAllAreas = daoArea.getTodaArea();
        req.setAttribute("lstAllUsers", lstAllUsers);
        req.setAttribute("lstAllAreas", lstAllAreas);
        String mensaje = daoCuenta.getMensaje();
        mensaje +="; " + daoArea.getMensaje();
        req.setAttribute("mensajeDao", mensaje);
        req.getRequestDispatcher("/admsis/index.jsp").forward(req, res);
    }

    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void goToCrudUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = 0;
        String mensaje = "";
        if (req.getParameter("id") != null) {
            try {
                id = Integer.parseInt(req.getParameter("id"));
            } catch (Exception e) {
                System.out.println("Error de conversion id");
            }
        }
        System.out.println("Id: " + id);
        CuentasDao daoCuenta = new CuentasDao();
        AreaDao daoArea = new AreaDao();
        List<Cuenta> lstAllUsers;
        List<Area> lstAllAreas;
        lstAllUsers = daoCuenta.getTodasCuentas();
        lstAllAreas = daoArea.getTodaArea();
        req.setAttribute("lstAllUsers", lstAllUsers);
        req.setAttribute("lstAllAreas", lstAllAreas);
        Cuenta cnta = daoCuenta.getCuenta(id);
        if (cnta != null) {
            req.setAttribute("cuentaSel", cnta);
        } else {
            System.out.println("Cuenta no encontrada...");
            mensaje += "Cuenta no encontrada...";
        }

        mensaje = daoCuenta.getMensaje();
        req.setAttribute("mensaje", mensaje);
        req.getRequestDispatcher("/admsis/crudusuarios.jsp").forward(req, res);
    }
    private void cargaCrudUsuarios(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        AreaDao daoArea = new AreaDao();
        CuentasDao daoUsuario = new CuentasDao();
        List<Cuenta> lstAllUsuarios = daoUsuario.getTodasCuentas();
        List<Area> lstAllAreas = daoArea.getTodaArea();
        System.out.println("Ctrl_CargaCrudUsuarios_Areas: " + lstAllAreas.size());
        req.setAttribute("lstAllUsers", lstAllUsuarios);
        req.setAttribute("lstAllAreas", lstAllAreas);
        String url = "/admsis/crudusuarios.jsp";
        System.out.println(url);
        req.getRequestDispatcher(url).forward(req, res);
    }
    public void goToCrudArea(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = 0;
        String mensaje = "";
        if (req.getParameter("id") != null) {
            try {
                id = Integer.parseInt(req.getParameter("id"));
            } catch (Exception e) {
                System.out.println("Error de conversion id");
            }
        }
        AreaDao daoArea = new AreaDao();
        List<Area> lstAllAreas;
        lstAllAreas = daoArea.getTodaArea();
        req.setAttribute("lstAllAreas", lstAllAreas);
        Area area = daoArea.getArea(id);
        if (area != null) {
            req.setAttribute("areaSel", area);
        } else {
            System.out.println("Area no encontrada...");
            mensaje += "Area no encontrada...";
        }

        mensaje = daoArea.getMensaje();
        req.setAttribute("mensaje", mensaje);
        req.getRequestDispatcher("/admsis/crudareas.jsp").forward(req, res);
    }
    private void cargaCrudAreas(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        AreaDao daoArea = new AreaDao();
        List<Area> lstAllAreas = daoArea.getTodaArea();
        req.setAttribute("lstAllAreas", lstAllAreas);
        String url = "/admsis/crudareas.jsp";
        System.out.println(url);
        req.getRequestDispatcher(url).forward(req, res);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos de administracion de usuarios y seguridad">
   

    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
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
                    res.sendRedirect(req.getContextPath() + "/validapub/");
                    break;
                case 3:
                    res.sendRedirect(req.getContextPath() + "/editpubs/");
                    break;
                case 4:
                    res.sendRedirect(req.getContextPath() + "/validapub/");
                    break;
                default:
                    res.sendRedirect(req.getContextPath());
            }
        } else {
            paginaError(req, res, "Credenciales incorrectas, verifique sus datos");
        }

    }

    /**
     *
     * @param req
     * @param res
     * @throws IOException
     */
    public void cerrarSession(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.getSession().removeAttribute("cuentaActual");
        req.getSession().invalidate();
        res.sendRedirect(req.getContextPath());
    }

    /**
     *
     * @param req
     * @param res
     * @param mensaje
     * @throws IOException
     */
    public void paginaError(HttpServletRequest req, HttpServletResponse res, String mensaje) throws IOException {
        res.sendRedirect(req.getContextPath() + "/error.jsp?mensaje=" + mensaje);
    }

    public void agregaCuenta(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String curp = "", nombre = "", usuario = "", pass = "",
                strValida = "-1", strCargo = "-1", strTipo = "-1", strIdArea = "-1", mensaje = "";
        boolean continua = true;
        Cuenta nvCta = new Cuenta();
        CuentasDao daoCuenta = new CuentasDao();
        if (req.getParameter("curp") != null) {
            curp = req.getParameter("curp");
        }
        if (req.getParameter("nombre") != null) {
            nombre = req.getParameter("nombre");
        }
        if (req.getParameter("usuario") != null) {
            usuario = req.getParameter("usuario");
        }
        if (req.getParameter("pass") != null) {
            pass = req.getParameter("pass");
        }
        if (req.getParameter("valida") != null) {
            strValida = req.getParameter("valida");
        }
        if (req.getParameter("cargo") != null) {
            strCargo = req.getParameter("cargo");
        }
        if (req.getParameter("tipo") != null) {
            strTipo = req.getParameter("tipo");
        }
        if (req.getParameter("idarea") != null) {
            strIdArea = req.getParameter("idarea");
        }
        try {
            nvCta = new Cuenta(curp, nombre,
                    Integer.parseInt(strValida),
                    Integer.parseInt(strCargo),
                    usuario, pass,
                    Integer.parseInt(strTipo),
                    Integer.parseInt(strIdArea));
        } catch (Exception e) {
            mensaje += "Error de parametros (agregaCuenta): " + e.getMessage() + "; ";
            continua = false;
        }
        if (continua) {
            daoCuenta.addCuenta(nvCta);
            if (daoCuenta.isCorrecto()) {
                mensaje += "Regisrto agregado con éxito; ";
                String cad = req.getContextPath() + "/admsis/";
                //req.getRequestDispatcher(cad).forward(req, res);
                goToAdmin(req, res);
            } else {
                mensaje += "Lo sentimos el regisrto no fue agregado; ";

            }
        } else {
            //En caso de haber errores en los parametros
        }
        req.setAttribute("mensaje", mensaje);
        goToAdmin(req, res);
    }

    public void editarCuenta(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String curp = "", nombre = "", usuario = "", pass = "",
                strValida = "-1", strCargo = "-1", strTipo = "-1", strIdArea = "-1", mensaje = "", strId = "-1";
        boolean continua = true;
        Cuenta nvCta = new Cuenta();
        CuentasDao daoCuenta = new CuentasDao();
        if (req.getParameter("curp") != null) {
            curp = req.getParameter("curp");
        }
        if (req.getParameter("idCuenta") != null) {
            strId = req.getParameter("idCuenta");
        }
        if (req.getParameter("nombre") != null) {
            nombre = req.getParameter("nombre");
        }
        if (req.getParameter("usuario") != null) {
            usuario = req.getParameter("usuario");
        }
        if (req.getParameter("pass") != null) {
            pass = req.getParameter("pass");
        }
        if (req.getParameter("valida") != null) {
            strValida = req.getParameter("valida");
        }
        if (req.getParameter("cargo") != null) {
            strCargo = req.getParameter("cargo");
        }
        if (req.getParameter("tipo") != null) {
            strTipo = req.getParameter("tipo");
        }
        if (req.getParameter("idarea") != null) {
            strIdArea = req.getParameter("idarea");
        }
        try {
            nvCta = new Cuenta(
                    Integer.parseInt(strId),
                    curp, nombre,
                    Integer.parseInt(strValida),
                    Integer.parseInt(strCargo),
                    usuario, pass,
                    Integer.parseInt(strTipo),
                    Integer.parseInt(strIdArea));
        } catch (Exception e) {
            mensaje += "Error de parametros (editarCuenta): " + e.getMessage() + "; ";
            continua = false;
        }
        if (continua) {
            daoCuenta.updCuenta(nvCta);
            if (daoCuenta.isCorrecto()) {
                mensaje += "Regisrto editado con éxito; ";
                String cad = req.getContextPath() + "/admsis/";
                //req.getRequestDispatcher(cad).forward(req, res);

            } else {
                mensaje += "Lo sentimos el regisrto no fue editado; ";

            }
        } else {
            //En caso de haber errores en los parametros
        }
        req.setAttribute("mensaje", mensaje);
        goToAdmin(req, res);
    }

    public void borrarCuenta(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String mensaje = "", strId = "-1";
        int id = -1;
        boolean continua = true;
        CuentasDao daoCuenta = new CuentasDao();
        if (req.getParameter("idCuenta") != null) {
            strId = req.getParameter("idCuenta");
        }

        try {

            id = Integer.parseInt(strId);

        } catch (Exception e) {
            mensaje += "Error de parametros (editarCuenta): " + e.getMessage() + "; ";
            continua = false;
        }
        if (continua) {
            daoCuenta.delCuenta(id);
            if (daoCuenta.isCorrecto()) {
                mensaje += "Regisrto eliminado con éxito; ";
                //req.getRequestDispatcher(req.getContextPath() + "/admsis/").forward(req, res);

            } else {
                mensaje += "Lo sentimos el regisrto no fue eliminado; ";

            }
        } else {
            //En caso de haber errores en los parametros
        }
        req.setAttribute("mensaje", mensaje);
        goToAdmin(req, res);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos de administracion de areas">

    public void agregaArea(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nombre = "", nombreCorto="", strSuperior= "-1", mensaje = "";
        boolean continua = true;
        Area nvArea = new Area();
        AreaDao daoArea = new AreaDao();
        if (req.getParameter("nombre") != null) {
            nombre = req.getParameter("nombre");
        }
        if (req.getParameter("nombreCorto") != null) {
            nombreCorto = req.getParameter("nombreCorto");
        }
        if (req.getParameter("superior") != null) {
            strSuperior = req.getParameter("superior");
        }
        try {
            nvArea = new Area(nombre, nombreCorto,Integer.parseInt(strSuperior));
        } catch (Exception e) {
            mensaje += "Error de parametros (agregaArea): " + e.getMessage() + "; ";
            continua = false;
        }
        if (continua) {
            daoArea.addArea(nvArea);
            if (daoArea.isCorrecto()) {
                mensaje += "Regisrto agregado con éxito; ";
            } else {
                mensaje += "Lo sentimos el regisrto no fue agregado; ";
            }
        } else {
            //En caso de haber errores en los parametros
        }
        req.setAttribute("mensaje", mensaje);
        goToAdmin(req, res);
    }

    public void editarArea(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nombre = "", nombreCorto = "", strSuperior = "-1", strIdArea = "-1",mensaje="";
        boolean continua = true;
        Area nvArea = new Area();
        AreaDao daoArea = new AreaDao();
        if (req.getParameter("nombre") != null) {
            nombre = req.getParameter("nombre");
        }
        if (req.getParameter("idArea") != null) {
            strIdArea = req.getParameter("idArea");
        }
        if (req.getParameter("nombreCorto") != null) {
            nombreCorto = req.getParameter("nombreCorto");
        }
        if (req.getParameter("superior") != null) {
            strSuperior = req.getParameter("superior");
        }
        try {
            nvArea = new Area(
                    Integer.parseInt(strIdArea),
                    nombre, nombreCorto,
                    Integer.parseInt(strSuperior));
        } catch (Exception e) {
            mensaje += "Error de parametros (editarArea): " + e.getMessage() + "; ";
            continua = false;
        }
        if (continua) {
            daoArea.updArea(nvArea);
            if (daoArea.isCorrecto()) {
                mensaje += "Regisrto editado con éxito; ";
            } else {
                mensaje += "Lo sentimos el regisrto no fue editado; ";
            }
        } else {
            //En caso de haber errores en los parametros
        }
        req.setAttribute("mensaje", mensaje);
        goToAdmin(req, res);
    }

    public void borrarArea(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String mensaje = "", strId = "-1";
        int id = -1;
        boolean continua = true;
        AreaDao daoArea = new AreaDao();
        if (req.getParameter("idArea") != null) {
            strId = req.getParameter("idArea");
        }

        try {

            id = Integer.parseInt(strId);

        } catch (Exception e) {
            mensaje += "Error de parametros (editarCuenta): " + e.getMessage() + "; ";
            continua = false;
        }
        if (continua) {
            daoArea.delArea(id);
            if (daoArea.isCorrecto()) {
                mensaje += "Regisrto eliminado con éxito; ";
                //req.getRequestDispatcher(req.getContextPath() + "/admsis/").forward(req, res);

            } else {
                mensaje += "Lo sentimos el regisrto no fue eliminado; ";

            }
        } else {
            //En caso de haber errores en los parametros
        }
        req.setAttribute("mensaje", mensaje);
        goToAdmin(req, res);
    }
    
    //</editor-fold>
    
    
}
