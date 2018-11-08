package model;

import dao.TelefoneClienteDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelefoneCliente extends Telefone {
    private Long idCliente;
    private Cliente cliente;

    public TelefoneCliente(Long idTelefone, String telefone, Cliente cliente) {
        super(idTelefone, telefone);
        this.cliente = cliente;
    }

    public void gravar() throws SQLException, ClassNotFoundException{
        TelefoneClienteDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        TelefoneClienteDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        TelefoneClienteDAO.excluir(this);
    }

    public static TelefoneCliente obterTelefone(Long idCliente) throws ClassNotFoundException, SQLException{
        return TelefoneClienteDAO.obterTelefone(idCliente);
    }

    public static List<TelefoneCliente> obterTodosTelefones() throws ClassNotFoundException,SQLException{
        return TelefoneClienteDAO.obterTodosTelefones();
    }

    public Cliente getCliente() {
        if (idCliente != 0 && cliente == null) {
            try {
                cliente = Cliente.obterCliente(idCliente);
            } catch (SQLException ex) {
                Logger.getLogger(TelefoneCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelefoneCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long id) {
        this.idCliente=id;
    }
}
