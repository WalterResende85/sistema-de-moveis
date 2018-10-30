package teste;

import dao.ClienteDAO;
import dao.MovelDAO;
import dao.PedidoDAO;
import model.Movel;
import model.Pedido;

import java.sql.SQLException;

public class MainMovel {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Pedido p = Pedido.obterPedido(1L);
        Movel m1 = new Movel(101L,"FGCUYCVTVSYC",p);
        MovelDAO.gravar(m1);
    }
}
