
package exercicio_cliente_carro;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


public class Carro_BD {
    
    public static void salvar(Carro carro){
        
        //comando o qual sera usado para salvar os dados diretamente no banco de dados
        String com = "insert into carro(Placa,Modelo,Ano,Cor,Proprietario) values" + "('" + carro.getPlaca() + 
                "', '" + carro.getModelo() + "', '" + carro.getAno() + "', '" + carro.getCor() + "', '" +
                carro.getProprietario() + "')";
        
        Connection conn = ConexaoFactory.getConect();
        
        try {
            
            //Statement é responsavel por executar as ações que afetarão o Bando de Dados
            Statement stm = conn.createStatement();
            stm.executeUpdate(com);
            ConexaoFactory.close(conn,stm);
            System.out.println("Registro(carro) salvo com sucesso");
        } catch (SQLException e) {
            System.out.println("Falha ao salvar registro ");
            e.printStackTrace();
        }
        
        
    }
    
}
