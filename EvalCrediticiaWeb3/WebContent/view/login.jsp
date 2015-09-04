<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><sitemesh:write property='title' />
</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/stylesheet.css' />" />

<fmt:setBundle basename="messages" />
</head>


<body>

	<table width="80%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="25%" align="center">
				<div class="logo"></div></td>

			<td align="center">
				<div class="loginEncabezado">
					<fmt:message key="general.tituloAplicacion" />
				</div></td>
		</tr>

		<tr>
			<td colspan="2">
				<div class="lineaRoja"></div></td>
		</tr>

		<tr>
			<td colspan="3">
				<div id="login">
					<br>
					<br>
					<table align="center" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="285" align="left" valign="top">
								<div class="titulo-login">
									<fmt:message key="login.inicioSesion" />
								</div>
							</td>
						</tr>

						<tr>
							<td colspan="2">
								<div class="contenido">
									<form:form action="mostrarPaginaInicio.do" commandName="loginForm" method="POST">
										<h1>&nbsp;</h1>

										<table border="0" align="center" cellpadding="4" cellspacing="1">
											<tr>
												<td colspan="2">
													<!-- Pagina de control de errores en el encabezado --> <%@ include
														file="/mostrarErrores.jsp"%> <!-- fin Pagina de control de errores en el encabezado -->
													<div class="mensajeError">
														<form:errors path="*" />
													</div>
												</td>
											</tr>

											<tr>
												<td>
													<div class="campoTextoLogin">
														<form:label path="usuarioTO.usuario">
															<fmt:message key="login.usuario" />
															<em>*</em>&nbsp;</form:label>
													</div></td>
												<td>
													<div class="campoTextoLogin">
														<form:input path="usuarioTO.usuario" maxlength="30"></form:input>
													</div></td>
											</tr>

											<tr>
												<td>
													<div class="campoTextoLogin">
														<form:label path="usuarioTO.clave">
															<fmt:message key="login.clave" />
															<em>*</em>&nbsp;</form:label>
													</div>
												</td>
												<td>
													<div class="campoTextoLogin">
														<form:password path="usuarioTO.clave" maxlength="30" />
													</div>
												</td>
											</tr>

											<tr>
												<td colspan="2" align="center">
													<div class="barraBotonesLogin">
														<input class="barraBotones" type="submit"
															value="<fmt:message key="general.botonAceptar"/>"
															title='<fmt:message key="general.botonAceptar"/>' />
													</div>
												</td>
											</tr>

										</table>

										<input type="hidden" name="form_encoding" VALUE="UTF-8" />

									</form:form>
								</div></td>
						</tr>
					</table>
				</div></td>
		</tr>
	</table>
</body>
</html>