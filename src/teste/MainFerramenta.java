package teste;

import dao.FerramentaDAO;
import dao.FuncionarioDAO;
import model.Ferramenta;
import model.Funcionario;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainFerramenta {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<Ferramenta> lista = new ArrayList();
        int j=0;

        for(long i = 10L; i<10 ; i++, j++ ){
           
        lista.add(new Ferramenta(i,"Martelo"+i, FuncionarioDAO.obterFuncionario(10L)));
        FerramentaDAO.gravar(lista.get(j));
        }





        //Ferramenta fe = new Ferramenta(2L,"Foice", FuncionarioDAO.obterFuncionario(1L));
        //FerramentaDAO.gravar(fe);
        Ferramenta x = FerramentaDAO.obterFerramenta(1L);
        x.setNome("Picareta");
        FerramentaDAO.alterar(x);
        //FerramentaDAO.excluir(FerramentaDAO.obterFerramenta(13L));
        //FerramentaDAO.alterar(x);
    }
}
