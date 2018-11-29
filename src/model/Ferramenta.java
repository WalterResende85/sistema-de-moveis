package model;

import dao.FerramentaDAO;

import java.sql.SQLException;
import java.util.List;

public class Ferramenta extends MaterialFerramenta {

    private Long idFerramenta;

    public Ferramenta() {
    }

    public Ferramenta(Long idFerramenta, String nome) {
        this.setIdFerramenta(idFerramenta);
        this.setNome(nome);
       
    }

    public Ferramenta(Long idFerramenta, String nome, String tipo, double valorUnitario,
                      double qtdEstoque, String unidade, Fornecedor fornecedor) {
        super(nome, tipo, valorUnitario, qtdEstoque, unidade, fornecedor);
       this.idFerramenta = idFerramenta;

    }
    public  void  gravar() throws SQLException, ClassNotFoundException{
        FerramentaDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        FerramentaDAO.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        FerramentaDAO.excluir(this);
    }

    public static Ferramenta obterFerramenta(Long idFerramenta) throws SQLException, ClassNotFoundException{
        return FerramentaDAO.obterFerramenta(idFerramenta);
    }

    public static List<Ferramenta> obterTodasFerramentas() throws ClassNotFoundException, SQLException{
        return FerramentaDAO.obterTodasFerramentas();
    }

    public Long getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(Long idFerramenta) {
        this.idFerramenta = idFerramenta;
    }
}