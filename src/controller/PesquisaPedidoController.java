package controller;

import model.Pedido;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PesquisaPedidoController")
public class PesquisaPedidoController extends HttpServlet {



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        try{
            request.setAttribute("pedidos", Pedido.obterTodosPedidos());
            RequestDispatcher view = request.getRequestDispatcher("/gridPedido.jsp");
            view.forward(request,response);
        } catch (ClassNotFoundException e){
            throw new ServletException(e);
        } catch (SQLException e){
            throw new ServletException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
