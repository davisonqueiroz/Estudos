
package exercicio_cliente_carro;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Pessoa_BD {
    
    public static void salvar(Pessoa pessoa){
        
        String com = "insert into pessoa(CPF, Nome) values " + "('" + pessoa.getCPF() +
                "', '" + pessoa.getNome() + "')";
        
        Connection conn = ConexaoFactory.getConect();
        
        try {
        
            Statement stm = conn.createStatement();
            stm.executeUpdate(com);
            ConexaoFactory.close(conn, stm);
            System.out.println("Registro(pessoa) salva com sucesso ");
            
            
        } catch (SQLException e) {
            System.out.println("Falha ao salvar registro");
            e.printStackTrace();
        }
    }
}
