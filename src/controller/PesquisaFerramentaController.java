/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ferramenta;

/**
 *
 * @author Walter
 */
public class PesquisaFerramentaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{
            request.setAttribute("ferramentas", Ferramenta.obterTodasFerramentas());
            RequestDispatcher view = request.getRequestDispatcher("gridFerramenta.jsp");
            view.forward(request, response);
        }catch (ClassNotFoundException e){
            throw  new ServletException(e);
        }catch (SQLException e){
            throw new ServletException(e);
        }
    }
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
