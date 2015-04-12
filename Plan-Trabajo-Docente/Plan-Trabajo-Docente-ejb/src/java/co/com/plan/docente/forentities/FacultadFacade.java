/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plan.docente.forentities;

import co.com.plan.docente.entities.Facultad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author 727855
 */
@Stateless
public class FacultadFacade extends AbstractFacade<Facultad> implements FacultadFacadeLocal {

    @PersistenceContext(unitName = "Plan-Trabajo-Docente-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacultadFacade() {
        super(Facultad.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Facultad> findActivas() {

        List<Facultad> facultad;
        TypedQuery<Facultad> findByEstFacultad;
        findByEstFacultad = em.createNamedQuery("Facultad.findByEstFacultad", Facultad.class);
        findByEstFacultad.setParameter("estFacultad", "A");
        facultad = findByEstFacultad.getResultList();
        return facultad;
    }
}
