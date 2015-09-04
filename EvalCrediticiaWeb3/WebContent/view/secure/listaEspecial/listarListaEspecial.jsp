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
		jQuery("#frmListaEspecialListar").attr("action", "nuevaListaEspecial.do");
		jQuery("#frmListaEspecialListar").submit();
	}

	function exportar() {
		jQuery("#frmListaEspecialListar").attr("action", "exportarLisExcel.do");
		jQuery("#frmListaEspecialListar").submit();
	}

	function listar() {
		jQuery("#frmListaEspecialListar").attr("action",
				"listarListasEspeciales.do");
		jQuery("#frmListaEspecialListar").submit();
	}
	
	function limpiar() {
		
		jQuery("#listaEspecialTO\\.nombreListaEspecial").val("");
		jQuery("#idComboConcepto").val("");
		jQuery("#idComboLista").val("");
		jQuery("#listaEspecialTO\\.campoConsulta").val("");
		jQuery("#listaEspecialTO\\.campoResultado").val("");
		jQuery("#listaEspecialTO\\.valorDefecto").val("");
		jQuery("#listaEspecialTO\\.stado").val("");
		
	}	

	function editar(id) {
		jQuery("#frmListaEspecialListar").attr("action", "editarListaEspecial.do");
		jQuery("#idNombreLE").val(id);
		jQuery("#frmListaEspecialListar").submit();
	}
	function cambiarLista() {
		$("#idComboLista").empty();
		$("#idComboLista").append("<option value=''> -- Seleccione una Opción -- </option>");
		$.ajax({
			url : "cargarComboTipoLista.do",
			data : "concepto=" + $("#idComboConcepto")[0].value,
			success : function(datos) {
				for ( var i = 0; i < datos.length; i++) {
					$("#idComboLista").empty();
					$("#idComboLista").append("<option value=''> -- Seleccione una Opción -- </option>");
					$("#idComboLista").append(
							"<option value='" + datos[i].codigo + "'>"
									+ datos[i].nombre + "</option>");
				}
			}
		});
	}
</script>
<div class="body">

	<div class="titulo">
		<h1>
			<fmt:message key="listaEspecial.tituloListar" />
		</h1>
	</div>
	<!-- Pagina de control de errores en el encabezado -->
	<%@ include file="/mostrarErrores.jsp"%>
	<!-- fin Pagina de control de errores en el encabezado -->

	<form:form id="frmListaEspecialListar" action="listarListasEspeciales.do" commandName="listaEspecialForm"
		method="POST">

		<div class="grupoCampos">

			<form:hidden id="idNombreLE"
				path="listaEspecialDetalleTO.nombreListaEspecial" />

			<div class="campoTexto">
				<form:label path="listaEspecialTO.nombreListaEspecial">
					<fmt:message key="general.nombre" />:
				</form:label>
				<form:input path="listaEspecialTO.nombreListaEspecial"
					maxlength="50"></form:input>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialTO.valorConcepto">
					<fmt:message key="listaEspecial.valorConcepto" />:
				</form:label>
				<form:select path="listaEspecialTO.valorConcepto"
					id="idComboConcepto" onchange="cambiarLista();">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${listaEspecialForm.comboConcepto}"
						itemLabel="nombreConcepto" itemValue="idConcepto" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialTO.tipoLista">
					<fmt:message key="listaEspecial.tipoLista" />:
				</form:label>
				<form:select path="listaEspecialTO.tipoLista" id="idComboLista">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialTO.campoConsulta">
					<fmt:message key="listaEspecial.campoConsulta" />:
				</form:label>
				<form:select path="listaEspecialTO.campoConsulta">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${listaEspecialForm.comboConsulta}"
						itemLabel="nombreCampo" itemValue="codigoCampo" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialTO.campoResultado">
					<fmt:message key="listaEspecial.campoResultado" />:
				</form:label>
				<form:select path="listaEspecialTO.campoResultado">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${listaEspecialForm.comboResultado}"
						itemLabel="nombreCampo" itemValue="codigoCampo" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialTO.valorDefecto">
					<fmt:message key="listaEspecial.valorDefecto" />:
				</form:label>
				<form:select path="listaEspecialTO.valorDefecto">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="OK">
						<fmt:message key="general.valorDefecto.ok" />
					</form:option>
					<form:option value="NO">
						<fmt:message key="general.valorDefecto.nok" />
					</form:option>
					<form:option value="SN">
						<fmt:message key="general.valorDefecto.sinRta" />
					</form:option>
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialTO.stado">
					<fmt:message key="general.estado" />:
				</form:label>
				<form:select path="listaEspecialTO.stado">
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
		</div>

		<br>
		<div class="divBarraBotones">
			<input class="barraBotones" onclick="listar();" type="button"
				value="<fmt:message key="general.botonBuscar"/>"
				title='<fmt:message key="general.botonBuscar"/>' /> 
				
				<input onclick="limpiar(); return false;" class="barraBotones" type="submit"
				value="<fmt:message key="general.botonLimpiar"/>"
				title='<fmt:message key="general.botonLimpiar"/>'/>

				<input onclick="nuevo();" class="barraBotones" type="reset"
				value="<fmt:message key="general.botonAgregar"/>"
				title='<fmt:message key="general.botonAgregar"/>'/>
		</div>
		<br>

		<c:if test="${fn:length(listaEspecialForm.resultados)>0}">

			<fieldset class="grupoCampos">
				<legend>
					<fmt:message key="general.resultado.busquedas" />
				</legend>

				<div class="tabla">

					<display:table name="listaEspecialForm.resultados" id="filaId"
						requestURI="listarListasEspeciales.do?reload=false" pagesize="20">

						<display:column style="text-align: center;">
							<a href="javascript:void(0);"
								onclick="editar('${filaId.nombreListaEspecial}');"> <img
								src="<fmt:message key="general.editarRegistroSrc" />"
								height="16px"
								alt="<fmt:message key="general.editarRegistroAlt" />"
								width="16px" /> </a>
						</display:column>

						<display:column property="nombreListaEspecial"
							titleKey="general.nombre" />
						<display:column property="nombreConcepto"
							titleKey="listaEspecial.valorConcepto" />
						<display:column property="nombreLista"
							titleKey="listaEspecial.tipoLista" />
						<display:column property="nombreCampoConsulta"
							titleKey="listaEspecial.campoConsulta" />
						<display:column property="nombreCampoResultado"
							titleKey="listaEspecial.campoResultado" />
						<display:column property="valorDefecto"
							titleKey="listaEspecial.valorDefecto" />
						<display:column property="nombreEstado" titleKey="general.estado" />

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