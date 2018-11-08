/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ferramenta;
import model.Funcionario;

/**
 *
 * @author ISAAC
 */
@WebServlet(name = "ManterFerramentaController", urlPatterns = "/ManterFerramentaController")
public class ManterFerramentaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            //confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")){
            prepararOperacao(request,response);
            }
        }
    }
    
        public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            
            if (!operacao.equals("Incluir")) {
                Long idFerramenta = Long.parseLong(request.getParameter("idFerramenta"));
                Ferramenta ferramenta = Ferramenta.obterFerramenta(idFerramenta);
                request.setAttribute("Ferramenta", ferramenta);
                request.setAttribute("funcionarios", Funcionario.obterTodosFuncionarios());
            }
            request.getRequestDispatcher("cadastroFerramenta.jsp").forward(request, response);
            
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
    /*
     protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        Long idFerramenta = Long.parseLong(request.getParameter("idFerramenta"));
        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");
        double valorTotal = Double.parseDouble(request.getParameter("valorTotal"));
        double qtdEstoque = Double.parseDouble(request.getParameter("qtdEstoque"));
        String unidade = request.getParameter("unidade");
        
        Long idFuncionario = null;
        if(getFuncionario(request)){
            idFuncionario = Long.parseLong(request.getParameter("idPedido"));
        }
        try {
           Ferramenta ferramenta = new Ferramenta(idFerramenta, nome, tipo, valorTotal, qtdEstoque, unidade, idFuncionario);
            if (operacao.equals("Incluir")) {
                ferramenta.gravar();
            } else if (operacao.equals("Editar")) {
                ferramenta.alterar();
                System.out.println("Bring edit");
            } else if (operacao.equals("Excluir")) {
                ferramenta.excluir();
            }
            request.getRequestDispatcher("PesquisaFerramentaController").forward(request, response);
            
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }   
        
*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
