/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Irla Silva
 */
@Entity
public class Requisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_requisicao")
    private Long id;

    @Enumerated(EnumType.ORDINAL) //mapeamento enumeração
    //irá salvar no banco a ordem do status(apenas um número) pois as descrições são grandes
    private Status status;

    @Temporal(TemporalType.DATE)
    private Calendar dataGeraRequisicao; //data da requisição gerada pelo sistema. Data principal do processo de alvará
    //Por uma questão legal as viabilidades tem validades específicas
    //é essencial ter a data em que foi gerada a requisição

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) //existem muitas requisicoes para um requerente
    @JoinColumn(name = "id_usuario") //chave FK coluna de junção
    private Usuario usuario;

    private String rsp; //RSP
    private int boletimInformativo; //sistema gera automatico (ainda não implementei)
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private int codLogradouro;
    private int atividade;
    private String horario;
    private int area;

    //private int data; //data da análise da requisicao
    //private int data; //data da emissão do alvará
    // validador de CNPJ usar o código semelhante do validador de CPF
    // converter usar o AjaxRender para atividades
    public Requisicao() {
    }

    public Requisicao(Long id, Status status, String rsp, int boletimInformativo, String cnpj) {
        this.id = id;
        this.status = status;
        this.rsp = rsp;
        this.boletimInformativo = boletimInformativo;
        this.cnpj = cnpj;
    }

    public Requisicao(Status status, String rsp, int boletimInformativo, String cnpj) {
        this(-1L, status, rsp, boletimInformativo, cnpj);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Calendar getDataGeraRequisicao() {
        return dataGeraRequisicao;
    }

    public void setDataGeraRequisicao(Calendar dataGeraRequisicao) {
        this.dataGeraRequisicao = dataGeraRequisicao;
    }

    public String getRsp() {
        return rsp;
    }

    public void setRsp(String rsp) {
        this.rsp = rsp;
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

    public int getAtividade() {
        return atividade;
    }

    public void setAtividade(int atividade) {
        this.atividade = atividade;
    }

    @Override
    public String toString() {
        String aux = "";
        if (dataGeraRequisicao != null) {
            java.text.SimpleDateFormat sdf
                    = new SimpleDateFormat("dd/MM/yyyy"); //formatando a data
            aux = sdf.format(dataGeraRequisicao.getTime());
        }
        return "Requisicao{" + "id=" + id + ", status="
                + status + ", rsp=" + rsp + ", boletimInformativo="
                + boletimInformativo + ", cnpj=" + cnpj + ", razaoSocial="
                + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", atividade=" + atividade + "Data da solicitação:" + aux + '}';
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisicao)) {
            return false;
        }
        Requisicao other = (Requisicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public List<Requisicao> list() {
        return new RequisicaoDAO().listAll();
    }

    public List<Requisicao> buscarTodos() {
        return new RequisicaoDAO().listAll();
    }

    public void insert() {
        new RequisicaoDAO().insert(this);
    }

    public void remove() {
        //new RequisicaoDAO().remove(this); //o "this" está dando erro
    }

    public void update() {
        new RequisicaoDAO().update(this);
    }
}
