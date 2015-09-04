<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script language="javaScript" type="text/javascript">
	function nuevo() {
		jQuery("#frmParametroListar").attr("action", "nuevoParametro.do");
		jQuery("#frmParametroListar").submit();
	}

	function exportar() {
		jQuery("#frmParametroListar").attr("action", "exportarParExcel.do");
		jQuery("#frmParametroListar").submit();
	}

	function listar() {
		jQuery("#frmParametroListar").attr("action", "listarParametro.do");

	}
	
	function limpiar() {
		jQuery("#parametroTO\\.codigoParametro").val("");
		jQuery("#parametroTO\\.nombreParametro").val("");
		jQuery("#parametroTO\\.tipoParametro").val("");
		jQuery("#parametroTO\\.valorParametro").val("");
		jQuery("#parametroTO\\.estadoParametro").val("");
	}		

	function editar(id) {
		jQuery("#frmParametroListar").attr("action", "editarParametro.do");
		jQuery("#idCodigoParam").val(id);
		jQuery("#frmParametroListar").submit();
	}
</script>

<div class="body">

	<!-- Titulo -->
	<div class="titulo">
		<h1>
			<fmt:message key="parametro.tituloListar" />
		</h1>
	</div>

	<!-- Se muestran los mensajes Informativos -->
	<c:if test="${mensaje != null}">
		<div class="mensajeInformativo">${mensaje}</div>
	</c:if>

	<!-- Se muestran los mensajes de advertencia -->
	<c:if test="${advertencia != null}">
		<div class="mensajeAdvertencia">${advertencia}</div>
	</c:if>

	<!-- Se muestran los mensajes de errores -->
	<c:if test="${error != null}">
		<div class="mensajeError">${error}</div>
	</c:if>


	<form:form id="frmParametroListar" action="listarParametro.do"
		commandName="parametroForm" method="POST">

		<div class="grupoCampos">

			<form:hidden id="idCodigoParam"
				path="parametroDetalleTO.codigoParametro" />

			<div class="campoTexto">
				<form:label path="parametroTO.nombreParametro">
					<fmt:message key="general.codigo" />:
				</form:label>
				<form:input path="parametroTO.nombreParametro" maxlength="50"></form:input>
			</div>

			<div class="campoCombo">
				<form:label path="parametroTO.tipoParametro">
					<fmt:message key="parametro.tipoParametro" />
				</form:label>
				<form:select path="parametroTO.tipoParametro">
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
				<form:label path="parametroTO.valorParametro">
					<fmt:message key="general.valor" />:
				</form:label>
				<form:input path="parametroTO.valorParametro" maxlength="30"></form:input>
			</div>
			<!-- jamj 
			<div class="campoCombo">
				<form:label path="parametroTO.estadoParametro">
					<fmt:message key="general.estado" />:
				</form:label>
				<form:select path="parametroTO.estadoParametro">
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
		</div>-->

		<div class="divBarraBotones">
			<input onclick="listar();" class="barraBotones" type="submit"
				value="<fmt:message key="general.botonBuscar"/>"
				title='<fmt:message key="general.botonBuscar"/>' /> 
				
			<input onclick="limpiar();" class="barraBotones" type="button"
				value='<fmt:message key="general.botonLimpiar"/>'
				title='<fmt:message key="general.botonLimpiar"/>' />					
				
				<input
				onclick="nuevo();" class="barraBotones" type="button"
				value="<fmt:message key="general.botonAgregar"/>"
				title='<fmt:message key="general.botonAgregar"/>' />
		</div>

		<br>

		<c:if test="${fn:length(parametroForm.resultados)>0}">
			<fieldset class="grupoCampos">
				<legend>
					<fmt:message key="general.resultado.busquedas" />
				</legend>

				<div class="tabla">
					<display:table name="parametroForm.resultados" id="filaId"
						requestURI="listarParametro.do?reload=false" pagesize="20">

						<display:column style="text-align: center;">
							<a href="javascript:void(0);"
								onclick="editar('${filaId.codigoParametro}');"> <img
								src="<fmt:message key="general.editarRegistroSrc" />"
								height="16px"
								alt="<fmt:message key="general.editarRegistroAlt" />"
								width="16px" /> </a>

						</display:column>

						<display:column property="nombreParametro"
							titleKey="general.codigo" />
						<display:column property="tipoParametro"
							titleKey="parametro.tipoParametro" />							
						<display:column property="valorParametro" titleKey="general.valor" />
						

					</display:table>

					<div style="text-align: center;">
						<a href="javascript:void(0);" onclick="exportar();"> <img
							src="<fmt:message key="general.exportarRegistroSrc" />"
							height="30px"
							alt="<fmt:message key="general.exportarRegistroAlt" />"
							width="30px" />
						</a>
					</div>
				</div>

			</fieldset>

		</c:if>
	</form:form>
</div>