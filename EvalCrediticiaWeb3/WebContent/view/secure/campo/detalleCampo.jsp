<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>


<script language="javaScript" type="text/javascript">
	function ingresar() {

		jQuery("#frmCampo").attr("action", "ingresarCampo.do");
		jQuery("#frmCampo").submit();
	}

	function actualizar() {

		jQuery("#frmCampo").attr("action", "actualizarCampo.do");
		jQuery("#frmCampo").submit();
	}

	function volver() {

		jQuery("#frmCampo").attr("action", "listarCampo.do");
		jQuery("#frmCampo").submit();
	}
	
	function limpiar() {
		jQuery("#idNombreCampo").val("");
		jQuery("#idTipoCampo").val("");
		jQuery("#idTipoRegla").val("");
		jQuery("#idSubTipo").val("");
		jQuery("#idTipoDato").val("");
		jQuery("#idEstado").val("");
	}
	
	function limpiar2() {
		jQuery("#idTipoCampo").val("");
		jQuery("#idTipoRegla").val("");
		jQuery("#idSubTipo").val("");
		jQuery("#idTipoDato").val("");
		jQuery("#idEstado").val("");
	}
</script> 


<div class="body">

	<div class="titulo">
		<c:if test="${empty hasId}">
			<h1>
				<fmt:message key="campo.tituloNuevo" />
			</h1>
		</c:if>
		<c:if test="${!empty hasId}">
			<h1>
				<fmt:message key="campo.tituloEditar" />
			</h1>
		</c:if>
	</div>

	<form:form id="frmCampo" action="actualizarCampo.do" commandName="campoForm" method="POST">

		<spring:hasBindErrors name="campoForm">
			<div class="mensajeError">
				<form:errors path="*" />
			</div>
		</spring:hasBindErrors>

		<%@ include file="/mostrarErrores.jsp"%>

		<div class="grupoCampos">
		
			<form:hidden path="campoDetalleTO.codigoCampo"/>
			<form:hidden path="campoTO.nombreCampo"/>
			<form:hidden path="campoTO.tipoCampo"/>
			<form:hidden path="campoTO.codigoTipoRegla"/>
			<form:hidden path="campoTO.subTipo"/>
			<form:hidden path="campoTO.tipoDato"/>
			<form:hidden path="campoTO.estado"/>
				
			<c:if test="${!empty hasId}">
				<div class="campoSoloLectura">
					<form:label path="campoDetalleTO.nombreCampo">
						<fmt:message key="general.nombre" />:
					</form:label>
					<c:out value="${campoForm.campoDetalleTO.nombreCampo}"></c:out>
					<form:hidden path="campoDetalleTO.nombreCampo"></form:hidden>
				</div>
			</c:if>
			
			<c:if test="${empty hasId}">
				<div class="campoTexto">
					<form:label path="campoDetalleTO.nombreCampo">
						<fmt:message key="general.nombre" />:
						<em>*</em>
					</form:label>
					<form:input id="idNombreCampo" path="campoDetalleTO.nombreCampo" maxlength="50" ></form:input>
				</div>
			</c:if>

			<div class="campoCombo">
				<form:label path="campoDetalleTO.tipoCampo">
					<fmt:message key="general.tipoCampo" />:
					<em>*</em>
				</form:label>
				<form:select id="idTipoCampo" path="campoDetalleTO.tipoCampo">
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
				<form:label path="campoDetalleTO.codigoTipoRegla">
					<fmt:message key="campo.codigoTipoRegla" />:
					<em>*</em>
				</form:label>
				<form:select id="idTipoRegla" path="campoDetalleTO.codigoTipoRegla">
					<form:option value="" selected>
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${campoForm.lista}" itemLabel="nombre" itemValue="codigo" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="campoDetalleTO.subTipo">
					<fmt:message key="campo.subTipo" />
					<em>*</em>
				</form:label>
				<form:select id="idSubTipo" path="campoDetalleTO.subTipo">
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
				<form:label path="campoDetalleTO.tipoDato">
					<fmt:message key="general.tipoDato" />:
					<em>*</em>
				</form:label>
				<form:select id="idTipoDato" path="campoDetalleTO.tipoDato">
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
				<form:label path="campoDetalleTO.estado">
					<fmt:message key="general.estado" />:
					<em>*</em>
				</form:label>
				<form:select id="idEstado" path="campoDetalleTO.estado">
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

				<c:if test="${empty hasId}">
					<input class="barraBotones" type="submit" value="<fmt:message key="general.botonAgregar"/>" title='<fmt:message key="general.botonAgregar"/>' onclick="ingresar();" />
					<input class="barraBotones" type="button" value='<fmt:message key="general.botonLimpiar"/>' title='<fmt:message key="general.botonLimpiar"/>' onclick="limpiar();" />
				</c:if>
				
				<c:if test="${!empty hasId}">
					<input class="barraBotones" type="button" value="<fmt:message key="general.botonAgregar"/>" title='<fmt:message key="general.botonAgregar"/>' onclick="actualizar();" />
					<input class="barraBotones" type="button" value='<fmt:message key="general.botonLimpiar"/>' title='<fmt:message key="general.botonLimpiar"/>' onclick="limpiar2();" />
				</c:if>
				

				<input class="barraBotones" type="button"
					value='<fmt:message key="general.botonCancelar"/>'
					title='<fmt:message key="general.botonCancelar"/>'
					onclick="volver();" />
			</div>
			<br>		
		</div>
		
		<div class="mensajeRequerido">
			<p>
				<fmt:message key="general.mensajeRequerido" />
			</p>
		</div>		
	</form:form>
</div>