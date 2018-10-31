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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;

/**
 *
 * @author Walter
 */
public class ManterFornecedorController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("confirmarOperacao")) {
                confirmarOperacao(request, response);
            } else {
                if (acao.equals("prepararOperacao")) {
                    prepararOperacao(request, response);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                Long idFornecedor = Long.parseLong(request.getParameter("idFornecedor"));
                Fornecedor fornecedor = Fornecedor.obterFornecedor(idFornecedor);
                request.setAttribute("fornecedor", fornecedor);
            }
            RequestDispatcher view = request.getRequestDispatcher("cadastroFornecedor.jsp");
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
    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String email = request.getParameter("email");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String uf = request.getParameter("uf");
        String cidade = request.getParameter("cidade");
         String telefone = request.getParameter("telefone");
        Long idFornecedor = Long.parseLong(request.getParameter("idFornecedor"));
        try{
            Fornecedor fornecedor = new Fornecedor(idFornecedor, nome, cnpj, email, cep, logradouro, numero, complemento, bairro, uf, cidade, telefone);
            if(operacao.equals("Incluir")){
                fornecedor.gravar();
            }else if(operacao.equals("Editar")){
                fornecedor.alterar();
            }else if(operacao.equals("Excluir")){
                fornecedor.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFornecedorController");
            view.forward(request, response);
        }catch(IOException e){
            throw new ServletException(e);
        }catch(SQLException e){
            throw new ServletException(e);
        }catch(ClassNotFoundException e){
            throw new ServletException(e);
        }catch(ServletException e){
            throw e;
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
