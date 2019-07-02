/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Irla Silva
 */
public class Analista extends Usuario{
    private int matricula;

    public Analista(int matricula, String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.matricula = matricula;
    }
    
    public Analista(){}
 
}

//Analista acessa as seguintes páginas:
//lista.xhtml (alterar nome da página para gerenciar viabilidades)
//baixa de alvará
//cadastro
//acompanhar
//cadastroRequisicaoNova
//cadastroRequisicaoRenovacao
//editar

//o usuário comum (Requerente) acessa as seguintes páginas
//cadastro
//acompanhar
//cadastroRequisicaoNova
//cadastroRequisicaoRenovacao
//editar
