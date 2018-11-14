package model;

import dao.ClienteDAO;

import java.sql.SQLException;
import java.util.List;

public class Cliente extends Pessoa {
    private Long idCliente;

    public Cliente(Long id,String nome ) {
        this.setIdCliente(id);
        this.setNome(nome);
    }



    public Cliente(Long id,String nome, String cpf, String dataNascimento, String email, String cep, String logradouro,
                   String numero, String complemento, String bairro, String uf, String cidade, String telefone, String celular) {
        super(nome, cpf, dataNascimento, email, cep, logradouro, numero, complemento, bairro, uf, cidade, telefone, celular);
        this.setIdCliente(id);
    }

   
    public  void  gravar() throws SQLException, ClassNotFoundException{
        ClienteDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        ClienteDAO.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        ClienteDAO.excluir(this);
    }

    public static Cliente obterCliente(Long idCliente) throws  SQLException, ClassNotFoundException{
        return ClienteDAO.obterCLiente(idCliente);
    }

    public static List<Cliente> obterTodosClientes() throws ClassNotFoundException, SQLException{
        return ClienteDAO.obterTodosClientes();
    }


    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
