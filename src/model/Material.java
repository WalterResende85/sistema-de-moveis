package model;

import dao.MaterialDAO;

import java.sql.SQLException;
import java.util.List;

public class Material extends MaterialFerramenta {

    private Long idMaterial;
   
   
    public Material(Long idMaterial, String nome, String tipo, double valorUnitario, double qtdEstoque, String unidade, Fornecedor fornecedor) {
        super(nome, tipo, valorUnitario, qtdEstoque, unidade, fornecedor);
        this.idMaterial = idMaterial;
    }

    public  void  gravar() throws SQLException, ClassNotFoundException{
        MaterialDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        MaterialDAO.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        MaterialDAO.excluir(this);
    }

    public static  Material obterMaterial(Long idMaterial) throws  SQLException, ClassNotFoundException{
        return MaterialDAO.obterMaterial(idMaterial);
    }

    public static List< Material> obterTodosMateriais() throws ClassNotFoundException, SQLException{
        return  MaterialDAO.obterTodosMateriais();
    }


    public long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(long idMaterial) {
        this.idMaterial = idMaterial;
    }
}
