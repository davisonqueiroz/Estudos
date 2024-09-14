/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Models.Pessoa;
import java.util.List;

/**
 *
 * @author User
 */
public interface I_PBanco {
    
    public void salvar(Pessoa pessoa);
    
    public void excluir(Pessoa pessoa);

    public List<Pessoa> listar();

    public List<Pessoa> buscarPorNome(String nome);

    public void atualizarRegistro(Pessoa pessoa);
}
