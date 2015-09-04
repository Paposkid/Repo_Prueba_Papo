<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script language="javaScript" type="text/javascript">
	function modificar() {
		jQuery("#frmReglaDetalle").attr("action", "modificarRegla.do");
		jQuery("#frmReglaDetalle").submit();
	}
	function volver() {
		jQuery("#frmReglaDetalle").attr("action", "mostrarPaginaRegla.do");
		jQuery("#frmReglaDetalle").submit();
	}
	function cambiar() {
		if (jQuery("#idCheck")[0].checked == true) {
			jQuery("#datepickerHasta")[0].disabled = true;
			jQuery("#datepickerHasta")[0].nextElementSibling.hidden = true;
		} else {
			jQuery("#datepickerHasta")[0].disabled = false;
			jQuery("#datepickerHasta")[0].nextElementSibling.hidden = false;
		}
	}
</script>

<div class="body">

	<div class="titulo">
		<h1>
			<fmt:message key="regla.tituloNuevo" />
		</h1>
	</div>

	<form:form id="frmReglaDetalle" action="mostrarPaginaCondicionRegla.do" commandName="reglaForm" method="POST">

		<div class="grupoCampos">
			<div class="campoTexto">
				<form:label path="reglaDetalleTO.nombre">
					<fmt:message key="general.nombre" />:<em>*</em>
				</form:label>
				<form:input path="reglaDetalleTO.nombre" maxlength="12" />
			</div>

			<div class="campoCombo">
				<form:label path="reglaDetalleTO.tipoRegla">
					<fmt:message key="general.tipo" />:<em>*</em>
				</form:label>
				<form:select path="reglaDetalleTO.tipoRegla">
					<form:option value="" selected="">
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:options items="${reglaForm.listaComboRegla}" itemLabel="nombre" itemValue="codigo" />
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="reglaDetalleTO.subtipoRegla">
					<fmt:message key="regla.subtipo" />:<em>*</em>
				</form:label>
				<form:select path="reglaDetalleTO.subtipoRegla">
					<form:option value="" selected="">
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="G">
						<fmt:message key="regla.general" />
					</form:option>
					<form:option value="E">
						<fmt:message key="regla.especifica" />
					</form:option>
				</form:select>
			</div>

			<div class="campoCombo">
				<form:label path="reglaDetalleTO.tipoEvaluacion">
					<fmt:message key="regla.evaluacion" />:<em>*</em>
				</form:label>
				<form:select path="reglaDetalleTO.tipoEvaluacion">
					<form:option value="" selected="">
						<fmt:message key="general.combo.opcionInicial" />
					</form:option>
					<form:option value="P">
						<fmt:message key="regla.preEval" />
					</form:option>
					<form:option value="E">
						<fmt:message key="regla.eval" />
					</form:option>
					<form:option value="O">
						<fmt:message key="regla.postEval" />
					</form:option>
				</form:select>
			</div>

			<div class="campoTexto">
				<form:label path="reglaDetalleTO.fechaVigenciaDesde">
					<fmt:message key="regla.inicioVigencia" />:<em>*</em>
				</form:label>
				<form:input id="datepickerDesde" path="reglaDetalleTO.fechaVigenciaDesde"
					maxlength="12" />
			</div>

			<div class="campoTexto">
				<form:label path="reglaDetalleTO.fechaVigenciaHasta">
					<fmt:message key="regla.finVigencia" />:
				</form:label>
				<form:input id="datepickerHasta" path="reglaDetalleTO.fechaVigenciaHasta"
					maxlength="12" />
			</div>

			<div class="campoCheck">
				<form:label path="reglaDetalleTO.sinVigencia">
					<fmt:message key="regla.sinVigencia" />:
				</form:label>
				<form:checkbox id="idCheck" onclick="cambiar(this);"
					path="reglaDetalleTO.sinVigencia" value="" />
			</div>

			<div class="campoCombo">
				<form:label path="reglaDetalleTO.estado">
					<fmt:message key="general.estado" />:<em>*</em>
				</form:label>
				<form:select path="reglaDetalleTO.estado">
					<form:option value="" selected="">
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

			<div class="campoTexto">
				<form:label path="reglaDetalleTO.descripcion">
					<fmt:message key="regla.descripcion" />:<em>*</em>
				</form:label>
				<form:textarea path="reglaDetalleTO.descripcion" cols="19" rows="5" />
			</div>

			<br />
			<div class="divBarraBotones">
				<input class="barraBotones" type="submit"
					value="<fmt:message key="general.botonSiguiente"/>"
					title="<fmt:message key="general.botonSiguiente"/>" /> <input
					onclick="volver();" class="barraBotonesGrande" type="button"
					value="<fmt:message key="general.botonCancelar"/>"
					title="<fmt:message key="general.botonCancelar"/>" />
			</div>
		</div>
	</form:form>
</div>