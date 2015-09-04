<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script language="javaScript" type="text/javascript">
	function exportar() {
		jQuery("#frmCampoListar").attr("action", "exportarCampExcel.do");
		jQuery("#frmCampoListar").submit();
	}

	function nuevo() {
		jQuery("#frmCampoListar").attr("action", "nuevoCampo.do");
		jQuery("#frmCampoListar").submit();
	}

	function listar() {
		jQuery("#frmCampoListar").attr("action", "listarCampo.do");
	}

	function editar(id) {
		jQuery("#frmCampoListar").attr("action", "editarCampo.do");
		jQuery("#codigoCampoId").val(id);
		jQuery("#frmCampoListar").submit();
	}
</script>

<div class="body">
	<div class="titulo">
		<h1>
			<fmt:message key="campo.tituloListar" />
		</h1>
	</div>

	<!-- Pagina de control de errores en el encabezado -->
	<%@  include file="/mostrarErrores.jsp"%>
	<!-- fin Pagina de control de errores en el encabezado -->

	<form:form id="frmCampoListar" action="listarCampo.do" commandName="campoForm" method="POST">
		<div class="grupoCampos">
			
			<form:hidden id="codigoCampoId" path="campoDetalleTO.codigoCampo"/>

			<div class="campoTexto">
				<form:label path="campoTO.nombreCampo">
					<fmt:message key="general.nombre" />:
				</form:label>
				<form:input id="nombreCampoId" path="campoTO.nombreCampo" maxlength="50"></form:input>
			</div>

			<div class="campoCombo">
				<form:label path="campoTO.tipoCampo">
					<fmt:message key="general.tipoCampo" />:
				</form:label>
				<form:select id="tipoCampoId" path="campoTO.tipoCampo">
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

			<div class="campoCombo">
				<form:label path="campoTO.codigoTipoRegla">
					<fmt:message key="campo.codigoTipoRegla" />:
				</form:label>
				<form:select id="codigoTipoReglaId" path="campoTO.codigoTipoRegla">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${campoForm.lista}" itemLabel="nombre" itemValue="codigo" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="campoTO.subTipo">
					<fmt:message key="campo.subTipo" />:
				</form:label>
				<form:select id="subTipoId" path="campoTO.subTipo">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="S">
						<fmt:message key="campo.simple" />
					</form:option>
					<form:option value="M">
						<fmt:message key="campo.multiple" />
					</form:option>
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="campoTO.tipoDato">
					<fmt:message key="general.tipoDato" />:
				</form:label>
				<form:select id="tipoDatoId" path="campoTO.tipoDato">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="N">
						<fmt:message key="general.tipo.numerico" />
					</form:option>
					<form:option value="A">
						<fmt:message key="general.tipo.alfanumerico" />
					</form:option>
				</form:select>
			</div>
		<!-- jamj 
			<div class="campoCombo">
				<form:label path="campoTO.estado">
					<fmt:message key="general.estado" />:
				</form:label>
				<form:select id="estadoId" path="campoTO.estado">
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
			</div>-->

			<br>
			<div class="divBarraBotones">
				<input onclick="listar();" class="barraBotones" type="submit"
					value="<fmt:message key="general.botonBuscar"/>"
					title='<fmt:message key="general.botonBuscar"/>' /> <input
					onclick="nuevo();" class="barraBotones" type="button"
					value="<fmt:message key="general.botonAgregar"/>"
					title='<fmt:message key="general.botonAgregar"/>' />
			</div>
		</div>

		<br>
		<c:if test="${fn:length(campoForm.resultados)>0}">
			<fieldset class="grupoCampos">
				<legend>
					<fmt:message key="general.resultado.busquedas" />
				</legend>

				<div class="tabla">
					<div id="displayTagDiv">
						<display:table name="campoForm.resultados" id="filaId" requestURI="listarCampo.do?reload=false" pagesize="20">

							<display:column style="text-align: center;">
								<a href="javascript:void(0);"
									onclick="editar('${filaId.codigoCampo}');"> <img
									src="<fmt:message key="general.editarRegistroSrc" />"
									height="16px"
									alt="<fmt:message key="general.editarRegistroAlt" />"
									width="16px" /> </a>
							</display:column>
							<display:column property="codigoCampo" titleKey="general.codigo" />
							<display:column property="nombreCampo" titleKey="general.nombre" />
							<display:column property="tipoCampo" titleKey="general.tipoCampo" />
							<display:column property="nombreTipoRegla" titleKey="campo.codigoTipoRegla" />
							<display:column property="subTipo" titleKey="campo.subTipo" />
							<display:column property="tipoDato" titleKey="general.tipoDato" />
							
						</display:table>

						<div style="text-align: center;">
							<a href="javascript:void(0);" onclick="exportar();"> <img
								src="<fmt:message key="general.exportarRegistroSrc" />"
								height="30px"
								alt="<fmt:message key="general.exportarRegistroAlt" />"
								width="30px" /></a>
						</div>
					</div>
				</div>
			</fieldset>
		</c:if>
	</form:form>
</div>