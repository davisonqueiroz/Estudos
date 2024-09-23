/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerc_estrutura_de_dados;

import java.util.Calendar;


public class Aluno {
    public String Nome;
    public String Nascimento;
    public String RA;

    public Aluno(String Nome, String Nascimento, String RA) {
        this.Nome = Nome;
        this.Nascimento = Nascimento;
        this.RA = RA;
    }

    public Aluno(){
        
    }
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getNascimento() {
        return Nascimento;
    }

    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    @Override
    public String toString() {
        return "Aluno{" + "Nome=" + Nome + ", Nascimento=" + Nascimento + ", RA=" + RA + '}';
    }
    
    
}
