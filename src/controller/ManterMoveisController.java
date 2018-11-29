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
import model.Movel;
import model.Pedido;

@WebServlet(name = "ManterMoveisController", urlPatterns = "/ManterMoveisController")
public class ManterMoveisController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        request.setAttribute("pedidos", Pedido.obterTodosPedidos());
        if (!operacao.equals("Incluir")) {
            Movel movel = Movel.obterMovel(Long.parseLong(request.getParameter("idMovel")));
            request.setAttribute("movel", movel);

        }
        request.getRequestDispatcher("cadastroMoveis.jsp").forward(request, response);

    }

    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        Long idMovel = Long.parseLong(request.getParameter("idMovel"));
        String nome = request.getParameter("nome");
        double preco = Double.parseDouble(request.getParameter("preco"));
        String tipo = request.getParameter("tipo");
        String material = request.getParameter("material");
        double altura = Double.parseDouble(request.getParameter("altura"));
        double largura = Double.parseDouble(request.getParameter("largura"));
        double comprimento = Double.parseDouble(request.getParameter("comprimento"));
        String acabamento = request.getParameter("acabamento");
        double peso = Double.parseDouble(request.getParameter("peso"));

        Long idPedido = Long.parseLong(request.getParameter("idPedido"));

        try {
            Pedido pedido = null;
            if (idPedido != 0) {
                pedido = Pedido.obterPedido(idPedido);
            }

            Movel movel = new Movel(idMovel, nome, preco, tipo, material, altura, largura, comprimento, acabamento, peso, pedido);
            if (operacao.equals("Incluir")) {
                movel.gravar();
            } else if (operacao.equals("Editar")) {
                movel.alterar();
                System.out.println("Bring edit");
            } else if (operacao.equals("Excluir")) {
                movel.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaMovelController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException("Ja existe Móvel com este ID cadastrado no Banco de dados");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMoveisController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMoveisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMoveisController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMoveisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
