/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medac;

import com.medac.ws.CalculatorService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author MEDAC
 */
@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet"})
public class MiServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CalculadoraWS/CalculatorService.wsdl")
    private CalculatorService_Service service;

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            int ope  = Integer.parseInt(request.getParameter("operacion"));
            String val1 = request.getParameter("parametro1");
            String val2 = request.getParameter("parametro2");
            com.medac.ws.CalculatorService port = service.getCalculatorServicePort();
            String resultado = "Operacion " + ope + " val1 "+ val1 + " val2 " + val2;
            
            switch(ope) {
                    case 1: {
                        double a = port.suma(Double.parseDouble(val1), Double.parseDouble(val2));
                        resultado = "El resultado de la <b>suma</b> de " + val1 + " + " + val2 + " = " + a;
                        break;
                    }
                    case 2: {
                        double a = port.resta(Double.parseDouble(val1), Double.parseDouble(val2));
                        resultado = "El resultado de la <b>resta</b> de " + val1 + " - " + val2 + " = " + a;
                        break;
                    }
                    case 3: {
                        double a = port.multiplica(Double.parseDouble(val1), Double.parseDouble(val2));
                        resultado = "El resultado de la <b>multiplicación</b> de " + val1 + " * " + val2 + " = " + a;
                        break;
                    }
                    case 4: {
                        double a = port.divide(Double.parseDouble(val1), Double.parseDouble(val2));
                        resultado = "El resultado de la <b>división</b> de " + val1 + " / " + val2 + " = " + a;
                        break;
                    }
                    case 5: {
                        double a = port.potencia(Double.parseDouble(val1), Integer.parseInt(val2));
                        resultado = "El resultado de la <b>potencia</b> de " + val1 + " ^ " + val2 + " = " + a;
                        break;
                    }
                    default:
                        //Operación no válida
                        resultado = "Error!!! Operación no válida";
            }
                        
            
            out.println("<h1>Resultado de la operacion</h1>");
            out.println("<h1>" + resultado + "</h1>");
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
