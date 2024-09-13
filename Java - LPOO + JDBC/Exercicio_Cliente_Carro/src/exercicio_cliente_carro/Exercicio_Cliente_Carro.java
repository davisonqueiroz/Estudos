
package exercicio_cliente_carro;


public class Exercicio_Cliente_Carro {

   
    public static void main(String[] args) {
        
        Pessoa p = new Pessoa ("312.423.532-54", "Roberto da Silva Gonzalez");
        Pessoa_BD.salvar(p);
        Pessoa p1 = new Pessoa ("534.855.768-34", "Ana Julia Faria");
        Pessoa_BD.salvar(p1);
        Pessoa p2 = new Pessoa ("567.867.970-43", "Julio Andrade");
        Pessoa_BD.salvar(p2);
        
        Carro c = new Carro ("AWE-32W2", "Kwid", 2017, "Branco" , 1 );
        Carro_BD.salvar(c);
        Carro c1 = new Carro ("IEH-43V7", "Fiat Uno", 2005, "Branco" , 2 );
        Carro_BD.salvar(c1);
        Carro c2 = new Carro ("IRH-85B8", "Fusca", 1998, "Amarelo" , 3 );
        Carro_BD.salvar(c2);
        
    }
    
}
