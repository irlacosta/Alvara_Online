/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Irla Silva
 */
@Entity
public class Atividade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String secao; //A, B, C
//    private int divisao; //01...03
//    private String denominacao; //industria, comercio
    private Long id;
    private int cnae;
//CNAE é um código de atividades de acordo com uma tabela da Receita Federal
//e consta no CNPJ de toda empresa

    public Atividade() {
    }

    public Atividade(int cnae) {
        this.cnae = cnae;
    }

    public int getCnae() {
        return cnae;
    }

    public void setCnae(int cnae) {
        this.cnae = cnae;
    }

    public List<Atividade> listAtividades() {
        List<Atividade> atividades = new LinkedList<>();
        atividades.add(new Atividade(5611));
        atividades.add(new Atividade(4722));
        return atividades;
    }
}
