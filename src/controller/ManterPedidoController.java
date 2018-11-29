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
import model.Movel;
import model.Pedido;
import utils.Strings;
@WebServlet(name = "ManterPedidoController", urlPatterns = "/ManterPedidoController")
public class ManterPedidoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = Strings.getOperacao(request);
        request.setAttribute("operacao", operacao);
        request.setAttribute("clientes", Cliente.obterTodosClientes());
        if (!operacao.equals("Incluir")) {
            Pedido pedido = Pedido.obterPedido(Long.parseLong(request.getParameter("idPedido")));
            request.setAttribute("pedido", pedido);
        }
        request.getRequestDispatcher("cadastroPedido.jsp").forward(request, response);
    }

     protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        Long idPedido = Long.parseLong(request.getParameter("idPedido"));
        Double valorTotal = Double.parseDouble(request.getParameter("valorTotal"));
        Long idMovel = Long.parseLong(request.getParameter("idMovel"));
        Long idCliente = Long.parseLong(request.getParameter("idCliente"));

        try {
            Cliente cliente = null;
            Movel movel = null;
            if(idMovel != 0){
                movel = Movel.obterMovel(idMovel);
            }
            if (idCliente != 0) {
                cliente = Cliente.obterCliente(idCliente);
            }

            Pedido pedido = new Pedido(idPedido,valorTotal, movel, cliente);
            if (operacao.equals("Incluir")) {
                pedido.gravar();
            } else if (operacao.equals("Editar")) {
                pedido.alterar();
                System.out.println("Bring edit");
            } else if (operacao.equals("Excluir")) {
                pedido.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException("Favor informar o Cliente do pedido");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

   
}
