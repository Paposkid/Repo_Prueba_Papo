<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script type="text/javascript">
	function volver() {
		jQuery("#frmReglaResultado").attr("action",
				"mostrarPaginaCondicionSalida.do");
		jQuery("#frmReglaResultado").submit();
	}
</script>

<div class="bodyExp">

	<div class="titulo">
		<h1>
			<fmt:message key="regla.resultados" />
		</h1>
	</div>

	<form:form id="frmReglaResultado" action="guardarRegla.do"
		commandName="reglaForm" method="POST">

		<form:hidden path="reglaDetalleTO.nombre" />
		<form:hidden path="reglaDetalleTO.tipoRegla" />
		<form:hidden path="reglaDetalleTO.subtipoRegla" />
		<form:hidden path="reglaDetalleTO.tipoEvaluacion" />
		<form:hidden path="reglaDetalleTO.fechaVigenciaDesde" />
		<form:hidden path="reglaDetalleTO.fechaVigenciaHasta" />
		<form:hidden path="reglaDetalleTO.sinVigencia" />
		<form:hidden path="reglaDetalleTO.estado" />
		<form:hidden path="reglaDetalleTO.descripcion" />

		<form:hidden path="condicionTO.campo.codigoCampo" />
		<form:hidden path="condicionTO.operador" />
		<form:hidden path="condicionTO.tipo" />
		<form:hidden path="condicionTO.categoria.codigoCategoria" />
		<form:hidden path="condicionTO.constante.codigo" />
		<form:hidden path="condicionTO.valor" />

		<form:hidden path="condicionSalidaTO.campo.codigoCampo" />
		<form:hidden path="condicionSalidaTO.operador" />
		<form:hidden path="condicionSalidaTO.tipo" />
		<form:hidden path="condicionSalidaTO.categoria.codigoCategoria" />
		<form:hidden path="condicionSalidaTO.constante.codigo" />
		<form:hidden path="condicionSalidaTO.valor" />

		<form:hidden path="condicionLogicoTO.valor" />
		<form:hidden path="condiciones" />
		<form:hidden path="condicionesSalida" />

		<div class="grupoCamposExp">
			<table align="center">
				<tr>
					<td><form:textarea id="idTextArea" path="valorResultado" readonly="true"
							cols="80" rows="20" /></td>
				</tr>
			</table>
		</div>

		<br />
		<div class="divBarraBotones">
			<input onclick="volver();" class="barraBotonesGrande" type="button"
				value="<fmt:message key="general.botonAnterior"/>"
				title="<fmt:message key="general.botonAnterior"/>" /> <input
				class="barraBotones" type="submit"
				value="<fmt:message key="general.botonFinalizar"/>"
				title="<fmt:message key="general.botonFinalizar"/>" />
		</div>
	</form:form>
</div>