/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.AllCash;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import tools.Singleton;

/**
 *
 * @author pupil
 */
public class AllCashFacade extends AbstractFacade<AllCash> {
        private EntityManager em;

    public AllCashFacade(Class<AllCash> entityClass) {
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
