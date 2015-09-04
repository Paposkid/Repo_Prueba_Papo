<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script language="javaScript" type="text/javascript">
	function nuevo() {
		jQuery("#frmConstanteListar").attr("action", "nuevaConstante.do");
		jQuery("#frmConstanteListar").submit();
	}
	function exportar() {
		jQuery("#frmConstanteListar").attr("action", "exportarConstExcel.do");
		jQuery("#frmConstanteListar").submit();
	}
	function listar() {
		jQuery("#frmConstanteListar").attr("action", "listarConstante.do");
	}
	function editar(id) {
		jQuery("#frmConstanteListar").attr("action", "editarConstante.do");
		jQuery("#idCodigoDetalle").val(id);
		jQuery("#frmConstanteListar").submit();
	}
	
	function limpiar() {
		jQuery("#constanteTO\\.codigo").val("");
		jQuery("#constanteTO\\.nombre").val("");
		jQuery("#constanteTO\\.tipo").val("");		
		jQuery("#constanteTO\\.estado").val("");
		jQuery("#constanteTO\\.valor").val("");		
		
		jQuery("#tipo").val("");
	}		
</script>

<div class="body">

	<div class="titulo">
		<h1>
			<fmt:message key="constante.tituloListar" />
		</h1>
	</div>
	<!-- Pagina de control de errores en el encabezado -->
	<%@ include file="/mostrarErrores.jsp"%>
	<!-- fin Pagina de control de errores en el encabezado -->

	<form:form id="frmConstanteListar" commandName="constanteForm"
		action="listarConstante.do" method="POST">

		<form:hidden id="idCodigoDetalle" path="constanteDetalleTO.codigo" />
		<div class="grupoCampos">

			<div class="campoTexto">
				<form:label path="constanteTO.nombre">
					<fmt:message key="general.codigo" />:
				</form:label>
				<form:input path="constanteTO.nombre" maxlength="50"></form:input>
			</div>

			<div class="campoCombo">
				<form:label path="constanteTO.tipo">
					<fmt:message key="general.tipoDato" />:
				</form:label>
				<form:select path="constanteTO.tipo">
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
			<!--  jamj
			<div class="campoCombo">
				<form:label path="constanteTO.estado">
					<fmt:message key="general.estado" />:
				</form:label>
				<form:select path="constanteTO.estado">
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

			<div class="campoTexto">
				<form:label path="constanteTO.valor">
					<fmt:message key="general.valor" />:
				</form:label>
				<form:input path="constanteTO.valor" maxlength="10"></form:input>
			</div>

		</div>

		<br>
		<div class="divBarraBotones">
			<input class="barraBotones" onclick="listar();" type="submit"
				value="<fmt:message key="general.botonBuscar"/>"
				title='<fmt:message key="general.botonBuscar"/>' /> 
				
			<input onclick="limpiar();" class="barraBotones" type="button"
				value='<fmt:message key="general.botonLimpiar"/>'
				title='<fmt:message key="general.botonLimpiar"/>' />				
				
				
				<input
				onclick="nuevo();" class="barraBotones" type="submit"
				value="<fmt:message key="general.botonAgregar"/>"
				title='<fmt:message key="general.botonAgregar"/>' />
		</div>
		<br>

		<c:if test="${fn:length(constanteForm.resultados)>0}">

			<fieldset class="grupoCampos">
				<legend>
					<fmt:message key="general.resultado.busquedas" />
				</legend>


				<div class="tabla">

					<display:table name="constanteForm.resultados" id="filaId"
						requestURI="listarConstante.do?reload=false" pagesize="20">

						<display:column style="text-align: center;">
							<a href="javascript:void(0);"
								onclick="editar('${filaId.codigo}');"> <img
								src="<fmt:message key="general.editarRegistroSrc" />"
								height="16px"
								alt="<fmt:message key="general.editarRegistroAlt" />"
								width="16px" /> </a>
						</display:column>
  
						<display:column property="nombre" titleKey="general.codigo" />
						<display:column property="tipo" titleKey="general.tipo" />
						<display:column property="valor" titleKey="general.valor" />

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