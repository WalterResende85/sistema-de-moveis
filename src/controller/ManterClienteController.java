/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Walter
 */
@WebServlet(name = "ManterClienteController", urlPatterns = "/ManterClienteController")
public class ManterClienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")){
            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        if (!operacao.equals("Incluir")) {
            String parameter = request.getParameter("idCliente").trim();
            Long idCliente = Long.parseLong(parameter);
            Cliente cliente = Cliente.obterCliente(idCliente);
            request.setAttribute("cliente", cliente);
            request.setAttribute("telefones", ClienteDAO.telefonesByClient(idCliente));
        }
        request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
    }
    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        String operacao = request.getParameter("operacao");
        Long idCliente = Long.parseLong(request.getParameter("IdCLiente"));
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCpf");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String email = request.getParameter("txtEmail");
        String cep = request.getParameter("txtCep");
        String logradouro = request.getParameter("txtLogradouro");
        String numero= request.getParameter("txtNumero");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String uf = request.getParameter("txtUf");
        String cidade = request.getParameter("txtCidade");
        try{
            Cliente cliente = new Cliente(idCliente, nome, cpf, dataNascimento, email, cep, logradouro, numero, complemento, bairro, uf, cidade);
            if(operacao.equals("Incluir")){
                cliente.gravar();
            }else if(operacao.equals("Editar")){
                cliente.alterar();
            }else if(operacao.equals("Excluir")){
                cliente.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
