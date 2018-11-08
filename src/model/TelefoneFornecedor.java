package model;

import dao.TelefoneFornecedorDAO;

import java.nio.channels.ClosedSelectorException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelefoneFornecedor extends Telefone {
    private Long idFornecedor;
    Fornecedor fornecedor;

    public TelefoneFornecedor(Long idTelefone, String telefone, Fornecedor fornecedor) {
        super(idTelefone, telefone);
        this.fornecedor = fornecedor;
    }

    public void gravar() throws SQLException, ClassNotFoundException{
        TelefoneFornecedorDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        TelefoneFornecedorDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        TelefoneFornecedorDAO.excluir(this);
    }

    public static TelefoneFornecedor obterTelefone(Long idFornecedor) throws ClassNotFoundException,SQLException{
        return TelefoneFornecedorDAO.obterTelefone(idFornecedor);
    }

    public static List<TelefoneFornecedor> obterTodosTelefones() throws ClassNotFoundException, SQLException{
        return TelefoneFornecedorDAO.obterTodosTelefones();
    }

    public Fornecedor getFornecedor() {
        if(idFornecedor != 0 && fornecedor == null){
            try {
                fornecedor = Fornecedor.obterFornecedor(idFornecedor);
            } catch (SQLException ex) {
                Logger.getLogger(TelefoneFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelefoneFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Long getIdFornecedor(){return idFornecedor;}

    public void setIdFornecedor(Long id){this.idFornecedor=id;}
}
