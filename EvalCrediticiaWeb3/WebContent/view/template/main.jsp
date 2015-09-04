<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><sitemesh:write property='title' />
</title><fmt:setBundle basename="messages" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/stylesheet.css'/>" />
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.9.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.displaytag-ajax-1.2.js'/>"></script>

<script language="javaScript" type="text/javascript">
	var icons = {
		header : "ui-icon-circle-arrow-e",
		activeHeader : "ui-icon-circle-arrow-s"
	};

	$(document).ready(function() {
		$("#accordion").accordion({
			heightStyle : "content",
			autoHeight : false,
			icons : icons,
			collapsible : true,
			active : false
		});
	});

	$(function() {
		$("#datepickerDMA").datepicker({
			showOn : "button",
			buttonImage : "/EvalCrediticiaWeb/resources/images/cal.png",
			buttonImageOnly : true
		});
		$("#datepickerDMA").attr('readonly', true);
		$("#datepickerDesde").datepicker({
			showOn : "button",
			buttonImage : "/EvalCrediticiaWeb/resources/images/cal.png",
			buttonImageOnly : true
		});
		$("#datepickerDesde").attr('readonly', true);
		$("#datepickerHasta").datepicker({
			showOn : "button",
			buttonImage : "/EvalCrediticiaWeb/resources/images/cal.png",
			buttonImageOnly : true
		});
		$("#datepickerHasta").attr('readonly', true);
	});
</script>
</head>

<body>
	<table border="0" width="92%;" style="margin-left: 45px;"
		cellpadding="0" cellspacing="0">
		<tbody>

			<!-- ======================================== ENCABEZADO =========================== -->
			<tr>
				<td width="25%" align="center">
					<div class="logo" /></td>

				<td align="center">
					<div class="loginEncabezado">
						<fmt:message key="general.tituloAplicacion" />
					</div></td>

				<td width="35%" align="left" valign="top">
					<div class="botonesEncabezado">
						<span class="bienvenido"> <label> <fmt:message
									key="general.bienvenido" /> </label> <span> <c:out
									value="${usuarioSession.nombreCompleto}" /> </span> &nbsp;|&nbsp; <a
							href="#"> <span class="cerrarSesion"> <fmt:message
										key="general.cerrarSesion" /> </span> <input type="image"
								id="btnCerrarSesion" alt="Cerrar Sesion" name="btnCerrarSesion"
								value="Cerrar Sesión"
								src='<fmt:message key="general.cerrarSesionSrc"/>' width="20"
								height="20" style="border: none; color: #D52B1E;" /> </a> </span>
					</div></td>
			</tr>

			<!-- ======================================== SE PINTA LA LINEA ROJA =========================== -->
			<tr>
				<td colspan="3">
					<div class="lineaRoja" /></td>
			</tr>

			<!-- ======================================== MENÚ =========================== -->
			<tr valign="top">
				<td height="100%"><br> <br>
					<div style="width: 240px" id="accordion">
						<div>
							<label class="title"><fmt:message key="menu.administracion" /> </label>
						</div>
						<ul>
							<li><a href="mostrarPaginaDominio.do"><fmt:message key="menu.dominio" /> </a>
							</li>
							<li><a href="mostarPaginaCategoria.do"><fmt:message key="menu.categoria" /> </a>
							</li>
							<li><a href="mostrarPaginaConstante.do"><fmt:message key="menu.constante" /> </a>
							</li>
							<li><a href="mostarPaginaParametro.do"><fmt:message key="menu.parametro" /> </a>
							</li>
							<!-- <li><a href="#"><fmt:message key="menu.abono" /> </a></li> -->
							<li><a href="mostrarPaginaCampo.do"><fmt:message key="menu.campo" /> </a>
							</li>
							<li><a href="mostrarPaginaListaEspecial.do"><fmt:message key="menu.listaEspecial" /> </a>
							</li>
							<li><a href="mostrarPaginaRegla.do"><fmt:message key="menu.reglaCrediticia" /> </a>
							</li>
						</ul>
						<div>
							<label class="title"><fmt:message key="menu.reportes" />
							</label>
						</div>
						<ul>
							<li><a href="mostrarPaginaReporte.do"><fmt:message key="menu.reportes.evaluaciones" /> </a>
							</li>
						</ul>
					</div></td>
				<!-- ======================================== CUERPO =========================== -->

				<td colspan="2" valign="top"><sitemesh:write property='body' />
					<br></td>
			</tr>

		</tbody>
	</table>
</body>
</html>