/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_cliente_carro;


public class Carro {
    
    public String Placa;
    public String Modelo;
    public int Ano;
    public String Cor;
    public int Proprietario;

    public Carro(String Placa, String Modelo, int Ano, String Cor, int Proprietario) {
        this.Placa = Placa;
        this.Modelo = Modelo;
        this.Ano = Ano;
        this.Cor = Cor;
        this.Proprietario = Proprietario;
    }

    
    public int getProprietario() {
        return Proprietario;
    }

    public void setProprietario(int Proprietario) {
        this.Proprietario = Proprietario;
    }
    
    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }
    
    
}
