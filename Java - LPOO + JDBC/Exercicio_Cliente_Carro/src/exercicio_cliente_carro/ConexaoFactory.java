/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_cliente_carro;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class ConexaoFactory {
    
    public static Connection getConect(){
        
        
        String url = "jdbc:mysql://localhost:3306/exercicio" ;
        String user = "root" ;
        String password = "root" ;
        
        try {
            
            // Conecction faz a conexao enquanto DriverManager acessa o conector do banco de dados especifico e devolve a conexao
            Connection conn = DriverManager.getConnection(url,user,password);
            
            System.out.println("Conexão realizada com sucesso!");
            return conn;
            
            
            
        } catch (SQLException e) {
            System.out.println("Falha de conexao");
            
        }
        return null;
    }
    
    public static void close(Connection conn){
        try {
            
            if(conn != null){
                conn.close();
                System.out.println("Conexao fechada com sucesso!");
            }
            
        } catch (SQLException e) {
            System.out.println("Falha ao fechar conexao");
        }
    }
    
    public static void close(Connection conn, Statement stm){
        close(conn);
        try {
            
            if(stm != null){
                stm.close();
                
            }
            
        } catch (SQLException e) {
            System.out.println("Falha ao fechar Statement");
        }
    }
}
