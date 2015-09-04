package cl.clarochile.aplicaciones.evalcrediticia.form;

import java.util.ArrayList;
import cl.clarochile.aplicaciones.evalcrediticia.to.ReporteTO;

public class ReporteForm {

	private ReporteTO reporteEvalTO;
	private ArrayList<ReporteTO> resultadosReporteEval;
	private ArrayList listaAcreditaciones;

	public ReporteTO getReporteEvalTO() {
		if (reporteEvalTO == null) {
			reporteEvalTO = new ReporteTO();
		}
		return reporteEvalTO;
	}

	public void setReporteEvalTO(ReporteTO reporteEvalTO) {
		this.reporteEvalTO = reporteEvalTO;
	}

	public ArrayList<ReporteTO> getResultadosReporteEval() {
		if (resultadosReporteEval == null) {
			resultadosReporteEval = new ArrayList<ReporteTO>();
		}
		return resultadosReporteEval;
	}

	public void setResultadosReporteEval(ArrayList<ReporteTO> resultadosReporteEval) {
		this.resultadosReporteEval = resultadosReporteEval;
	}
	
	public ArrayList getListaAcreditaciones() {
		if (listaAcreditaciones == null){
			listaAcreditaciones = new ArrayList();
		}
		return listaAcreditaciones;
	}
	
	public void setListaAcreditaciones(ArrayList listaAcreditaciones) {
		this.listaAcreditaciones = listaAcreditaciones;
	}
}
