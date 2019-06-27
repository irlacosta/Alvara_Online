/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author Irla Silva
 */
public enum Status {
    DEFERIDO("Deferido"), INDEFERIDO("Indeferido"), ALVARA_INCLUIDO("Alvará incluído"), DOCUMENTOS_PARA_ANALISE("Documentos para analisar"), ALVARA_DEFINITIVO("Alvará Definitivo"), ALVARA_PROVISORIO("Alvará Provisório"), DOCUMENTOS_PENDENTES("Documentos Pendentes");

    private String type;

    public String getType() {
        return type;
    }

    private Status(String type) {
        this.type = type;
    }

    public void setName(String type) {
        this.type = type;
    }

//para chamar = Status.getStatus();
    public static List<String> getStatus() {
        List<String> listStatus = new ArrayList();
        Status vetor[] = Status.values();
        for (int i = 0; i < vetor.length; i++) {
            listStatus.add(vetor[i].name());
        }
        return listStatus;
    }
}
