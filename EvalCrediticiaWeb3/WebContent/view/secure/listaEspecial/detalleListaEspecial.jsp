<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>


<script language="javaScript" type="text/javascript">
	function ingresar() {
		jQuery("#frmListaEspecial").attr("action", "ingresarListaEspecial.do");
		jQuery("#frmListaEspecial").submit();
	}
	function actualizar() {
		jQuery("#frmListaEspecial")
				.attr("action", "actualizarListaEspecial.do");
		jQuery("#frmListaEspecial").submit();
	}
	function volver() {
		jQuery("#frmListaEspecial").attr("action", "listarListasEspeciales.do");
		jQuery("#frmListaEspecial").submit();
	}

	function limpiar() {
		jQuery("#listaEspecialDetalleTO\\.nombreListaEspecial").val("");
		jQuery("#listaEspecialTO\\.nombreListaEspecial").val("");
		jQuery("#idComboConcepto").val("");
		jQuery("#idComboLista").val("");
		jQuery("#listaEspecialDetalleTO\\.campoConsulta").val("");
		jQuery("#listaEspecialDetalleTO\\.campoConsulta").val("");
		jQuery("#listaEspecialDetalleTO\\.valorDefecto").val("");
		jQuery("#listaEspecialDetalleTO\\.stado").val("");
		jQuery("#listaEspecialDetalleTO\\.campoResultado").val("");
		
		
	}

	function cambiarLista() {
		$("#idComboLista").empty();
		$("#idComboLista").append(
				"<option value=''> -- Seleccione una Opción -- </option>");
		$
				.ajax({
					url : "cargarComboTipoLista.do",
					data : "concepto=" + $("#idComboConcepto")[0].value,
					success : function(datos) {
						for ( var i = 0; i < datos.length; i++) {
							$("#idComboLista").empty();
							$("#idComboLista")
									.append(
											"<option value=''> -- Seleccione una Opción -- </option>");
							$("#idComboLista").append(
									"<option value='" + datos[i].codigo + "'>"
											+ datos[i].nombre + "</option>");
						}
					}
				});
	}

	$(document).ready(
			function() {
				$("#idComboLista").change(
						function() {
							$("#listaEspecialDetalleTO\\.nombreLista").val(
									$("#idComboLista").find("option:selected")
											.text());
						});
			});

	$(document).ready(
			function() {
				$("#idComboConcepto").change(
						function() {
							$("#listaEspecialDetalleTO\\.nombreConcepto").val(
									$("#idComboConcepto").find(
											"option:selected").text());
						});
			});
</script>
<div class="body">

	<div class="titulo">
		<c:if test="${empty hasId}">
			<h1>
				<fmt:message key="listaEspecial.tituloNuevo" />
			</h1>
		</c:if>
		<c:if test="${!empty hasId}">
			<h1>
				<fmt:message key="listaEspecial.tituloEditar" />
			</h1>
		</c:if>
	</div>

	<form:form id="frmListaEspecial" action="actualizarListaEspecial.do"
		commandName="listaEspecialForm" method="POST">

		<spring:hasBindErrors name="listaEspecialForm">
			<div class="mensajeError">
				<form:errors path="*" />
			</div>
		</spring:hasBindErrors>

		<%@ include file="/mostrarErrores.jsp"%>

		<div class="grupoCampos">

			<form:hidden path="listaEspecialTO.nombreListaEspecial" />

			<form:hidden path="listaEspecialDetalleTO.nombreLista" />
			<form:hidden path="listaEspecialDetalleTO.nombreConcepto" />

			<form:hidden path="listaEspecialTO.valorConcepto" />
			<form:hidden path="listaEspecialTO.tipoLista" />
			<form:hidden path="listaEspecialTO.campoConsulta" />
			<form:hidden path="listaEspecialTO.campoResultado" />
			<form:hidden path="listaEspecialTO.valorDefecto" />
			<form:hidden path="listaEspecialTO.stado" />

			<c:if test="${!empty hasId}">
				<div class="campoSoloLectura">
					<form:label path="listaEspecialDetalleTO.nombreListaEspecial">
						<fmt:message key="general.nombre" />:
						<em>*</em>
					</form:label>
					<form:input path="listaEspecialDetalleTO.nombreListaEspecial"
						maxlength="50" readonly="true"></form:input>
				</div>

			</c:if>
			<c:if test="${empty hasId}">
				<div class="campoTexto">
					<form:label path="listaEspecialDetalleTO.nombreListaEspecial">
						<fmt:message key="general.nombre" />:
						<em>*</em>
					</form:label>
					<form:input path="listaEspecialDetalleTO.nombreListaEspecial"
						maxlength="50"></form:input>
				</div>
			</c:if>

			<div class="campoCombo">
				<form:label path="listaEspecialDetalleTO.valorConcepto">
					<fmt:message key="listaEspecial.valorConcepto" />:
					<em>*</em>
				</form:label>
				<form:select id="idComboConcepto"
					path="listaEspecialDetalleTO.valorConcepto"
					onchange="cambiarLista();">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${listaEspecialForm.comboConcepto}"
						itemLabel="nombreConcepto" itemValue="idConcepto" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialDetalleTO.tipoLista">
					<fmt:message key="listaEspecial.tipoLista" />:
					<em>*</em>
				</form:label>
				<form:select path="listaEspecialDetalleTO.tipoLista"
					id="idComboLista">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>

					<form:options items="${listaEspecialForm.comboLista}"
						itemLabel="nombreLista" itemValue="idLista" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialDetalleTO.campoConsulta">
					<fmt:message key="listaEspecial.campoConsulta" />:
					<em>*</em>
				</form:label>
				<form:select path="listaEspecialDetalleTO.campoConsulta">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${listaEspecialForm.comboConsulta}"
						itemLabel="nombreCampo" itemValue="codigoCampo" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialDetalleTO.campoResultado">
					<fmt:message key="listaEspecial.campoResultado" />:
					<em>*</em>
				</form:label>
				<form:select path="listaEspecialDetalleTO.campoResultado">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${listaEspecialForm.comboResultado}"
						itemLabel="nombreCampo" itemValue="codigoCampo" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="listaEspecialDetalleTO.valorDefecto">
					<fmt:message key="listaEspecial.valorDefecto" />:
					<em>*</em>
				</form:label>
				<form:select path="listaEspecialDetalleTO.valorDefecto">
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
				<form:label path="listaEspecialDetalleTO.stado">
					<fmt:message key="general.estado" />:
					<em>*</em>
				</form:label>
				<form:select path="listaEspecialDetalleTO.stado">
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

				<c:if test="${empty hasId}">
					<input class="barraBotones" type="submit"
						value="<fmt:message key="general.botonAgregar"/>"
						title='<fmt:message key="general.botonAgregar"/>'
						onclick="ingresar();" />
				</c:if>
				<c:if test="${!empty hasId}">
					<input class="barraBotones" type="submit"
						value="<fmt:message key="general.botonModificar"/>"
						title='<fmt:message key="general.botonModificar"/>'
						onclick="actualizar();" />
				</c:if>

				<input class="barraBotones" type="button"
					value='<fmt:message key="general.botonLimpiar"/>'
					title='<fmt:message key="general.botonLimpiar"/>'
					onclick="limpiar();" /> <input class="barraBotones" type="submit"
					value='<fmt:message key="general.botonCancelar"/>'
					title='<fmt:message key="general.botonCancelar"/>'
					onclick="volver();" />
			</div>
			<br>
		</div>

	</form:form>

</div>