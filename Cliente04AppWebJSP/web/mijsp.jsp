<%-- 
    Document   : mijsp
    Created on : 
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mi JSP (Java Server Pages)</h1>
        <!--Se puede escribir en un JSP como si fuera una clase Java-->
        <%@page import="java.util.*" %>
        <%!String cadena = "Hola esto es una cadena";%>
        <%=cadena%>
        <hr>

        <form action="mijsp.jsp" method="post">
            Operación:
            <select name="operacion">
                <option value="1">Suma</option>
                <option value="2">Resta</option>
                <option value="3">Multiplica</option>
                <option value="4">Divide</option>
                <option value="5">Potencia</option>
            </select>
            <br>
            Valor 1:
            <input type="text" name="parametro1">
            <br>
            Valor 2:
            <input type="text" name="parametro2">
            <br>
            <br>
            <button type="submit">Enviar</button>
            <button type="reset">Borrar</button>
        </form>

        
       
        <%-- start web service invocation --%><hr/>
        <%
        String operacion = request.getParameter("operacion");
        if(operacion != null && !"".equals(operacion)) {
            int ope  = Integer.parseInt(operacion);
            try {                
                
                String val1 = request.getParameter("parametro1");
                String val2 = request.getParameter("parametro2");
                if(val1 != null && val2 != null && !"".equals(val1) && !"".equals(val2)) {
                    com.medac.ws.CalculatorService_Service service = new com.medac.ws.CalculatorService_Service();
                    com.medac.ws.CalculatorService port = service.getCalculatorServicePort();
                    
                    String resultado = "";
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
                        }//end switch
                    out.println("<h1>Resultado de la operacion</h1>");
                    out.println("<h1>" + resultado + "</h1>");
                }//end if
                
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        }//end if
        
        %>
        <%-- end web service invocation --%><hr/>
    </body>
</html>
