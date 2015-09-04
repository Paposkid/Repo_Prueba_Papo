package cl.clarochile.aplicaciones.evalcrediticia.form;

import java.util.ArrayList;

import cl.clarochile.aplicaciones.evalcrediticia.to.CampoTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.CondicionTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.ConstanteTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.DominioTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.ReglaTO;
import cl.clarochile.aplicaciones.evalcrediticia.to.TipoReglaTO;

public class ReglaForm {

	private ReglaTO reglaTO;
	private ReglaTO reglaDetalleTO;
	private CondicionTO condicionTO;
	private CondicionTO condicionLogicoTO;
	private CondicionTO condicionSalidaTO;
	private ArrayList<ReglaTO> resultados;
	private ArrayList<TipoReglaTO> listaComboRegla;
	private ArrayList<CampoTO> listaComboCampoEntrada;
	private ArrayList<CampoTO> listaComboCampoSalida;
	private ArrayList<CategoriaTO> listaComboCategoria;
	private ArrayList<DominioTO> listaComboDominio;
	private ArrayList<ConstanteTO> listaComboConstante;
	private boolean paginaEntrada;
	private boolean paginaSalida;
	private String[] condiciones;
	private String[] condicionesSalida;
	private ArrayList<CondicionTO> cargaCondiciones;
	private String valorCondiciones;
	private String valorLogico;
	private String valorSalida;
	private String valorResultado;

	public ReglaTO getReglaTO() {
		if (reglaTO == null) {
			reglaTO = new ReglaTO();
		}
		return reglaTO;
	}

	public void setReglaTO(ReglaTO reglaTO) {
		this.reglaTO = reglaTO;
	}

	public ReglaTO getReglaDetalleTO() {
		if (reglaDetalleTO == null) {
			reglaDetalleTO = new ReglaTO();
		}
		return reglaDetalleTO;
	}

	public void setReglaDetalleTO(ReglaTO reglaDetalleTO) {
		this.reglaDetalleTO = reglaDetalleTO;
	}

	public CondicionTO getCondicionTO() {
		if (condicionTO == null) {
			condicionTO = new CondicionTO();
		}
		return condicionTO;
	}

	public void setCondicionTO(CondicionTO condicionTO) {
		this.condicionTO = condicionTO;
	}
	
	public CondicionTO getCondicionLogicoTO() {
		if (condicionLogicoTO == null){
			condicionLogicoTO = new CondicionTO();
		}
		return condicionLogicoTO;
	}
	
	public void setCondicionLogicoTO(CondicionTO condicionLogicoTO) {
		this.condicionLogicoTO = condicionLogicoTO;
	}

	public ArrayList<ReglaTO> getResultados() {
		if (resultados == null) {
			resultados = new ArrayList<ReglaTO>();
		}
		return resultados;
	}

	public void setResultados(ArrayList<ReglaTO> resultados) {
		this.resultados = resultados;
	}
	
	public ArrayList<TipoReglaTO> getListaComboRegla() {
		if (listaComboRegla == null) {
			listaComboRegla = new ArrayList<TipoReglaTO>();
		}
		return listaComboRegla;
	}
	
	public void setListaComboRegla(ArrayList<TipoReglaTO> listaComboRegla) {
		this.listaComboRegla = listaComboRegla;
	}
	
	public ArrayList<CampoTO> getListaComboCampoEntrada() {
		if (listaComboCampoEntrada == null) {
			listaComboCampoEntrada = new ArrayList<CampoTO>();
		}
		return listaComboCampoEntrada;
	}
	
	public void setListaComboCampoEntrada(ArrayList<CampoTO> listaComboCampoEntrada) {
		this.listaComboCampoEntrada = listaComboCampoEntrada;
	}
	
	public ArrayList<CampoTO> getListaComboCampoSalida() {
		if (listaComboCampoSalida == null) {
			listaComboCampoSalida = new ArrayList<CampoTO>();
		}
		return listaComboCampoSalida;
	}
	
	public void setListaComboCampoSalida(ArrayList<CampoTO> listaComboCampoSalida) {
		this.listaComboCampoSalida = listaComboCampoSalida;
	}
	
	public ArrayList<CategoriaTO> getListaComboCategoria() {
		if (listaComboCategoria == null) {
			listaComboCategoria = new ArrayList<CategoriaTO>();
		}
		return listaComboCategoria;
	}
	
	public void setListaComboCategoria(ArrayList<CategoriaTO> listaComboCategoria) {
		this.listaComboCategoria = listaComboCategoria;
	}
	
	public ArrayList<DominioTO> getListaComboDominio() {
		if (listaComboDominio == null) {
			listaComboDominio = new ArrayList<DominioTO>();
		}
		return listaComboDominio;
	}
	
	public void setListaComboDominio(ArrayList<DominioTO> listaComboDominio) {
		this.listaComboDominio = listaComboDominio;
	}
	
	public ArrayList<ConstanteTO> getListaComboConstante() {
		if (listaComboConstante == null) {
			listaComboConstante = new ArrayList<ConstanteTO>();
		}
		return listaComboConstante;
	}
	
	public void setListaComboConstante(ArrayList<ConstanteTO> listaComboConstante) {
		this.listaComboConstante = listaComboConstante;
	}
	
	public boolean isPaginaEntrada() {
		return paginaEntrada;
	}
	
	public void setPaginaEntrada(boolean paginaEntrada) {
		this.paginaEntrada = paginaEntrada;
	}
	
	public boolean isPaginaSalida() {
		return paginaSalida;
	}
	
	public void setPaginaSalida(boolean paginaSalida) {
		this.paginaSalida = paginaSalida;
	}
	
	public String[] getCondiciones() {
		return condiciones;
	}
	
	public void setCondiciones(String[] condiciones) {
		this.condiciones = condiciones;
	}
	
	public String[] getCondicionesSalida() {
		return condicionesSalida;
	}
	
	public void setCondicionesSalida(String[] condicionesSalida) {
		this.condicionesSalida = condicionesSalida;
	}
	
	public ArrayList<CondicionTO> getCargaCondiciones() {
		if (cargaCondiciones == null){
			cargaCondiciones = new ArrayList<CondicionTO>();
		}
		return cargaCondiciones;
	}
	
	public void setCargaCondiciones(ArrayList<CondicionTO> cargaCondiciones) {
		this.cargaCondiciones = cargaCondiciones;
	}

	public String getValorCondiciones() {
		return valorCondiciones;
	}

	public void setValorCondiciones(String valorCondiciones) {
		this.valorCondiciones = valorCondiciones;
	}

	public String getValorLogico() {
		return valorLogico;
	}

	public void setValorLogico(String valorLogico) {
		this.valorLogico = valorLogico;
	}

	public String getValorSalida() {
		return valorSalida;
	}

	public void setValorSalida(String valorSalida) {
		this.valorSalida = valorSalida;
	}

	public String getValorResultado() {
		return valorResultado;
	}

	public void setValorResultado(String valorResultado) {
		this.valorResultado = valorResultado;
	}
	
	public CondicionTO getCondicionSalidaTO() {
		if (condicionSalidaTO == null) {
			condicionSalidaTO = new CondicionTO();
		}
		return condicionSalidaTO;
	}
	
	public void setCondicionSalidaTO(CondicionTO condicionSalidaTO) {
		this.condicionSalidaTO = condicionSalidaTO;
	}
}