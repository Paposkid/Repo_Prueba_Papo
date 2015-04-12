/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plan.docente.forentities;

import co.com.plan.docente.entities.ActExtAcademica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 727855
 */
@Local
public interface ActExtAcademicaFacadeLocal {

    void create(ActExtAcademica actExtAcademica);

    void edit(ActExtAcademica actExtAcademica);

    void remove(ActExtAcademica actExtAcademica);

    ActExtAcademica find(Object id);

    List<ActExtAcademica> findAll();

    List<ActExtAcademica> findRange(int[] range);

    int count();
    
}
