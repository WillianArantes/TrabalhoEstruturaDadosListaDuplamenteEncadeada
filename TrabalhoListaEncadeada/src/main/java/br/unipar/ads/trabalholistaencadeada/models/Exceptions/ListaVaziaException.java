/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.ads.trabalholistaencadeada.models.Exceptions;

/**
 *
 * @author willh
 */
public class ListaVaziaException extends Exception{
    
    public ListaVaziaException(){
        super("A lista está vazia!");
    }
}
