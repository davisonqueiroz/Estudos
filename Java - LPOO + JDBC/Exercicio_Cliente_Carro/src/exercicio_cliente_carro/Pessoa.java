
package exercicio_cliente_carro;


public class Pessoa {
    
    public int Id;
    public String CPF;
    public String Nome;

    public Pessoa(String CPF, String Nome) {
        this.CPF = CPF;
        this.Nome = Nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    
}
