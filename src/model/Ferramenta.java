package model;

import dao.FerramentaDAO;

import java.sql.SQLException;
import java.util.List;

public class Ferramenta extends MaterialFerramenta {

    private Funcionario funcionario;
    private Long idFuncionario;     //COLOCAR EM TODOS QUE TEM CHAVE ESTRANGEIRA
    private Long idFerramenta;

    public Ferramenta() {
    }

    public Ferramenta(Long idFerramenta, String nome, Funcionario funcionario) {
        this.setIdFerramenta(idFerramenta);
        this.setNome(nome);
        this.setFuncionario(funcionario);
    }

    public Ferramenta(Long idFerramenta, String nome, String tipo, double valorUnitario,
                      double qtdEstoque, String unidade, Long idFuncionario) {
        super(nome, tipo, valorUnitario, qtdEstoque, unidade);
       this.idFuncionario = idFuncionario;

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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

   
    public Long getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(Long idFerramenta) {
        this.idFerramenta = idFerramenta;
    }
}