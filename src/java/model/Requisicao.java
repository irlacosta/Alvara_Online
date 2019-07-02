/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Irla Silva
 */
public class Requisicao { //lado requerente    

    private String rsp; //RSP
    private int boletimInformativo; //sistema gera automatico
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private int codLogradouro;
    private String horarioFuncionamento;
    private int area;
    private Calendar dataGeraRequisicao;
    private List<Atividade> atividades;
    private Status status;
    //private int data; //data da análise da requisicao
    //private int data; //data da emissão do alvará
    // validador de CNPJ usar o código semelhante do validador de CPF
    // converter usar o AjaxRender para atividades

    public Requisicao() {
    }

    public Requisicao(String rsp, int boletimInformativo, String cnpj, Status status) {
        this.rsp = rsp;
        this.boletimInformativo = boletimInformativo;
        this.cnpj = cnpj;
        this.status = status;
    }

    public String getRsp() {
        return rsp;
    }

    public void setRsp(String numero) {
        this.rsp = numero;
    }

    public int getBoletimInformativo() {
        return boletimInformativo;
    }

    public void setBoletimInformativo(int boletimInformativo) {
        this.boletimInformativo = boletimInformativo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Calendar getDataGeraRequisicao() {
        return dataGeraRequisicao;
    }

    public void setDataGeraRequisicao(Calendar dataGeraRequisicao) {
        this.dataGeraRequisicao = dataGeraRequisicao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public String toString() {
        String aux = "";
        if (dataGeraRequisicao != null) {
            java.text.SimpleDateFormat sdf
                    = new SimpleDateFormat("dd/MM/yyyy"); //formatando a data
            aux = sdf.format(dataGeraRequisicao.getTime());
        }
        return "Requisicao{" + "RSP=" + rsp + ", boletimInformativo=" + boletimInformativo + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", codLogradouro=" + codLogradouro + ", horario=" + horarioFuncionamento + ", area=" + area + ", data=" + dataGeraRequisicao + aux + '}';
    }

    public List<Requisicao> list() {
        return RequisicaoDAO.getList();
    }

    public boolean insert() {
        return RequisicaoDAO.insert(this);
    }

    public boolean validate() {
        return RequisicaoDAO.validate(this);
    }

    public boolean delete() {
        return RequisicaoDAO.delete(this);
    }

    public boolean update() {
        return RequisicaoDAO.update(this);
    }
}
