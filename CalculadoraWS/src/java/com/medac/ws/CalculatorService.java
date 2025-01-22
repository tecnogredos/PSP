package com.medac.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Clase representativa del servicio web que será publicado en el servidor
 * @author 
 */
@WebService(serviceName = "CalculatorService")
public class CalculatorService {
    /**
     * Web service operation.
     * Suma dos valores de entrada y retorna el resultado
     * @param val1 Parámetro de entrada con el primer valor
     * @param val2 Parámetro de entrada con el segundo valor
     * @return Resutado de la operación
     */
    @WebMethod(operationName = "suma")
    public Double suma(@WebParam(name = "val1") double val1, @WebParam(name = "val2") double val2) {
        double resultado = val1 + val2;
        return resultado;
    }

    /**
     * Web service operation
     * Resta dos valores de entrada y retorna el resultado
     * @param val1 Parámetro de entrada con el primer valor
     * @param val2 Parámetro de entrada con el segundo valor
     * @return Resutado de la operación
     */
    @WebMethod(operationName = "resta")
    public Double resta(@WebParam(name = "val1") double val1, @WebParam(name = "val2") double val2) {
        double resultado = val1 - val2;
        return resultado;
    }

    /**
     * Web service operation
     * Multiplica dos valores de entrada y retorna el resultado
     * @param val1 Parámetro de entrada con el primer valor
     * @param val2 Parámetro de entrada con el segundo valor
     * @return Resutado de la operación
     */
    @WebMethod(operationName = "multiplica")
    public Double multiplica(@WebParam(name = "val1") double val1, @WebParam(name = "val2") double val2) {
        double resultado = val1 * val2;
        return resultado;
    }

    /**
     * Web service operation
     * Divide dos valores de entrada y retorna el resultado
     * @param val1 Parámetro de entrada con el primer valor
     * @param val2 Parámetro de entrada con el segundo valor
     * @return Resutado de la operación
     */
    @WebMethod(operationName = "divide")
    public Double divide(@WebParam(name = "val1") double val1, @WebParam(name = "val2") double val2) {
        double resultado = val1 / val2;
        return resultado;
    }

    /**
     * Web service operation
     * Eleva la base al exponente  retorna el resultado
     * @param base Parámetro de entrada con el primer valor
     * @param exponente Parámetro de entrada con el segundo valor
     * @return Resutado de la operación
     */
    @WebMethod(operationName = "potencia")
    public Double potencia(@WebParam(name = "base") double base, @WebParam(name = "exponente") int exponente) {
        double resultado = Math.pow(base, exponente);
        return resultado;
    }
}
