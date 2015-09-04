<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script language="javaScript" type="text/javascript">
	function nuevo() {
		jQuery("#frmCategoriaListar").attr("action", "nuevoCategoria.do");
		jQuery("#frmCategoriaListar").submit();
	}
	function buscar() {
		
		jQuery("#nombreCampoId").val(jQuery("#campoId option:selected").text());
		jQuery("#frmCategoriaListar").attr("action", "listarCategorias.do");
		jQuery("#frmCategoriaListar").submit();
	}

	function exportar() {
		jQuery("#frmCategoriaListar").attr("action", "exportarCatExcel.do");
		jQuery("#frmCategoriaListar").submit();
	}

	function editar(id) {
		jQuery("#frmCategoriaListar").attr("action", "editarCategoria.do");
		jQuery("#idCodigoCategoria").val(id);
		jQuery("#frmCategoriaListar").submit();
	}
	
	function limpiar() {
		jQuery("#nombreCategoriaId").val("");
		jQuery("#tipoId").val("");
		jQuery("#campoId").val("");
		jQuery("#tipoCategoriaId").val("");
		jQuery("#nombreCampoId").val();
	}	

	function cargar() {
		jQuery("#frmCategoriaListar").attr("action", "cargar.do?reload=false");
		jQuery("#frmCategoriaListar").submit();
	}
</script>

<div class="body">

	<div class="titulo">
		<h1>
			<fmt:message key="categoria.tituloListar" />
		</h1>
	</div>
	<!-- Pagina de control de errores en el encabezado -->
	<%@ include file="/mostrarErrores.jsp"%>
	<!-- fin Pagina de control de errores en el encabezado -->

	<form:form id="frmCategoriaListar" action="listarCategorias.do" commandName="categoriaForm" method="POST">

		<div class="grupoCampos">
			<form:hidden id="idCodigoCategoria" path="categoriaDetalleTO.codigoCategoria" />
			<form:hidden id="nombreCampoId" path="categoriaTO.nombreCampo" />
			
			<form:hidden path="cambioPantalla" />

			<div class="campoTexto">
				<form:label path="categoriaTO.nombreCategoria">
					<fmt:message key="general.codigo" />:
				</form:label>
				<form:input id="nombreCategoriaId" path="categoriaTO.nombreCategoria" maxlength="30"></form:input>
			</div>

			<div class="campoCombo">
				<form:label path="tipo">
					<fmt:message key="general.tipo" />:
				</form:label>
				<form:select id="tipoId" path="tipo" onchange="cargar();">
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
				<form:label path="categoriaTO.codigoCampo">
					<fmt:message key="general.tipoCampo" />:
				</form:label>
				<form:select id="campoId" path="categoriaTO.codigoCampo">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${categoriaForm.listaComboCampo}"
						itemLabel="nombreCampo" itemValue="codigoCampo" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="categoriaTO.tipoCategoria">
					<fmt:message key="general.tipoDato" />:
				</form:label>
				<form:select id="tipoCategoriaId" path="categoriaTO.tipoCategoria">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="V">
						<fmt:message key="categoria.tipo.valor" />
					</form:option>
					<form:option value="L">
						<fmt:message key="categoria.tipo.lista" />
					</form:option>
					<form:option value="R">
						<fmt:message key="categoria.tipo.rango" />
					</form:option>
				</form:select>
			</div>

		<br>
		<div class="divBarraBotones">
			<input onclick="buscar();" class="barraBotones" type="submit" value="<fmt:message key="general.botonBuscar"/>" title='<fmt:message key="general.botonBuscar"/>' /> 
			<input onclick="limpiar();" class="barraBotones" type="button" value='<fmt:message key="general.botonLimpiar"/>' title='<fmt:message key="general.botonLimpiar"/>' />				
			<input onclick="nuevo();" class="barraBotones" type="button" value="<fmt:message key="general.botonAgregar"/>" title='<fmt:message key="general.botonAgregar"/>' />
		</div>

		<c:if test="${fn:length(categoriaForm.resultados)>0}">
			<fieldset class="grupoCampos">
				<legend>
					<fmt:message key="general.resultado.busquedas" />
				</legend>

				<div class="tabla">
					<div id="displayTagDiv">
						<display:table name="categoriaForm.resultados" id="filaId"
							requestURI="listarCategorias.do?reload=false" pagesize="20">

							<display:column style="text-align: center;">
								<a href="javascript:void(0);"
									onclick="editar('${filaId.codigoCategoria}');"> <img
									src="<fmt:message key="general.editarRegistroSrc" />"
									height="16px"
									alt="<fmt:message key="general.editarRegistroAlt" />"
									width="16px" /> </a>
							</display:column>

							<display:column property="nombreCategoria"	titleKey="general.codigo" />
							<display:column property="nombreCampo" titleKey="general.campo" />
							<display:column property="tipoCategoria" titleKey="general.tipoDato" />

						</display:table>

					</div>
				</div>
				<div style="text-align: center;">
					<a href="javascript:void(0);" onclick="exportar();"> <img
						src="<fmt:message key="general.exportarRegistroSrc" />"
						height="30px"
						alt="<fmt:message key="general.exportarRegistroAlt" />"
						width="30px" /> </a>
				</div>
			</fieldset>
		</c:if>
		</div>
	</form:form>
</div>