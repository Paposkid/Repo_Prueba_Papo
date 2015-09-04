<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script type="text/javascript" language="javaScript">
	function exportar() {
		jQuery("#frmReporteListar").attr("action", "exportarEvaluacion.do");
		jQuery("#frmReporteListar").submit();
	}
</script>


<div class="bodyExp">

	<div class="titulo">
		<h1>
			<fmt:message key="menu.reportes.evaluaciones" />
		</h1>
	</div>

	<form:form id="frmReporteListar" action="reporteEval.do"
		commandName="reporteForm" method="POST">

		<div class="grupoCamposExp">
			<table align="center">
				<tr>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.nroOrden">
							<fmt:message key="general.nroOrden" />
						</form:label></td>
					<td class="campoTexto"><form:input
							path="reporteEvalTO.nroOrden" maxlength="12"></form:input></td>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.tipoEvaluacion">
							<fmt:message key="reporte.tipoEval" />
						</form:label></td>
					<td class="campoCombo"><form:select
							path="reporteEvalTO.tipoEvaluacion">
							<form:option value="" selected>
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:option value="L">
								<fmt:message key="reporte.tipoEval.lce" />
							</form:option>
							<form:option value="F">
								<fmt:message key="reporte.tipoEval.fce" />
							</form:option>
							<form:option value="E">
								<fmt:message key="reporte.tipoEval.excep" />
							</form:option>
						</form:select></td>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.fechaDesde">
							<fmt:message key="reporte.desde" />
						</form:label>
					</td>
					<td class="campoTexto"><form:input id="datepickerDesde"
							path="reporteEvalTO.fechaDesde" maxlength="12"></form:input>
					</td>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.fechaHasta">
							<fmt:message key="reporte.hasta" />
						</form:label>
					</td>
					<td class="campoTexto"><form:input id="datepickerHasta"
							path="reporteEvalTO.fechaHasta" maxlength="12"></form:input></td>
				</tr>
				<tr>
					<td class="campoTexto"><form:label path="reporteEvalTO.rut">
							<fmt:message key="reporte.rut" />
						</form:label></td>
					<td class="campoTexto"><form:input path="reporteEvalTO.rut"
							maxlength="12"></form:input></td>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.cliente">
							<fmt:message key="reporte.cliente" />
						</form:label>
					</td>
					<td class="campoTexto"><form:input
							path="reporteEvalTO.cliente" maxlength="12"></form:input></td>
					<td class="campoTexto"><form:label path="reporteEvalTO.estado">
							<fmt:message key="reporte.estado" />
						</form:label></td>
					<td class="campoCombo"><form:select
							path="reporteEvalTO.estado">
							<form:option value="" selected>
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:option value="A">
								<fmt:message key="general.reporte.aceptado" />
							</form:option>
							<form:option value="R">
								<fmt:message key="general.reporte.rechazado" />
							</form:option>
							<form:option value="C">
								<fmt:message key="general.reporte.condicionado" />
							</form:option>
						</form:select></td>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.tipoAcreditacion">
							<fmt:message key="reporte.acreditacion" />
						</form:label>
					</td>
					<td class="campoCombo"><form:select
							path="reporteEvalTO.tipoAcreditacion">
							<form:option value="" selected>
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:options items="${reporteForm.listaAcreditaciones}"
								itemLabel="nombreCampo" itemValue="codigoCampo" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.canalVenta">
							<fmt:message key="reporte.canal" />
						</form:label></td>
					<td class="campoCombo"><form:select
							path="reporteEvalTO.canalVenta">
							<form:option value="" selected>
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:option value="A">
								<fmt:message key="general.reporte.aceptado" />
							</form:option>
							<form:option value="R">
								<fmt:message key="general.reporte.rechazado" />
							</form:option>
							<form:option value="C">
								<fmt:message key="general.reporte.condicionado" />
							</form:option>
						</form:select></td>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.tipoCliente">
							<fmt:message key="reporte.tipoCliente" />
						</form:label></td>
					<td class="campoCombo"><form:select
							path="reporteEvalTO.tipoCliente">
							<form:option value="" selected>
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:option value="A">
								<fmt:message key="general.reporte.aceptado" />
							</form:option>
							<form:option value="R">
								<fmt:message key="general.reporte.rechazado" />
							</form:option>
							<form:option value="C">
								<fmt:message key="general.reporte.condicionado" />
							</form:option>
						</form:select></td>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.distribuidor">
							<fmt:message key="reporte.distribuidor" />
						</form:label>
					</td>
					<td class="campoTexto"><form:input
							path="reporteEvalTO.distribuidor" maxlength="12"></form:input></td>
					<td class="campoTexto"><form:label path="reporteEvalTO.dicom">
							<fmt:message key="reporte.dicom" />
						</form:label>
					</td>
					<td>
						<table>
							<tr>
								<td><form:radiobutton id="idCheckCat"
										path="reporteEvalTO.dicom" value="SI"
										onclick="cambiarTipo(this);" /></td>
								<td class="campoTexto"><form:label
										path="reporteEvalTO.dicom">
										<fmt:message key="general.si" />
									</form:label></td>
								<td><form:radiobutton id="idCheckCat"
										path="reporteEvalTO.dicom" value="NO"
										onclick="cambiarTipo(this);" />
								</td>
								<td class="campoTexto"><form:label
										path="reporteEvalTO.dicom">
										<fmt:message key="general.no" />
									</form:label></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.nivelRiesgo">
							<fmt:message key="reporte.riesgo" />
						</form:label>
					</td>
					<td class="campoCombo"><form:select
							path="reporteEvalTO.nivelRiesgo">
							<form:option value="" selected>
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:option value="A">
								<fmt:message key="general.reporte.aceptado" />
							</form:option>
							<form:option value="R">
								<fmt:message key="general.reporte.rechazado" />
							</form:option>
							<form:option value="C">
								<fmt:message key="general.reporte.condicionado" />
							</form:option>
						</form:select>
					</td>
					<td class="campoTexto"><form:label
							path="reporteEvalTO.rangoEdad">
							<fmt:message key="reporte.edad" />
						</form:label></td>
					<td class="campoTexto"><form:input
							path="reporteEvalTO.rangoEdad" maxlength="12"></form:input></td>
				</tr>
			</table>
		</div>

		<div class="divBarraBotones">
			<input class="barraBotones" type="submit"
				value="<fmt:message key="general.botonBuscar"/>"
				title='<fmt:message key="general.botonBuscar"/>' />
		</div>

		<br>
		<c:if test="${fn:length(reporteForm.resultadosReporteEval)>0}">
			<fieldset class="grupoCampos">
				<legend>
					<fmt:message key="general.resultado.busquedas" />
				</legend>

				<div class="tabla">
					<display:table name="reporteForm.resultadosReporteEval" id="filaId"
						requestURI="reporteEval.do?reload=false" pagesize="4">

						<display:column property="fecha" titleKey="general.fechaR" />
						<display:column property="cliente" titleKey="general.clienteR" />
						<display:column property="vendedor" titleKey="general.vendedorR" />
						<display:column property="excepcionador"
							titleKey="general.excepcionadorR" />
						<display:column property="estado" titleKey="general.estado" />
						<display:column property="tipoAcreditacion"
							titleKey="general.tipoAcreditaR" />
						<display:column property="canalVenta"
							titleKey="general.canalVentaR" />
						<display:column property="tipoCliente"
							titleKey="general.tipoClienteR" />
						<display:column property="distribuidor"
							titleKey="general.distribuidorR" />
						<display:column property="dicom" titleKey="general.dicomR" />
						<display:column property="nivelRiesgo"
							titleKey="general.nivelRiesgoR" />
						<display:column property="rangoEdad" titleKey="general.rangoEdadR" />
						<display:column property="formaPago" titleKey="general.formaPagoR" />

					</display:table>

					<div style="text-align: center;">
						<a href="javascript:void(0);" onclick="exportar();"> <img
							src="<fmt:message key="general.exportarRegistroSrc" />"
							height="30px"
							alt="<fmt:message key="general.exportarRegistroAlt" />"
							width="30px" /> </a>
					</div>
				</div>
			</fieldset>
		</c:if>
	</form:form>
</div>