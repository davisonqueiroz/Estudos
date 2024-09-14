package DAO;

import Interfaces.I_CBanco;
import Models.Carro;
import exercicio_cliente_carro.MYSQLConector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO implements I_CBanco {

    public void salvar(Carro carro) {

        //comando o qual sera usado para salvar os dados diretamente no banco de dados
        String com = "insert into carro(Placa,Modelo,Ano,Cor,Proprietario) values (?, ?, ?, ?, ?)";

        Connection conn = MYSQLConector.getConect();

        try {

            PreparedStatement pstm = conn.prepareStatement(com);
            pstm.setString(1, carro.getPlaca());
            pstm.setString(2, carro.getModelo());
            pstm.setInt(3, carro.getAno());
            pstm.setString(4, carro.getCor());
            pstm.setInt(0, carro.getProprietario());
            pstm.executeUpdate();

            MYSQLConector.close(conn, pstm);
            System.out.println("Registro(carro) salva com sucesso ");

        } catch (SQLException e) {

            System.out.println("Erro ao salvar registro ");
            e.printStackTrace();
        }

    }

    @Override
    public void excluir(Carro carro) {

        String com = "delete from carro where Placa = ?";
        Connection conn = MYSQLConector.getConect();

        try {

            PreparedStatement pstm = conn.prepareStatement(com);
            pstm.setString(1, carro.getPlaca());
            pstm.executeUpdate();

            MYSQLConector.close(conn, pstm);
            System.out.println("Registro deletado com sucesso");

        } catch (SQLException e) {

            System.out.println("Erro ao deletar registro");
            e.printStackTrace();
        }
    }

    @Override
    public List<Carro> listar() {

        Connection conn = MYSQLConector.getConect();
        String com = "select * from carro";
        List<Carro> carroLista = new ArrayList();

        try {

            PreparedStatement pstm = conn.prepareStatement(com);
            //ResultSet trabalha com os resultados das consultas
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                carroLista.add(new Carro(rs.getString("Placa"), rs.getString("Modelo"), rs.getInt("Ano"), rs.getString("Cor"), rs.getInt("Proprietario")));
            }

            MYSQLConector.close(conn, pstm, rs);

            return carroLista;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Carro> buscarPorPlaca(String placa) {

        String com = "select * from carro where Placa = ?";
        Connection conn = MYSQLConector.getConect();
        List<Carro> carro = new ArrayList();

        try {

            PreparedStatement pstm = conn.prepareStatement(com);
            pstm.setString(1, placa);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                carro.add(new Carro(rs.getString("Placa"), rs.getString("Modelo"), rs.getInt("Ano"), rs.getString("Cor"), rs.getInt("Proprietario")));
            }

            MYSQLConector.close(conn, pstm, rs);

            return carro;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void atualizarRegistro(Carro carro) {

        String com = "update carro set Modelo = ?,Ano = ?, Cor = ?, Proprietario = ? where Placa = ?";
        Connection conn = MYSQLConector.getConect();

        try {

            PreparedStatement pstm = conn.prepareStatement(com);
            pstm.setString(1, carro.getModelo());
            pstm.setInt(2, carro.getAno());
            pstm.setString(3, carro.getCor());
            pstm.setInt(4, carro.getProprietario());
            pstm.setString(5, carro.getPlaca());
            pstm.executeUpdate();

            MYSQLConector.close(conn, pstm);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}


