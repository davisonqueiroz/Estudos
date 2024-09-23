/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Models.Carro;

import java.util.List;

/**
 *
 * @author User
 */
public interface I_CBanco {
    public void salvar(Carro carro);
    
    public void excluir(Carro carro);

    public List<Carro> listar();

    public List<Carro> buscarPorPlaca(String placa);

    public void atualizarRegistro(Carro carro);
    
    public int ultimaPessoa();
}
