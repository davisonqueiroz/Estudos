
package exercicio_cliente_carro;

import DAO.PessoaDAO;
import DAO.CarroDAO;
import Interfaces.I_CBanco;
import Interfaces.I_PBanco;
import Models.Pessoa;
import Models.Carro;


public class Exercicio_Cliente_Carro {

   
    public static void main(String[] args) {
        
        /*Pessoa p = new Pessoa ("312.423.532-54", "Roberto da Silva Gonzalez");
        PessoaDAO.salvar(p);
        Pessoa p1 = new Pessoa ("534.855.768-34", "Ana Julia Faria");
        PessoaDAO.salvar(p1);
        Pessoa p2 = new Pessoa ("567.867.970-43", "Julio Andrade");
        PessoaDAO.salvar(p2);
        
        Carro c = new Carro ("AWE-32W2", "Kwid", 2017, "Branco" , 1 );
        CarroDAO.salvar(c);
        Carro c1 = new Carro ("IEH-43V7", "Fiat Uno", 2005, "Branco" , 2 );
        CarroDAO.salvar(c1);
        Carro c2 = new Carro ("IRH-85B8", "Fusca", 1998, "Amarelo" , 3 );
        CarroDAO.salvar(c2);
        */
        Carro c = new Carro("RWE-23C1", "Fiat Uno", 2008, "Vinho");
        I_CBanco carro = new CarroDAO();
        carro.salvar(c);
       

    }
    
}
