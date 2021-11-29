/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.AllCash;
import entity.Model;
import javax.persistence.EntityManager;
import tools.Singleton;



/**
 *
 * @author pupil
 */
public class ModelFacade extends AbstractFacade<Model> {
     private EntityManager em;

    public ModelFacade(Class<Model> entityClass) {
        super(entityClass);
        init();
    }

    private void init(){
        Singleton singleton = Singleton.getInstance();
        em = singleton.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
