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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ferramenta;

/**
 *
 * @author ISAAC
 */
@WebServlet(name = "ManterFerramentaController", urlPatterns = "/ManterFerramentaController")
public class ManterFerramentaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            //confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")){
            //prepararOperacao(request,response);
            }
        }
    }
    
        public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("ferramentas", Ferramenta.obterTodasFerramentas());
            if (!operacao.equals("Incluir")) {
                Long idFerramenta = Long.parseLong(request.getParameter("idFerramenta"));
                Ferramenta ferramenta = Ferramenta.obterFerramenta(idFerramenta);
                request.setAttribute("Ferramenta", ferramenta);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastroFerramenta.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
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
