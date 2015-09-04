<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script language="javaScript" type="text/javascript">
	function ingresar() {

		jQuery("#frmParametroIngresar").attr("action", "insertarParametro.do");
		jQuery("#frmParametroIngresar").submit();
	}

	function actualizar() {

		jQuery("#frmParametroIngresar").attr("action", "actualizarParametro.do");
		jQuery("#frmParametroIngresar").submit();
	}

	function volver() {
		jQuery("#frmParametroIngresar").attr("action",
				"mostarPaginaParametro.do");
		jQuery("#frmParametroIngresar").submit();
	}

	function limpiar() {
		jQuery("#parametroDetalleTO\\.nombreParametro").val("");
		jQuery("#parametroDetalleTO\\.tipoParametro").val("");
		jQuery("#parametroDetalleTO\\.valorParametro").val("");
		jQuery("#parametroDetalleTO\\.estadoParametro").val("");		
	}
</script>



<div class="body">

	<!-- Titulo -->

	<div class="titulo">
		<c:if test="${empty hasId}">
			<h1>
				<fmt:message key="parametro.tituloNuevo" />
			</h1>
		</c:if>
		<c:if test="${!empty hasId}">
			<h1>
				<fmt:message key="parametro.tituloEditar" />
			</h1>
		</c:if>
	</div>



	<!-- fin Pagina de control de errores en el encabezado -->
	<%@ include file="/mostrarErrores.jsp"%>


	<form:form id="frmParametroIngresar" action="actualizarParametro.do"
		commandName="parametroForm" method="POST">

		<spring:hasBindErrors name="parametroForm">
			<div class="mensajeError">
				<form:errors path="*" />
			</div>
		</spring:hasBindErrors>

		<div class="grupoCampos">

			<form:hidden path="parametroDetalleTO.codigoParametro" />
			<form:hidden path="parametroTO.codigoParametro" />
			<form:hidden path="parametroTO.nombreParametro" />
			<form:hidden path="parametroTO.tipoParametro" />
			<form:hidden path="parametroTO.valorParametro" />
			<form:hidden path="parametroTO.estadoParametro" />

			<c:if test="${!empty hasId}">

				<div class="campoSoloLectura">
					<form:label path="parametroDetalleTO.nombreParametro">
						<fmt:message key="general.codigo" />:
						<em>*</em>
					</form:label>
					<form:input path="parametroDetalleTO.nombreParametro"
						readonly="true" maxlength="30"></form:input>
				</div>

			</c:if>


			<c:if test="${empty hasId}">
				<div class="campoTexto">
					<form:label path="parametroDetalleTO.nombreParametro">
						<fmt:message key="general.codigo" />:
						<em>*</em>
					</form:label>
					<form:input path="parametroDetalleTO.nombreParametro"
						maxlength="50"></form:input>
				</div>

			</c:if>

			<div class="campoCombo">
				<form:label path="parametroDetalleTO.tipoParametro">
					<fmt:message key="parametro.tipoParametro" />
					<em>*</em>
				</form:label>
				<form:select path="parametroDetalleTO.tipoParametro">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>

					<form:option value="1">
						<fmt:message key="parametro.limitesexcepcionador" />
					</form:option>

					<form:option value="2">
						<fmt:message key="parametro.tiempoesperaserviciosexternos" />
					</form:option>

					<form:option value="3">
						<fmt:message key="parametro.tiempovugenciaserviciosexternos" />
					</form:option>

					<form:option value="4">
						<fmt:message key="parametro.vigenciaevaluacion" />
					</form:option>

					<form:option value="5">
						<fmt:message key="parametro.respuestaserviciosexternos" />
					</form:option>
				</form:select>
			</div>

			<div class="campoTexto">
				<form:label path="parametroDetalleTO.valorParametro">
					<fmt:message key="general.valor" />:
					<em>*</em>
				</form:label>
				<form:input path="parametroDetalleTO.valorParametro" maxlength="12"></form:input>
			</div>
			<!-- jamj 
			<div class="campoCombo">
				<form:label path="parametroDetalleTO.estadoParametro">
					<fmt:message key="general.estado" />:
					<em>*</em>
				</form:label>
				<form:select path="parametroDetalleTO.estadoParametro">
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
			</div> -->
		</div>

		<div class="divBarraBotones">

			<c:if test="${empty hasId}">
				<input class="barraBotones" type="submit"
					value="<fmt:message key="general.botonAgregar"/>"
					title='<fmt:message key="general.botonAgregar"/>'
					onclick="ingresar();" />
			<input onclick="limpiar();" class="barraBotones" type="button"
				value='<fmt:message key="general.botonLimpiar"/>'
				title='<fmt:message key="general.botonLimpiar"/>' />				
			</c:if>
			
			
			<c:if test="${!empty hasId}">
				<input class="barraBotones" type="submit"
					value="<fmt:message key="general.botonAgregar"/>"
					title='<fmt:message key="general.botonAgregar"/>'
					onclick="actualizar();" />
					
			<input onclick="limpiar();" class="barraBotones" type="button"
				value='<fmt:message key="general.botonLimpiar"/>'
				title='<fmt:message key="general.botonLimpiar"/>' />				
					
					
			</c:if>
			<input class="barraBotones" type="submit"
				value='<fmt:message key="general.botonCancelar"/>'
				title='<fmt:message key="general.botonCancelar"/>'
				onclick="volver();" />
		</div>

		<div class="mensajeRequerido">
			<p>
				<fmt:message key="general.mensajeRequerido" />
			</p>
		</div>

	</form:form>
</div>
