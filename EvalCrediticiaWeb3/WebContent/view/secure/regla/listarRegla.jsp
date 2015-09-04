<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script language="javaScript" type="text/javascript">
	function nuevo() {
		jQuery("#frmReglaListar").attr("action", "mostrarPaginaDetalleRegla.do");
		jQuery("#frmReglaListar").submit();
	}
	
	function editar(id) {
		jQuery("#frmReglaListar").attr("action", "editarParametro.do");
		jQuery("#idCodigoRegla").val(id);
		jQuery("#frmReglaListar").submit();		
	}
	
	function duplicar(id) {
		jQuery("#frmReglaListar").attr("action", "duplicarRegla.do");
		jQuery("#idCodigoRegla").val(id);
		jQuery("#frmReglaListar").submit();		
	}
</script>


<div class="body">

	<div class="titulo">
		<h1>
			<fmt:message key="regla.tituloListar" />
		</h1>
	</div>

	<!-- Pagina de control de errores en el encabezado -->
	<%@ include file="/mostrarErrores.jsp"%>
	<!-- fin Pagina de control de errores en el encabezado -->

	<form:form id="frmReglaListar" action="listarReglas.do" commandName="reglaForm" method="POST">

		<div class="grupoCampos">
			<div class="campoTexto">
				<form:label path="reglaTO.nombre">
					<fmt:message key="general.nombre" />:
				</form:label>
				<form:input path="reglaTO.nombre" maxlength="100"></form:input>
			</div>

			<div class="campoCombo">
				<form:label path="reglaTO.tipoRegla">
					<fmt:message key="general.tipo" />:
				</form:label>
				<form:select path="reglaTO.tipoRegla">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${reglaForm.listaComboRegla}" itemLabel="nombre" itemValue="codigo" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="reglaTO.subtipoRegla">
					<fmt:message key="regla.subtipo" />:
				</form:label>
				<form:select path="reglaTO.subtipoRegla">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="G">
						<fmt:message key="regla.general" />
					</form:option>
					<form:option value="E">
						<fmt:message key="regla.especifica" />
					</form:option>
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="reglaTO.tipoEvaluacion">
					<fmt:message key="regla.evaluacion" />:
				</form:label>
				<form:select path="reglaTO.tipoEvaluacion">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="P">
						<fmt:message key="regla.preEval" />
					</form:option>
					<form:option value="E">
						<fmt:message key="regla.eval" />
					</form:option>
					<form:option value="O">
						<fmt:message key="regla.postEval" />
					</form:option>
				</form:select>
			</div>

			<div class="campoTexto">
				<form:label path="reglaTO.fechaVigenciaDesde">
					<fmt:message key="regla.inicioVigencia" />:
				</form:label>
				<form:input id="datepickerDesde" path="reglaTO.fechaVigenciaDesde" maxlength="12"></form:input>
			</div>

			<div class="campoTexto">
				<form:label path="reglaTO.fechaVigenciaHasta">
					<fmt:message key="regla.finVigencia" />:
				</form:label>
				<form:input id="datepickerHasta" path="reglaTO.fechaVigenciaHasta" maxlength="12"></form:input>
			</div>

			<div class="campoCombo">
				<form:label path="reglaTO.estado">
					<fmt:message key="general.estado" />:
				</form:label>
				<form:select path="reglaTO.estado">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="A">
						<fmt:message key="general.estado.activo" />
					</form:option>
					<form:option value="I">
						<fmt:message key="general.estado.inactivo" />
					</form:option>
				</form:select>
			</div>

			<br>
			<div class="divBarraBotones">
				<input 
					class="barraBotones" type="submit"
					value="<fmt:message key="general.botonBuscar"/>"
					title='<fmt:message key="general.botonBuscar"/>' /> 
				<input
					onclick="nuevo();" class="barraBotonesGrande" type="button"
					value="<fmt:message key="general.botonNuevaRegla"/>"
					title='<fmt:message key="general.botonNuevaRegla"/>' />
				<!-- <input
					onclick="busquedaAdv();" class="barraBotonesGrande" type="button"
					value="<fmt:message key="general.botonBusquedaAv"/>"
					title='<fmt:message key="general.botonBusquedaAv"/>' /> -->
			</div>
			
			<br>
			<div class="divBarraBotones">
				<!-- <input 
					onclick="nuevo();" class="barraBotonesGrande" type="button"
					value="<fmt:message key="general.botonProbar"/>"
					title='<fmt:message key="general.botonProbar"/>' /> 
				<input
					onclick="nuevoApartir();" class="barraBotonesGrande" type="button"
					value="<fmt:message key="general.botonNuevaReglaOtra"/>"
					title='<fmt:message key="general.botonNuevaReglaOtra"/>' /> -->
			</div>
		</div>

		<c:if test="${fn:length(reglaForm.resultados)>0}">
			<fieldset class="grupoCampos">
				<legend>
					<fmt:message key="general.resultado.busquedas" />
				</legend>

				<div class="tabla">
					<div id="displayTagDiv">
						<display:table name="reglaForm.resultados" id="filaId" requestURI="listarReglas.do?reload=false" pagesize="20">

							<display:column style="text-align: center;">
								<a href="javascript:void(0);" onclick="editar('${filaId.codigo}');"> <img
									src="<fmt:message key="general.editarRegistroSrc" />"
									height="16px"
									alt="<fmt:message key="general.editarRegistroAlt" />"
									width="16px" /> </a>
							</display:column>

							<display:column style="text-align: center;">
								<a href="javascript:void(0);" onclick="duplicar('${filaId.codigo}');"> <img
									src="<fmt:message key="general.crearApartirOtraReglaSrc" />"
									height="16px"
									alt="<fmt:message key="general.crearApartirOtraReglaAlt" />"
									width="16px" /> </a>
							</display:column>

							<display:column property="nombre" titleKey="regla.nombre" />
							<display:column property="nombreTipoRegla" titleKey="regla.tipo" />
							<display:column property="fechaVigenciaDesde" titleKey="regla.inicioVigencia" />
							<display:column property="fechaVigenciaHasta" titleKey="regla.finVigencia" />
							<display:column property="nombreEstado" titleKey="regla.estado" />

						</display:table>
					</div>
				</div>
			</fieldset>
		</c:if>
	</form:form>
</div>