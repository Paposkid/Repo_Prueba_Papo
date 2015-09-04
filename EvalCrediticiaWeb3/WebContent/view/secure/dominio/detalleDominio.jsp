<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script language="javaScript" type="text/javascript">
	function volver() {
		jQuery("#frmDominioDetalle").attr("action", "listarDominios.do");
		jQuery("#frmDominioDetalle").submit();
	}

	function modificar() {

		jQuery("#frmDominioDetalle").attr("action", "modificarDominio.do");
		jQuery("#frmDominioDetalle").submit();
	}

	function limpiar() {
		jQuery("#valorId").val("");
		jQuery("#nombreId").val("");
		jQuery("#estadoId").val("");
	}
	
	function limpiar2() {
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
			<c:if test="${empty hasId}">
				<fmt:message key="dominio.tituloNuevo" />
			</c:if>
			<c:if test="${!empty hasId}">
				<fmt:message key="dominio.tituloEditar" />
			</c:if>
		</h1>
	</div>

	<!-- Pagina de control de errores en el encabezado -->
	<%@ include file="/mostrarErrores.jsp"%>
	<!-- fin Pagina de control de errores en el encabezado -->

	<form:form id="frmDominioDetalle" action="ingresarDominio.do"
		commandName="dominioForm" method="POST">
		<spring:hasBindErrors name="dominioForm">
			<div class="mensajeError">
				<form:errors path="*" />
			</div>
		</spring:hasBindErrors>

		<div class="grupoCampos">

			<form:hidden path="dominioDetalleTO.codigo" />
			<form:hidden path="dominioTO.nombre" />
			<form:hidden path="dominioTO.tipoDato" />
			<form:hidden path="dominioTO.tipoCampo" />
			<form:hidden path="dominioTO.estado" />
			<form:hidden path="dominioTO.valor" />

			<div class="campoCombo">
				<form:label path="dominioDetalleTO.tipoCampo">
					<fmt:message key="general.tipo.Campo" />:
					<em>*</em>
				</form:label>
					
				<c:if test="${empty hasId}">
					<form:select id="tipoCampoId" path="dominioDetalleTO.tipoCampo"
						disabled="false">
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
				</c:if>
				
				
				<c:if test="${!empty hasId}">
					<form:hidden id="tipoCampoId" path="dominioDetalleTO.tipoCampo" />
					<form:select path="dominioDetalleTO.tipoCampo" disabled="true">
						<form:option value="">
							<fmt:message key="general.combo.opcionInicial" />
						</form:option>
						<form:option value="E">
							<fmt:message key="general.entrada" />
						</form:option>
						<form:option value="S">
							<fmt:message key="general.salida" />
						</form:option>
					</form:select>
				</c:if>
			</div>
			
			<div class="campoCombo">
					<form:label path="dominioDetalleTO.tipoDato">
						<fmt:message key="general.tipoDato" />:
					<em>*</em>
					</form:label>
					<c:if test="${empty hasId}">
						<form:select id="tipoDatoId" path="dominioDetalleTO.tipoDato" disabled="false">
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
						<form:hidden id="tipoDatoId" path="dominioDetalleTO.tipoDato" />
						<form:select path="dominioDetalleTO.tipoDato" disabled="true">
							<form:option value="">
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
		
			<div class="campoTexto">
				<c:if test="${empty hasId}">
					<form:label path="dominioDetalleTO.nombre">
						<fmt:message key="general.codigo" />:
					<em>*</em>
					</form:label>

					<form:input id="nombreId" path="dominioDetalleTO.nombre" maxlength="50"></form:input>
				</c:if>
			</div>

			<div class="campoTexto">
				<form:label path="dominioDetalleTO.valor">
					<fmt:message key="general.valor" />:
					<em>*</em>
				</form:label>
				<form:input id="valorId" path="dominioDetalleTO.valor"
					maxlength="100"></form:input>
			</div>
	
			<div class="campoCombo">
				<form:label path="dominioDetalleTO.estado">
					<fmt:message key="general.estado" />:
					<em>*</em>
				</form:label>
				<form:select id="estadoId" path="dominioDetalleTO.estado">
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
					<input class="barraBotones" type="submit" value="<fmt:message key="general.botonAgregar"/>" title='<fmt:message key="general.botonAgregar"/>' />
				</c:if>
				<c:if test="${!empty hasId}">
					<input class="barraBotones" type="button" value="<fmt:message key="general.botonModificar"/>" title='<fmt:message key="general.botonModificar"/>' onclick="modificar();" />
				</c:if>
				
				
				<c:if test="${empty hasId}">
					<input class="barraBotones" type="button" value='<fmt:message key="general.botonLimpiar"/>' title='<fmt:message key="general.botonLimpiar"/>' onclick="limpiar2();" />
				</c:if>
				<c:if test="${!empty hasId}">
					<input class="barraBotones" type="button" value='<fmt:message key="general.botonLimpiar"/>' title='<fmt:message key="general.botonLimpiar"/>' onclick="limpiar();" />
				</c:if>
				 
					
				<input class="barraBotones" type="button" value='<fmt:message key="general.botonCancelar"/>' title='<fmt:message key="general.botonCancelar"/>' onclick="volver();" />
			</div>
		</div>

		<div class="mensajeRequerido">
			<p>
				<fmt:message key="general.mensajeRequerido" />
			</p>
		</div>
	</form:form>
</div>