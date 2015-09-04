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
		jQuery("#frmReglaLogico").attr("action",
				"mostrarPaginaCondicionRegla.do");
		jQuery("#frmReglaLogico").submit();
	}
	function agregarCondicion() {
		if ($("#idTextArea")[0].value != "") {
			valor = $("#idTextArea").val().trim();
			newItem = jQuery('#idTrCondicion').clone();
			inc = $("tr", $('#idTablaCondicion')).length;
			newItem.attr('id', 'idTrCondicion' + inc);
			newItem.find('input').val(valor);
			jQuery('#idTablaCondicion tr:last').after(newItem);
			newItem.css('display', 'block');
		}
	}
	function eliminar(obj) {
		var eliminado = obj.parentNode.parentNode;
		$("#" + eliminado.id).remove();
	}
	function limpiar() {
		$("#idTextArea")[0].value = "";
	}
	function habilitarOpera() {
		$("#idAND")[0].disabled = false;
		$("#idOR")[0].disabled = false;
		$("#idNOT")[0].disabled = false;
		$("#idParD")[0].disabled = false;
		$("#idParI")[0].disabled = false;
	}
	function deshabilitarOpera() {
		$("#idAND")[0].disabled = false;
		$("#idOR")[0].disabled = false;
		$("#idNOT")[0].disabled = false;
		$("#idParD")[0].disabled = true;
		$("#idParI")[0].disabled = true;
	}
	function cargar(obj) {
		if ($("#idTextArea")[0].value != "") {
			$("#idTextArea")[0].value = $("#idTextArea")[0].value + " "
					+ obj.trim();
		} else {
			$("#idTextArea")[0].value = $("#idTextArea")[0].value + obj.trim();
		}
		habilitarOpera();
	}
	function opera(obj) {
		var result = $("#idTextArea")[0].value.trim();
		var opera = result.substring(result.length, result.length - 3);
		if (opera != "AND" && opera != "OR" && opera != "NOT" && opera != "(" && opera != ")") {
			$("#idTextArea")[0].value = $("#idTextArea")[0].value + " " + obj.value;
		}
	}
</script>

<div class="bodyExp">

	<div class="titulo">
		<h1>
			<fmt:message key="regla.tituloCondicion" />
		</h1>
	</div>

	<form:form id="frmReglaLogico" action="mostrarPaginaCondicionSalida.do" commandName="reglaForm" method="POST">

		<form:hidden path="reglaDetalleTO.nombre"/>
		<form:hidden path="reglaDetalleTO.tipoRegla"/>
		<form:hidden path="reglaDetalleTO.subtipoRegla"/>
		<form:hidden path="reglaDetalleTO.tipoEvaluacion"/>
		<form:hidden path="reglaDetalleTO.fechaVigenciaDesde"/>
		<form:hidden path="reglaDetalleTO.fechaVigenciaHasta"/>
		<form:hidden path="reglaDetalleTO.sinVigencia"/>
		<form:hidden path="reglaDetalleTO.estado"/>
		<form:hidden path="reglaDetalleTO.descripcion"/>
		
		<form:hidden path="condicionTO.campo.codigoCampo"/>
		<form:hidden path="condicionTO.operador"/>
		<form:hidden path="condicionTO.tipo"/>
		<form:hidden path="condicionTO.categoria.codigoCategoria"/>
		<form:hidden path="condicionTO.constante.codigo"/>
		<form:hidden path="condicionTO.valor"/>
		
		<form:hidden path="condiciones" />
		<form:hidden path="valorCondiciones" />

		<div class="grupoCamposExp">
			<table align="center">
				<tr>
					<td><div>
							<table id="idTabla" border="0" align="center">
								<tr>
									<td colspan="2">
										<div class="titulo">
											<h1>
												<fmt:message key="regla.condicion.agregadas" />
											</h1>
										</div></td>
								</tr>
							</table>
							<div align="center">
								<display:table name="reglaForm.cargaCondiciones" id="filaId">
									<display:column style="text-align: center;">
										<a href="javascript:void(0);"
											onclick="cargar('${filaId.codigo}');"> <img
											src="<fmt:message key="general.editarRegistroSrc" />"
											height="16px"
											alt="<fmt:message key="general.editarRegistroAlt" />"
											width="16px" /> </a>
									</display:column>
									<display:column property="codigo" />
								</display:table>
							</div>
						</div></td>
				</tr>
				<tr>
					<td>
						<div class="divBarraBotones">
							<table align="center">
								<tr>
									<td><input id="idAND" disabled="disabled"
										onclick="opera(this);" class="barraBotonesGrande"
										type="button" value="<fmt:message key="regla.logico.and"/>"
										title="<fmt:message key="regla.logico.and"/>" /></td>
									<td><input id="idOR" disabled="disabled"
										onclick="opera(this);" class="barraBotonesGrande"
										type="button" value="<fmt:message key="regla.logico.OR"/>"
										title="<fmt:message key="regla.logico.OR"/>" /></td>
									<td><input id="idNOT" disabled="disabled"
										onclick="opera(this);" class="barraBotonesGrande"
										type="button" value="<fmt:message key="regla.logico.NOT"/>"
										title="<fmt:message key="regla.logico.NOT"/>" /></td>
									<td><input id="idParD" disabled="disabled"
										onclick="opera(this);" class="barraBotonesGrande"
										type="button"
										value="<fmt:message key="regla.condicion.operador.("/>"
										title="<fmt:message key="regla.condicion.operador.("/>" /></td>
									<td><input id="idParI" disabled="disabled"
										onclick="opera(this);" class="barraBotonesGrande"
										type="button"
										value="<fmt:message key="regla.condicion.operador.)"/>"
										title="<fmt:message key="regla.condicion.operador.)"/>" /></td>
								</tr>
							</table>
							<br />
							<form:textarea id="idTextArea" path="condicionLogicoTO.valor"
								cols="50" rows="10" />
						</div></td>
				</tr>
			</table>
		</div>

		<br />
		<div class="divBarraBotones">
			<input onclick="volver();" class="barraBotonesGrande" type="button"
				value="<fmt:message key="general.botonAnterior"/>"
				title="<fmt:message key="general.botonAnterior"/>" /> <input
				onclick="limpiar();" class="barraBotones" type="button"
				value="<fmt:message key="general.botonLimpiar"/>"
				title="<fmt:message key="general.botonLimpiar"/>" /> <input
				class="barraBotones" type="submit"
				value="<fmt:message key="general.botonSiguiente"/>"
				title="<fmt:message key="general.botonSiguiente"/>" />
		</div>

	</form:form>
</div>