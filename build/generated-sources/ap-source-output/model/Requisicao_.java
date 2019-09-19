package model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Status;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-19T07:50:12")
@StaticMetamodel(Requisicao.class)
public class Requisicao_ { 

    public static volatile SingularAttribute<Requisicao, Integer> area;
    public static volatile SingularAttribute<Requisicao, Calendar> dataGeraRequisicao;
    public static volatile SingularAttribute<Requisicao, String> horario;
    public static volatile SingularAttribute<Requisicao, String> cnpj;
    public static volatile SingularAttribute<Requisicao, String> rsp;
    public static volatile SingularAttribute<Requisicao, Integer> boletimInformativo;
    public static volatile SingularAttribute<Requisicao, Integer> codLogradouro;
    public static volatile SingularAttribute<Requisicao, Integer> atividade;
    public static volatile SingularAttribute<Requisicao, String> nomeFantasia;
    public static volatile SingularAttribute<Requisicao, Usuario> usuario;
    public static volatile SingularAttribute<Requisicao, Long> id;
    public static volatile SingularAttribute<Requisicao, String> razaoSocial;
    public static volatile SingularAttribute<Requisicao, Status> status;

}