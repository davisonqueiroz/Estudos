package DAO;

import Interfaces.I_PBanco;
import Models.Pessoa;
import exercicio_cliente_carro.MYSQLConector;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements I_PBanco {

    public void salvar(Pessoa pessoa) {

        //comando o qual sera usado para salvar os dados diretamente no banco de dados
        String com = "insert into pessoa(CPF, Nome) values (?, ?)";

        Connection conn = MYSQLConector.getConect();

        try {

            //PreparedStatement serve para evitar SQL Injection. Usa-se caracteres especiais que somente serao preenchidos com os dados
            //fornecidos, evitando uma tentativa de enviar um comando para retornar dados ao inves de salvar ou consultar dados
            PreparedStatement pstm = conn.prepareStatement(com);
            pstm.setString(1, pessoa.getCPF());
            pstm.setString(2, pessoa.getNome());
            pstm.executeUpdate();
            
            MYSQLConector.close(conn, pstm);
            System.out.println("Registro(pessoa) salva com sucesso ");

        } catch (SQLException e) {
            
            System.out.println("Erro ao salvar registro ");
            e.printStackTrace();
        }
    }

    public void excluir(Pessoa pessoa) {

        String com = "delete from pessoa where cpf = ?";
        Connection conn = MYSQLConector.getConect();

        try {

            PreparedStatement pstm = conn.prepareStatement(com);
            pstm.setString(1, pessoa.getCPF());
            pstm.executeUpdate();
            
            MYSQLConector.close(conn, pstm);
            System.out.println("Registro deletado com sucesso");

        } catch (SQLException e) {
            
            System.out.println("Erro ao deletar registro");
            e.printStackTrace();
        }
    }

    public List<Pessoa> listar() {

        Connection conn = MYSQLConector.getConect();
        String com = "select * from pessoa";
        List<Pessoa> pessoaLista = new ArrayList();

        try {

            PreparedStatement pstm = conn.prepareStatement(com);
            //ResultSet trabalha com os resultados das consultas
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                pessoaLista.add(new Pessoa(rs.getInt("Id"), rs.getString("CPF"), rs.getString("Nome")));
            }
            
            MYSQLConector.close(conn, pstm, rs);
            
            return pessoaLista;

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return null;
    }

    public List<Pessoa> buscarPorNome(String nome) {

        String com = "select * from pessoa where Nome like ?";
        Connection conn = MYSQLConector.getConect();
        List<Pessoa> pessoa = new ArrayList();

        try {

            PreparedStatement pstm = conn.prepareStatement(com);
            pstm.setString(1, "%" + nome + "%");
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                pessoa.add(new Pessoa(rs.getInt("Id"), rs.getString("CPF"), rs.getString("Nome")));
            }
            
            MYSQLConector.close(conn, pstm, rs);
            
            return pessoa;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarRegistro(Pessoa pessoa) {
        
        String com = "update pessoa set Nome = ?,CPF = ? where Id = ?";
        Connection conn = MYSQLConector.getConect();
        
        try {
            
            PreparedStatement pstm = conn.prepareStatement(com);
            pstm.setString(1,pessoa.getNome());
            pstm.setString(2,pessoa.getCPF());
            pstm.setInt(3,pessoa.getId());
            pstm.executeUpdate();
            
            MYSQLConector.close(conn, pstm);
            
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
}
