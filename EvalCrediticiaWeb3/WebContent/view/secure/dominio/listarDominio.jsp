<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript" language="javaScript">
	function nuevo() {
		jQuery("#frmDominioListar").attr("action", "nuevoDominio.do");
		jQuery("#frmDominioListar").submit();
	}

	function buscar() {
		jQuery("#frmDominioListar").attr("action", "buscarPorCampos.do");
		jQuery("#frmDominioListar").submit();
	}
	function exportar() {
		jQuery("#frmDominioListar").attr("action", "exportarDomExcel.do");
		jQuery("#frmDominioListar").submit();
	}
	function editar(id) {
		jQuery("#frmDominioListar").attr("action", "editarDominio.do");
		jQuery("#idCodigoDominio").val(id);
		jQuery("#frmDominioListar").submit();
	}

	function limpiar() {
		jQuery("#tipoCampoId").val("");
		jQuery("#nombreId").val("");
		jQuery("#tipoDatoId").val("");
		jQuery("#valorId").val("");
		jQuery("#estadoId").val("");
	}
					
</script>

<div class="body">

	<div class="titulo">
		<h1>
			<fmt:message key="dominio.tituloListar" />
		</h1>
	</div>

	<!-- Pagina de control de errores en el encabezado -->
	<%@ include file="/mostrarErrores.jsp"%>
	<!-- fin Pagina de control de errores en el encabezado -->

	<form:form id="frmDominioListar" action="buscarPorCampos.do"
		commandName="dominioForm" method="POST">
		<div class="grupoCampos">

			<form:hidden id="idCodigoDominio" path="dominioDetalleTO.codigo" />

			<div class="campoCombo">
				<form:label path="dominioTO.tipoCampo">
					<fmt:message key="general.tipo.Campo" />:
				</form:label>
				<form:select id="tipoCampoId" path="dominioTO.tipoCampo">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="E">
						<fmt:message key="general.entrada" />
					</form:option>
					<form:option value="S">
						<fmt:message key="general.salida" />
					</form:option>
				</form:select>
			</div>

			<div class="campoTexto">
				<form:label path="dominioTO.nombre">
					<fmt:message key="general.codigo" />:
				</form:label>
				<form:input id="nombreId" path="dominioTO.nombre" maxlength="50"></form:input>
			</div>
			

			<div class="campoCombo">
				<form:label path="dominioTO.tipoDato">
					<fmt:message key="general.tipoDato" />:
					</form:label>
				<form:select id="tipoDatoId" path="dominioTO.tipoDato" disabled="false">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="A">
						<fmt:message key="general.tipo.alfanumerico" />
					</form:option>
					<form:option value="N">
						<fmt:message key="general.tipo.numerico" />
					</form:option>
				</form:select>
			</div>

			<div class="campoTexto">
				<form:label path="dominioTO.valor">
					<fmt:message key="general.valor" />:
				</form:label>
				<form:input id="valorId" path="dominioTO.valor" maxlength="100"></form:input>
			</div>

			<div class="campoCombo">
				<form:label path="dominioTO.estado">
					<fmt:message key="general.estado" />:
				</form:label>
				<form:select id="estadoId" path="dominioTO.estado">
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
				<input onclick="buscar();" class="barraBotones" type="submit" value="<fmt:message key="general.botonBuscar"/>" title='<fmt:message key="general.botonBuscar"/>' /> 
					<input class="barraBotones" type="button" value='<fmt:message key="general.botonLimpiar"/>' title='<fmt:message key="general.botonLimpiar"/>' onclick="limpiar();" /> 
					<input onclick="nuevo();" class="barraBotones" type="button" value="<fmt:message key="general.botonAgregar"/>" title='<fmt:message key="general.botonAgregar"/>' />
			</div>
		</div>


		<c:if test="${fn:length(dominioForm.resultados)>0}">
			<fieldset class="grupoCampos">
				<legend>
					<fmt:message key="general.resultado.busquedas" />
				</legend>

				<div class="tabla">
					<div id="displayTagDiv">
						<display:table name="dominioForm.resultados" id="filaId"
							requestURI="listarDominios.do?reload=false" pagesize="20">

							<display:column style="text-align: center;">
								<a href="javascript:void(0);"
									onclick="javascript:editar('${filaId.codigo}');"> <img
									src="<fmt:message key="general.editarRegistroSrc" />"
									height="16px"
									alt="<fmt:message key="general.editarRegistroAlt" />"
									width="16px" /> </a>
							</display:column>

							<display:column property="nombre" titleKey="general.codigo" />
							<display:column property="valor" titleKey="general.valor" />
							<display:column property="estado" titleKey="general.estado" />
							<display:column property="tipoDato" titleKey="general.tipoDato" />
							<display:column property="tipoCampo" titleKey="general.tipo.Campo" />

						</display:table>
					</div>
				</div>
				<div style="text-align: center;">
					<a href="javascript:void(0)" onclick="javascript:exportar();">
						<img src="<fmt:message key="general.exportarRegistroSrc" />" height="30px" alt="<fmt:message key="general.exportarRegistroAlt" />" width="30px" /> 
					</a>
				</div>
			</fieldset>
		</c:if>
	</form:form>
</div>
