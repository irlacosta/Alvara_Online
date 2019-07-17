/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Irla Silva
 */
public class JPAUtil {
    private static EntityManagerFactory emf;
    public static EntityManager getEntityManager() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("irla-trabalho5-integradoPU");
        return emf.createEntityManager();
    }
    public void fechaEntityManager(){
        emf.close();
    }
}
