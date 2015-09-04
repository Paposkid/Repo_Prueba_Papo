<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#idOperacionCombo")[0].disabled = true;
		$("#idCheckCat")[0].disabled = true;
		$("#idCheckCte")[0].disabled = true;
	});
	function activarOperador() {
		if ($("#idCampoSalida")[0].value != "") {
			$("#idOperacionCombo")[0].disabled = false;
		} else {
			$("#idOperacionCombo")[0].disabled = true;
		}
	}
	function verificarOperador(obj) {
		if (obj.value != "") {
			$("#idCheckCat")[0].disabled = false;
			$("#idCheckCte")[0].disabled = false;
			if (obj.value == 'IN' || obj.value == 'NOI' || obj.value == 'BET'
					|| obj.value == 'NOB') {
				ocultarTodo();
				$("#idCheckCat")[0].checked = true;
				$("#idCheckCte")[0].checked = false;
				$("#idCheckCte")[0].disabled = true;
				$("#idCategoriaLabel").show();
				$("#idCategoriaSelect").show();
				$("#idAdicionar").show();
				deshabilitarOpera();
			} else {
				ocultarTodo();
				$("#idCheckCat")[0].disabled = false;
				$("#idCheckCte")[0].disabled = false;
				$("#idCheckCat")[0].checked = false;
				$("#idCheckCte")[0].checked = false;
				habilitarOpera();
			}
		} else {
			ocultarTodo();
			$("#idCheckCat")[0].checked = false;
			$("#idCheckCte")[0].checked = false;
			$("#idCheckCat")[0].disabled = true;
			$("#idCheckCte")[0].disabled = true;
		}

	}
	function cambiarTipo(obj) {
		if ($("#idOperacionCombo")[0].value != "") {
			if ($("#idOperacionCombo")[0].value == 'IN'
					|| $("#idOperacionCombo")[0].value == 'NOI'
					|| $("#idOperacionCombo")[0].value == 'BET'
					|| $("#idOperacionCombo")[0].value == 'NOB') {
				if (obj.value == 'CAT') {
					$("#idConstanteLabel").hide();
					$("#idConstanteSelect").hide();
					$("#idCategoriaLabel").show();
					$("#idCategoriaSelect").show();
				}
				deshabilitarOpera();
			} else {
				ocultarTodo();
				if (obj.value == 'CAT') {
					$("#idCategoriaLabel").show();
					$("#idCategoriaSelect").show();
					$("#idDominioLabel").show();
					$("#idDominioSelect").show();
					$("#idComboDominio")[0].disabled = true;
				} else {
					$("#idCategoriaLabel").hide();
					$("#idCategoriaSelect").hide();
					$("#idDominioLabel").hide();
					$("#idDominioSelect").hide();
					$("#idConstanteLabel").show();
					$("#idConstanteSelect").show();
				}
				habilitarOpera();
			}
		}
		$("#idAdicionar").show();
	}
	function cambiarCategoria() {
		$("#idComboDominio").empty();
		$("#idComboDominio").append(
				"<option value=''> -- Seleccione una Opción -- </option>");
		if ($("#idComboCategoria")[0].value != "") {
			$("#idComboDominio")[0].disabled = false;
			$
					.ajax({
						url : "cargarComboDominio.do",
						data : "categoria=" + $("#idComboCategoria")[0].value,
						success : function(datos) {
							for ( var i = 0; i < datos.length; i++) {
								$("#idComboDominio").empty();
								$("#idComboDominio")
										.append(
												"<option value=''> -- Seleccione una Opción -- </option>");
								$("#idComboDominio")
										.append(
												"<option value='" + datos[i].codigo + "'>"
														+ datos[i].nombre
														+ "</option>");
							}
						}
					});
		} else {
			$("#idComboDominio")[0].disabled = true;
		}
	}
	function ocultarTodo() {
		$("#idComboCategoria")[0].value = "";
		$("#idComboDominio")[0].value = "";
		$("#idComboConstante")[0].value = "";
		$("#idCategoriaLabel").hide();
		$("#idCategoriaSelect").hide();
		$("#idDominioLabel").hide();
		$("#idDominioSelect").hide();
		$("#idConstanteLabel").hide();
		$("#idConstanteSelect").hide();
		$("#idAdicionar").hide();
	}
	function habilitarOpera() {
		$("#idMas")[0].disabled = false;
		$("#idMenos")[0].disabled = false;
		$("#idMult")[0].disabled = false;
		$("#idDiv")[0].disabled = false;
		$("#idParD")[0].disabled = false;
		$("#idParI")[0].disabled = false;
	}
	function deshabilitarOpera() {
		$("#idMas")[0].disabled = true;
		$("#idMenos")[0].disabled = true;
		$("#idMult")[0].disabled = true;
		$("#idDiv")[0].disabled = true;
		$("#idParD")[0].disabled = true;
		$("#idParI")[0].disabled = true;
	}
	function volver() {
		jQuery("#frmReglaCondiciones").attr("action",
				"mostrarPaginaDetalleRegla.do");
		jQuery("#frmReglaCondiciones").submit();
	}
	function adicionar() {
		if ($("#idTextArea")[0].value != "") {
			if ($("#idOperacionCombo")[0].value == 'IN'
					|| $("#idOperacionCombo")[0].value == 'NOI'
					|| $("#idOperacionCombo")[0].value == 'BET'
					|| $("#idOperacionCombo")[0].value == 'NOB') {
				if ($("#idComboCategoria")[0].value != "") {
					$("#idTextArea")[0].value = $("#idTextArea")[0].value
							+ " "
							+ "("
							+ $("#idComboCategoria option:selected").text()
									.trim() + ")";
				}
			} else {
				if ($("#idCheckCat")[0].checked == true) {
					if ($("#idComboDominio")[0].value != "") {
						var result = $("#idTextArea")[0].value.trim();
						var opera = result.charAt(result.length - 1);
						if (opera != '+' && opera != '-' && opera != '*'
								&& opera != '/') {
							$("#idTextArea")[0].value = $("#idTextArea")[0].value
									+ " "
									+ "D"
									+ $("#idComboDominio option:selected")
											.text().trim();
						} else {
							$("#idTextArea")[0].value = $("#idTextArea")[0].value
									+ "."
									+ "D"
									+ $("#idComboDominio option:selected")
											.text().trim();
						}
					}
				} else if ($("#idCheckCte")[0].checked == true) {
					if ($("#idComboConstante")[0].value != "") {
						var result = $("#idTextArea")[0].value.trim();
						var opera = result.charAt(result.length - 1);
						if (opera != '+' && opera != '-' && opera != '*'
								&& opera != '/') {
							$("#idTextArea")[0].value = $("#idTextArea")[0].value
									+ " "
									+ "C"
									+ $("#idComboConstante option:selected")
											.text().trim();
						} else {
							$("#idTextArea")[0].value = $("#idTextArea")[0].value
									+ "."
									+ "C"
									+ $("#idComboConstante option:selected")
											.text().trim();
						}
					}
				}
			}
		} else {
			var campo = $("#idCampoSalida option:selected").text().trim() + " "
					+ $("#idOperacionCombo option:selected").text().trim();
			if ($("#idOperacionCombo")[0].value == 'IN'
					|| $("#idOperacionCombo")[0].value == 'NOI'
					|| $("#idOperacionCombo")[0].value == 'BET'
					|| $("#idOperacionCombo")[0].value == 'NOB') {
				if ($("#idComboCategoria")[0].value != "") {
					campo = campo
							+ " "
							+ "("
							+ $("#idComboCategoria option:selected").text()
									.trim() + ")";
				}
			} else {
				if ($("#idCheckCat")[0].checked == true) {
					if ($("#idComboDominio")[0].value != "") {
						campo = campo
								+ " "
								+ "D"
								+ $("#idComboDominio option:selected").text()
										.trim();
					}
				} else if ($("#idCheckCte")[0].checked == true) {
					if ($("#idComboConstante")[0].value != "") {
						campo = campo
								+ " "
								+ "C"
								+ $("#idComboConstante option:selected").text()
										.trim();
					}
				}
			}
			$("#idTextArea")[0].value = campo;
		}
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
	function opera(obj) {
		var result = $("#idTextArea")[0].value.trim();
		var opera = result.charAt(result.length - 1);
		if (opera != '+' && opera != '-' && opera != '*' && opera != '/') {
			if (obj.value == '(' || obj.value == ')') {
				$("#idTextArea")[0].value = $("#idTextArea")[0].value + " "
						+ obj.value;
			} else {
				if (obj.value == '+' || obj.value == '-' || obj.value == '*'
						|| obj.value == '/') {
					$("#idTextArea")[0].value = $("#idTextArea")[0].value + "."
							+ obj.value;
				}
			}
		} else {
			if (obj.value != '+' && obj.value != '-' && obj.value != '*'
					&& obj.value != '/') {
				$("#idTextArea")[0].value = $("#idTextArea")[0].value + " "
						+ obj.value;
			}
		}
	}
</script>


<div class="bodyExp">

	<div class="titulo">
		<h1>
			<fmt:message key="regla.tituloCondicion" />
		</h1>
	</div>

	<form:form id="frmReglaCondiciones" action="mostrarPaginaResultado.do" commandName="reglaForm" method="POST">

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
		
		<form:hidden path="condicionLogicoTO.valor"/>
		<form:hidden path="condiciones" />
		<form:hidden path="valorLogico" />
		<form:hidden path="valorCondiciones" />

		<div class="grupoCamposExp">
			<table align="center">
				<tr class="campoCombo">
					<td><form:label path="condicionSalidaTO.campo.codigoCampo">
							<fmt:message key="regla.condicion.campoSalida" />
						</form:label></td>
					<td><form:label path="condicionSalidaTO.operador">
							<fmt:message key="regla.condicion.operador" />
						</form:label>
					</td>
					<td><form:label path="condicionSalidaTO.tipo">
							<fmt:message key="general.tipo" />:
							</form:label>
					</td>
					<td id="idCategoriaLabel" style="display: none;"><form:label
							path="condicionSalidaTO.categoria.codigoCategoria">
							<fmt:message key="regla.condicion.categoria" />
						</form:label>
					</td>
					<td id="idDominioLabel" style="display: none;"><form:label
							path="condicionSalidaTO.dominio.codigo">
							<fmt:message key="regla.condicion.dominio" />
						</form:label>
					</td>
					<td id="idConstanteLabel" style="display: none;"><form:label
							path="condicionSalidaTO.constante.codigo">
							<fmt:message key="regla.condicion.constante" />
						</form:label>
					</td>
					<td></td>
				</tr>
				<tr class="campoCombo">
					<td><form:select id="idCampoSalida"
							path="condicionSalidaTO.campo.codigoCampo"
							onchange="activarOperador();">
							<form:option value="" selected="">
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:options items="${reglaForm.listaComboCampoSalida}"
								itemLabel="nombreCampo" itemValue="codigoCampo" />
						</form:select>
					</td>
					<td><form:select id="idOperacionCombo"
							path="condicionSalidaTO.operador" onchange="verificarOperador(this);">
							<form:option value="" selected="">
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:option value="IN">
								<fmt:message key="regla.condicion.operadorCombo.in" />
							</form:option>
							<form:option value="NOI">
								<fmt:message key="regla.condicion.operadorCombo.notIn" />
							</form:option>
							<form:option value="BET">
								<fmt:message key="regla.condicion.operadorCombo.between" />
							</form:option>
							<form:option value="NOB">
								<fmt:message key="regla.condicion.operadorCombo.notBetween" />
							</form:option>
							<form:option value="LIK">
								<fmt:message key="regla.condicion.operadorCombo.like" />
							</form:option>
							<form:option value="NLI">
								<fmt:message key="regla.condicion.operadorCombo.notLike" />
							</form:option>
							<form:option value="IGU">
								<fmt:message key="regla.condicion.operadorCombo.igual" />
							</form:option>
							<form:option value="MAY">
								<fmt:message key="regla.condicion.operadorCombo.mayor" />
							</form:option>
							<form:option value="MEN">
								<fmt:message key="regla.condicion.operadorCombo.menor" />
							</form:option>
							<form:option value="MAI">
								<fmt:message key="regla.condicion.operadorCombo.mayorIgual" />
							</form:option>
							<form:option value="MEI">
								<fmt:message key="regla.condicion.operadorCombo.menorIgual" />
							</form:option>
						</form:select></td>
					<td><form:radiobutton id="idCheckCat" path="condicionSalidaTO.tipo"
							value="CAT" onclick="cambiarTipo(this);" /> <form:label
							path="condicionSalidaTO.tipo">
							<fmt:message key="regla.condicion.cat" />
						</form:label> <form:radiobutton id="idCheckCte" path="condicionSalidaTO.tipo"
							value="CTE" onclick="cambiarTipo(this);" /> <form:label
							path="condicionSalidaTO.tipo">
							<fmt:message key="regla.condicion.cte" />
						</form:label></td>
					<td id="idCategoriaSelect" style="display: none;"><form:select
							id="idComboCategoria" onchange="cambiarCategoria();"
							path="condicionSalidaTO.categoria.codigoCategoria">
							<form:option value="" selected="">
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:options items="${reglaForm.listaComboCategoria}"
								itemLabel="nombreCategoria" itemValue="codigoCategoria" />
						</form:select></td>
					<td id="idDominioSelect" style="display: none;"><form:select
							id="idComboDominio" path="condicionSalidaTO.dominio.codigo">
						</form:select>
					</td>
					<td id="idConstanteSelect" style="display: none;"><form:select
							id="idComboConstante" path="condicionSalidaTO.constante.codigo">
							<form:option value="" selected="">
								<fmt:message key="general.combo.opcionInicial" />
							</form:option>
							<form:options items="${reglaForm.listaComboConstante}"
								itemLabel="nombre" itemValue="codigo" />
						</form:select>
					</td>
					<td id="idAdicionar" style="display: none;"><a
						href="javascript:void(0)" onclick="javascript:adicionar();"> <img
							src="<fmt:message key="general.adicionarSrc" />" height="15px"
							alt="<fmt:message key="general.adicionarAlt" />" width="15px" />
					</a>
					</td>
				</tr>
			</table>

			<br>
			<div class="divBarraBotones">
				<table align="center">
					<tr>
						<td><input id="idMas" disabled="disabled"
							onclick="opera(this);" class="barraBotonesGrande" type="button"
							value="<fmt:message key="regla.condicion.operador.+"/>"
							title="<fmt:message key="regla.condicion.operador.+"/>" /></td>
						<td><input id="idMenos" disabled="disabled"
							onclick="opera(this);" class="barraBotonesGrande" type="button"
							value="<fmt:message key="regla.condicion.operador.-"/>"
							title="<fmt:message key="regla.condicion.operador.-"/>" /></td>
						<td><input id="idMult" disabled="disabled"
							onclick="opera(this);" class="barraBotonesGrande" type="button"
							value="<fmt:message key="regla.condicion.operador.*"/>"
							title="<fmt:message key="regla.condicion.operador.*"/>" /></td>
						<td><input id="idDiv" disabled="disabled"
							onclick="opera(this);" class="barraBotonesGrande" type="button"
							value="<fmt:message key="regla.condicion.operador./"/>"
							title="<fmt:message key="regla.condicion.operador./"/>" /></td>
						<td><input id="idParD" disabled="disabled"
							onclick="opera(this);" class="barraBotonesGrande" type="button"
							value="<fmt:message key="regla.condicion.operador.("/>"
							title="<fmt:message key="regla.condicion.operador.("/>" /></td>
						<td><input id="idParI" disabled="disabled"
							onclick="opera(this);" class="barraBotonesGrande" type="button"
							value="<fmt:message key="regla.condicion.operador.)"/>"
							title="<fmt:message key="regla.condicion.operador.)"/>" /></td>
					</tr>
				</table>

				<br />
				<form:textarea id="idTextArea" path="condicionSalidaTO.valor" cols="50"
					rows="10" />
				<div class="divBarraBotones">
					<input class="barraBotones" type="button"
						onclick="agregarCondicion();"
						value="<fmt:message key="general.botonAgregar"/>"
						title="<fmt:message key="general.botonAgregar"/>" /> <input
						onclick="limpiar();" class="barraBotones" type="button"
						value="<fmt:message key="general.botonLimpiar"/>"
						title="<fmt:message key="general.botonLimpiar"/>" />
				</div>
			</div>
		</div>

		<div>
			<table id="idTabla" border="0" align="center">
				<tr>
					<td colspan="2">
						<div class="titulo">
							<h1>
								<fmt:message key="regla.condicion.agregadas" />
							</h1>
						</div>
					</td>
				</tr>
				<tr>
					<td><table id="idTablaCondicion">
							<tr id="idTrCondicion" style="display: none;">
								<td><a href="javascript:void(0);" onclick="eliminar(this);">
										<img src="<fmt:message key="general.borrarRegistroSrc" />"
										height="16px"
										alt="<fmt:message key="general.borrarRegistroAlt" />"
										width="16px" /> </a>
								</td>
								<td><input type="text" name="condicionesSalida" size="40%">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</div>

		<br />
		<div class="divBarraBotones">
			<input onclick="volver();" class="barraBotonesGrande" type="button"
				value="<fmt:message key="general.botonAnterior"/>"
				title="<fmt:message key="general.botonAnterior"/>" /> <input
				class="barraBotones" type="submit"
				value="<fmt:message key="general.botonSiguiente"/>"
				title="<fmt:message key="general.botonSiguiente"/>" />
		</div>
	</form:form>
</div>