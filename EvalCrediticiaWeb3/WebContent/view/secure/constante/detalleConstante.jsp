<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>


<script language="javaScript" type="text/javascript">
	function ingresar() {

		jQuery("#frmConstante").attr("action", "ingresarConstante.do");
		jQuery("#frmConstante").submit();
	}

	function actualizar() {

		jQuery("#frmConstante").attr("action", "actualizarConstante.do");
		jQuery("#frmConstante").submit();
	}

	function volver() {

		jQuery("#frmConstante").attr("action", "listarConstante.do");
		jQuery("#frmConstante").submit();
	}
	function limpiar() {
		jQuery("#idCodigo").val("");
		jQuery("#idNombre").val("");
		jQuery("#idTipo").val("");
		jQuery("#idEstado").val("");
		jQuery("#idValor").val("");
	}
</script>



<div class="body">

	<div class="titulo">
		<c:if test="${empty hasId}">
			<h1>
				<fmt:message key="constante.tituloNuevo" />
			</h1>
		</c:if>
		<c:if test="${!empty hasId}">
			<h1>
				<fmt:message key="constante.tituloEditar" />
			</h1>
		</c:if>
	</div>

	<form:form id="frmConstante" action="actualizarConstante.do"
		commandName="constanteForm" method="POST">

		<spring:hasBindErrors name="constanteForm">
			<div class="mensajeError">
				<form:errors path="*" />
			</div>
		</spring:hasBindErrors>

		<%@ include file="/mostrarErrores.jsp"%>

		<div class="grupoCampos">
			<form:hidden path="constanteDetalleTO.codigo" />
			<form:hidden path="constanteTO.nombre" />
			<form:hidden path="constanteTO.tipo" />
			<form:hidden path="constanteTO.estado" />
			<form:hidden path="constanteTO.valor" />

			<c:if test="${!empty hasId}">
				<div class="campoTexto">
					<form:label path="constanteDetalleTO.nombre"><fmt:message key="general.codigo" />:<em>*</em></form:label>
					<form:input path="constanteDetalleTO.nombre" maxlength="12" disabled="true"></form:input>
					<form:hidden path="constanteDetalleTO.nombre" ></form:hidden>
				</div>
			</c:if>

			<c:if test="${empty hasId}">
				<div class="campoTexto">
					<form:label path="constanteDetalleTO.nombre"><fmt:message key="general.codigo" />:<em>*</em></form:label>
					<form:input id="idNombre" path="constanteDetalleTO.nombre" maxlength="12"></form:input>
				</div>
			</c:if>


			<div class="campoCombo">
				<form:label path="constanteDetalleTO.tipo">
					<fmt:message key="general.tipoDato" />:
					<em>*</em>
				</form:label>

				<c:if test="${empty hasId}">
					<form:select id="idTipo" path="constanteDetalleTO.tipo">
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
				</c:if>
				<c:if test="${!empty hasId}">
					<form:hidden path="constanteDetalleTO.tipo" />
					<form:select id="idTipo" path="constanteDetalleTO.tipo"
						disabled="true">
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
				</c:if>
			</div>
		<!-- jamj 
			<div class="campoCombo">
				<form:label path="constanteDetalleTO.estado">
					<fmt:message key="general.estado" />:
						<em>*</em>
				</form:label>
				<form:select id="idEstado" path="constanteDetalleTO.estado">
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
				<form:label path="constanteDetalleTO.valor">
					<fmt:message key="general.valor" />:
					<em>*</em>
				</form:label>
				<form:input id="idValor" path="constanteDetalleTO.valor"
					maxlength="10"></form:input>
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
					<input class="barraBotones" type="button"
						value="<fmt:message key="general.botonAgregar"/>"
						title='<fmt:message key="general.botonAgregar"/>'
						onclick="actualizar();" />
				</c:if>
				<input class="barraBotones" type="button"
					value='<fmt:message key="general.botonLimpiar"/>'
					title='<fmt:message key="general.botonLimpiar"/>'
					onclick="limpiar();" /> <input class="barraBotones" type="button"
					value='<fmt:message key="general.botonCancelar"/>'
					title='<fmt:message key="general.botonCancelar"/>'
					onclick="volver();" />
			</div>
			<br>
		</div>
	</form:form>
</div>