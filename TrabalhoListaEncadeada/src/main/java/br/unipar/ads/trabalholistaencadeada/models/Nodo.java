/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.ads.trabalholistaencadeada.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author willh
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Nodo<Cliente> {
    
    private Cliente cliente;
    private Nodo<Cliente> anterior;
    private Nodo<Cliente> proximo;
    
    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.anterior = null;
        this.proximo = null;
    }

    public Cliente getCliente(){
        return cliente;
    }    
    
    public Nodo getAnterior(){
        return anterior;
    } 
    
    public Nodo getProximo(){
        return proximo;
    }
    
    public void setAnterior(Nodo anterior){
        this.anterior = anterior;
    }
    
    public void setProximo(Nodo proximo){
        this.proximo = proximo;
    }
    
    
    
}

