/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.plan.docente.web.beans.administracion;

import co.com.plan.docente.entities.Docente;
import co.com.plan.docente.entities.Facultad;
import co.com.plan.docente.forentities.DocenteFacadeLocal;
import co.com.plan.docente.forentities.FacultadFacadeLocal;
import co.com.plan.docente.web.util.AccionesGenerico;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.faces.convert.Converter;

/**
 *
 * @author Jorge Montoya Jaramillo <paposkid@gmail.com>
 */
@Named
@ViewScoped
public class DocenteBean implements Serializable{

    /**
     * Creates a new instance of DocenteBean
     */
    public DocenteBean() {
    }
     private static final long serialVersionUID = 1L;

    private Docente docente;
    private List<Docente> docentes;
    List<Facultad> facultades;
    private AccionesGenerico<Docente> accionesDocente;
    private Converter facultadConverter;

    @EJB
    private DocenteFacadeLocal persistenciaDocente;
    @EJB
    private FacultadFacadeLocal persistenciaFacultad;
    @ManagedProperty("#{msg}")
    private ResourceBundle msg;

    public Docente getDocente() {
        return docente;
    }

    public List<Facultad> getFacultades() {
        if (facultades == null) {
            facultades = persistenciaFacultad.findActivas();
        }
        return facultades;
    }

    public void setFacultades(List<Facultad> facultades) {
        this.facultades = facultades;
    }

    public Converter getFacultadConverter() {
        if (this.facultadConverter == null) {
            this.facultadConverter = new Converter() {

                @Override
                public Object getAsObject(FacesContext context, UIComponent component, String value) {
                    Facultad retorno = null;

                    if (value != null && !value.isEmpty()
                            && !value.trim().equals("[TODOS]")
                            && !value.trim().equals("[NINGUNO]")) {
                        BigDecimal faculId = new BigDecimal(value);
                        for (Facultad fac : getFacultades()) {
                            if (new BigDecimal(fac.getCodFacultad()).compareTo(faculId) == 0) {
                                retorno = fac;
                                break;
                            }
                        }
                    }

                    return retorno;
                }

                @Override
                public String getAsString(FacesContext context, UIComponent component, Object value) {
                    String retorno = null;

                    if (value != null && value instanceof Facultad) {
                        retorno = ((Facultad) value).getCodFacultad().toString();
                    }

                    return retorno;
                }
            };
        }
        return facultadConverter;
    }

    public void setFacultadConverter(Converter facultadConverter) {
        this.facultadConverter = facultadConverter;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Docente> getDocentes() {
        if (docentes == null) {
            docentes = persistenciaDocente.findAll();
        }
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public AccionesGenerico<Docente> getAccionesDocente() {
        if (this.accionesDocente == null) {
            this.accionesDocente = new co.com.plan.docente.web.util.AccionesGenerico<Docente>() {
                @Override
                public void eliminarGenerico(Docente registro) {
                    persistenciaDocente.remove(registro);
                    limpiar();
                }

                @Override
                public void crearGenerico(Docente registro) {
                    persistenciaDocente.create(registro);
                    limpiar();
                }

                @Override
                public void actualizarGenerico(Docente registro) {
                    persistenciaDocente.edit(registro);
                    limpiar();
                }

                @Override
                public boolean isEmptyGenerico(Docente registro) {
                    return (registro == null || registro.getCodDocente()== null);
                }

                @Override
                public String getMsgTexto() {
                    return "Docente";
                }
            };
        }
        return accionesDocente;
    }

    public void setAccionesDocente(AccionesGenerico<Docente> accionesDocente) {
        this.accionesDocente = accionesDocente;
    }

    public ResourceBundle getMsg() {
        return msg;
    }

    public void setMsg(ResourceBundle msg) {
        this.msg = msg;
    }
     private void limpiar() {
        this.docente = null;
        this.docentes = null;
    }

    public void nuevoDocente() {
        this.docente = new Docente();
    }

    public void eliminar() {
        try {
            AccionesGenerico.eliminarGenerico(getAccionesDocente(), this.docente, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void aplicarCambiosDocente() {
        try {
            AccionesGenerico.aplicarCambiosGenerico(getAccionesDocente(), this.docente, msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocurrió un error al guardar el registro.", ""));
        }

    }
    
}
