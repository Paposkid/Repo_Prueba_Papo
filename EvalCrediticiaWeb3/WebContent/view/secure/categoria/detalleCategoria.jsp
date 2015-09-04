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

	var contadorFila = 0;
	var objBorrar ='';

	function ingresar() {
	
		jQuery("#frmCategoriaDetalle").attr("action", "insertarCategoria.do");
		jQuery("#frmCategoriaDetalle").submit();
	}
	
	function modificar() {
	
		jQuery("#frmCategoriaDetalle").attr("action", "modificarCategoria.do");
		jQuery("#frmCategoriaDetalle").submit();
		
	}
	
	function volver() {
		jQuery("#frmCategoriaDetalle").attr("action", "listarCategorias.do");
		jQuery("#frmCategoriaDetalle").submit();
	}
	
	function dominio() {
		jQuery("#frmCategoriaDetalle").attr("action", "agregarNuevoDominio.do");
		jQuery("#frmCategoriaDetalle").submit();
	}
	
	function eliminar(id, categoria) {
		jQuery("#frmCategoriaDetalle").attr("action","eliminarDominioCategoria.do");
		jQuery("#idCodigo").val(id);
		jQuery("#idCategoria").val(categoria);
		jQuery("#frmCategoriaDetalle").submit();
	}
	
	function cargar() {
		jQuery("#frmCategoriaDetalle").attr("action", "cargar.do?reload=false");
		jQuery("#frmCategoriaDetalle").submit();
	}
	
	function limpiar() {
		jQuery("#idTipoCat").val("");
		jQuery("#idCodigoCampo").val("");
		jQuery("#tipoDato").val("");
		jQuery("#idRangoDesde").val("");
		jQuery("#idRangoHasta").val("");
		jQuery("#idDomCod").val("");
		jQuery("#idNombre").val("");
	}
	
	
	function validarDominios() {
		
		var nroFilasTabla = jQuery('#tablaDominios >tbody >tr').length;
		var idFila="";
		
		for (var i=1; i<nroFilasTabla; i++) {
			idFila="trDominio" + i;
	  		
	  		if(!jQuery("#"+idFila+"").val()) {
	  			alert("Ingrese el Dominio en la fila "  + (i+1));
	  		}
	    }
		
	}
	

	
	
    function clonar(){
    
    
        var id = '';
        var fila = '';
        var nroFilasLista = 0;

		if(jQuery("#idCodigoCampo").val()) {
		
	        fila = $("#tablaDominios tr:last");
	        id = $(fila).attr("id");
	        nroFilasLista = id.substring(id.length-1); 
	        contadorFila =  parseInt(nroFilasLista) + 1;
	    
	        id="trDominio" + contadorFila;
	        fila = $("#tablaDominioAux tr:last").clone(true);
	        fila.attr("id",id);
	        
	        $("[id*=dominioAuxId]",fila).attr("id","dominioId"+contadorFila);
	        $("[id*=borrarDominioAuxId]",fila).attr("id","borrarDominioId"+contadorFila);
	        
	
	        $("#tablaDominios").append(fila);
	        $("#tablaDominios tr:last input").each(function () {
	            $(this).val("");
	        });
	        
	        $("#tablaDominios tr:last select").each(function () {
	            $(this).val("");
	        });
	        
	        jQuery("#listaForm").show();
	        
	        var op = $("#tipoDato option:selected").val();
	        
	        
	        if (op == 'V') {
				
				var nroFilasTabla = $("tr", "tablaDominios").length;
				
				if(nroFilasTabla <= 1) {
					$("#btnagr").hide();
				} 
			}
			
	        if (op == 'L') {
	
				$("#btnagr").show();			 
			}
		
		} else {
			alert("Debe Seleccionar una opci\u00F3n en Campo");
		}
    }
	
	
	
   function eliminarFila(idIcoFilaBorrar) { 

            var nroFilaBorrar = idIcoFilaBorrar.substring(idIcoFilaBorrar.length-1);
            var nroFilasTabla = jQuery('#tablaDominios >tbody >tr').length;
            var idFilaBorrar = "trDominio" + nroFilaBorrar;
            objBorrar =  idFilaBorrar;

	        $("#" + objBorrar).remove();
	        objBorrar = '';
	        
	        var op = $("#tipoDato option:selected").val();
		
			if (op == 'V' && nroFilasTabla <= 1) {
				$("#btnagr").show();
			}
			
			if (nroFilasTabla <= 1) {
				$("#listaForm").hide();
			}
			
    }
	
	
	
</script>

<script>
	function mostrarOcultar() {
	
	debugger;
		var op = $("#tipoDato option:selected").val();
		
		if (op == 'L' || op == 'V') {
		
			$("#rangoForm").hide();

			if (op == 'L') {
				$("#btnagr").show();
				
			} else if (op == 'V') {
				var nroFilasTabla = jQuery('#tablaDominios >tbody >tr').length;
				var nroFilasTablaDomAsoc = jQuery('#tablaListaDomAsociadosId >tbody >tr').length;
				
				if(nroFilasTabla <= 1 && nroFilasTablaDomAsoc <1 ) {
					$("#btnagr").show();
				} else {
					
					$("#btnagr").hide();
					
					if($("#listaForm").hide()) {
						$("#listaForm").show();
					}
					
				}
				
			} else {
				$("#btnagr").hide();
			}
			
		} else if (op == 'R') {
			$("#rangoForm").show();
			$("#listaForm").hide();
			$("#btnagr").hide();
			
		} else {
		
			$("#rangoForm").hide();
			$("#listaForm1").hide();
			$("#btnagr").hide();
		}
	}


	$(document).ready(function() {

		mostrarOcultar();
		$("#tipoDato").change(function() {
			mostrarOcultar();
		});
	});
</script>

<div class="body">

	<div class="titulo">
		<h1>
			<c:if test="${empty hasId}">
				<fmt:message key="categoria.tituloNuevo" />
			</c:if>
			<c:if test="${!empty hasId}">
				<fmt:message key="categoria.tituloEditar" />
			</c:if>
		</h1>
	</div>

	<!-- fin Pagina de control de errores en el encabezado -->
	<%@ include file="/mostrarErrores.jsp"%>

	<form:form id="frmCategoriaDetalle" action="insertarCategoria.do"
		commandName="categoriaForm" method="POST">

		<spring:hasBindErrors name="categoriaForm">
			<div class="mensajeError">
				<form:errors path="*" />
			</div>
		</spring:hasBindErrors>

		<div class="grupoCampos">

			<form:hidden path="categoriaTO.nombreCategoria" />
			<form:hidden path="categoriaTO.codigoCampo" />
			<form:hidden path="categoriaTO.tipoCategoria" />
			<form:hidden path="cambioPantalla" />
			<form:hidden id="idCategoria" path="dominioCategoriaTO.categoria.codigoCategoria" />

			<form:hidden id="idCodigo" path="dominioCategoriaTO.codigo" />
			<form:hidden path="categoriaDetalleTO.codigoCategoria" />

			<div class="campoTexto">
				<form:label path="categoriaDetalleTO.nombreCategoria"> <fmt:message key="general.codigo" />: <em>*</em> </form:label>
			
				<c:if test="${empty hasId}">
						<form:input id="idNombre" path="categoriaDetalleTO.nombreCategoria" maxlength="30"></form:input>
				</c:if>
				
				<c:if test="${!empty hasId}">
					<form:input id="idNombre" path="categoriaDetalleTO.nombreCategoria" maxlength="30" disabled="true"></form:input>
					<form:hidden path="categoriaDetalleTO.nombreCategoria"></form:hidden>
				</c:if>
			</div>
			

			<div id="tipoDatoDiv" class="campoCombo">
				<form:label path="categoriaDetalleTO.tipoCategoria"><fmt:message key="general.tipo" />:<em>*</em></form:label>
				<c:if test="${empty hasId}">
					<form:select id="idTipoCat" path="categoriaDetalleTO.tipoCategoria" disabled="false" onchange="cargar();">
						<form:option value="" selected><fmt:message key="general.combo.opcionInicial" /></form:option>
						<form:option value="E"><fmt:message key="general.entrada" /></form:option>
						<form:option value="S"><fmt:message key="general.salida" /></form:option>
					</form:select>
				</c:if>

				<c:if test="${!empty hasId}">
					<form:hidden id="idTipoCat" path="categoriaDetalleTO.tipoCategoria" />
					<form:hidden path="categoriaDetalleTO.tipoCampo" />
					
					<form:select path="categoriaDetalleTO.tipoCampo" disabled="true">
						<form:option value="" selected><fmt:message key="general.combo.opcionInicial" /></form:option>
						<form:option value="E"><fmt:message key="general.entrada" /></form:option>
						<form:option value="S"><fmt:message key="general.salida" /></form:option>
					</form:select>
				</c:if>
			</div>

			<div class="campoCombo">
				<form:label path="categoriaDetalleTO.codigoCampo"><fmt:message key="general.tipoCampo" /><em>*</em></form:label>
				<c:if test="${empty hasId}">
					<form:select id="idCodigoCampo" path="categoriaDetalleTO.codigoCampo" disabled="false">
						<form:option value="" selected><fmt:message key="general.combo.opcionInicial" /></form:option>
						<form:options items="${categoriaForm.listaComboCampo}" itemLabel="nombreCampo" itemValue="codigoCampo" />
					</form:select>
				</c:if>
				<c:if test="${!empty hasId}">
					<form:hidden id="idCodigoCampo" path="categoriaDetalleTO.codigoCampo" />
					<form:select path="categoriaDetalleTO.codigoCampo" disabled="true">
						<form:options items="${categoriaForm.listaComboCampo}" itemLabel="nombreCampo" itemValue="codigoCampo"/>
					</form:select>
				</c:if>
			</div>

			<div class="campoCombo">
				
				<form:label path="tipo"><fmt:message key="general.tipoDato" /><em>*</em></form:label>
				<c:if test="${empty hasId}">
					<form:select id="tipoDato" path="categoriaDetalleTO.tipoCampo" disabled="false">
						<form:option value="" selected><fmt:message key="general.combo.opcionInicial" /></form:option>
						<form:option value="V"><fmt:message key="categoria.tipo.valor" /></form:option>
						<form:option value="L"><fmt:message key="categoria.tipo.lista" /></form:option>
						<form:option value="R"><fmt:message key="categoria.tipo.rango" /></form:option>
					</form:select>

					<a id="btnagr" href="javascript:void(0);" style="display: none" onclick="clonar();"> 
						<img src="<fmt:message key="general.botonAgregarDominio" />" height="16px" alt="<fmt:message key="general.borrarRegistroAlt" />" width="16px" />
					</a>
				</c:if>
				
				<c:if test="${!empty hasId}">
					<form:select id="tipoDato" path="categoriaDetalleTO.tipoCategoria" disabled="true">
						<form:option value="" selected><fmt:message key="general.combo.opcionInicial" /></form:option>
						<form:option value="V"><fmt:message key="categoria.tipo.valor" /></form:option>
						<form:option value="L"><fmt:message key="categoria.tipo.lista" /></form:option>
						<form:option value="R"><fmt:message key="categoria.tipo.rango" /></form:option>
					</form:select>

					<a id="btnagr" href="javascript:void(0);" style="display: none" onclick="clonar();"> 
						<img src="<fmt:message key="general.botonAgregarDominio" />"height="16px" alt="<fmt:message key="general.borrarRegistroAlt" />" width="16px" />
					</a>
				</c:if>
			</div>

			<!-- rango desde hasta con jquery -->
			<div id="rangoForm" style="display: none;">
				<div class="campoCombo">
					<form:label path="categoriaDetalleTO.rangoDesde"><fmt:message key="categoria.desde" /><em>*</em></form:label>
					<form:select id="idRangoDesde" path="categoriaDetalleTO.rangoDesde">
						<form:option value="" selected><fmt:message key="general.combo.opcionInicial" /></form:option>
						<form:options items="${categoriaForm.listaComboDominio}" itemLabel="nombre" itemValue="codigo" />
					</form:select>
				</div>
				
				<div class="campoCombo">
					<form:label path="categoriaDetalleTO.rangoHasta"><fmt:message key="categoria.hasta" /><em>*</em></form:label>
					<form:select id="idRangoHasta" path="categoriaDetalleTO.rangoHasta">
						<form:option value="" selected><fmt:message key="general.combo.opcionInicial"/></form:option>
						<form:options items="${categoriaForm.listaComboDominio}" itemLabel="nombre" itemValue="codigo"></form:options>
					</form:select>
				</div>
			</div>

			<!-- dominio que se ocultara cuando se elija rango y se mostara cuando se elije lista -->

			<br>
			<div id="listaForm" class="tabla2" style="display: none;">
             	<table id="tablaDominios" border="0" align="center">
             		<thead>
	                     <tr id="trDominioTitulo0">
	                         <th align="center" class="tituloTabla"><b><fmt:message key="general.dominios"/></b></th>
	                         <th align="center" class="tituloTabla">&nbsp;</th>
	                     </tr>
                     </thead>
                     
                     <tbody>
						<c:if test="${!empty categoriaForm.dominios}">
							<c:forEach var="item" items="${categoriaForm.dominios}" varStatus="status">
								<tr id="trDominio<c:out value='${status.count}'/>">
									<td>
										<form:label path="dominioTO.codigo"><fmt:message key="categoria.dominio" /><em>*</em></form:label>&nbsp;&nbsp;
										 <form:select id="dominioId<c:out value='${status.count}'/>" path="dominioTO.tipoDato">
											<form:option value="-1"><fmt:message key="general.combo.opcionInicial" /></form:option>
											<c:forEach var="item2" items="${categoriaForm.listaComboDominio}">
												<c:choose>
													<c:when test="${item2.codigo==item}">
														<form:option label="${item2.nombre}" selected="true" value="${item2.codigo}"></form:option>
													</c:when>
													<c:otherwise>
														<form:option label="${item2.nombre}" value="${item2.codigo}"></form:option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</form:select>
										&nbsp;&nbsp;
										<a id="dominioId<c:out value='${status.count}'/>" href="javascript:void(0);" onclick="jQuery(this).parent().remove()"> 
											<img src="<fmt:message key="general.borrarRegistroSrc" />" height="16px" alt="<fmt:message key="general.borrarRegistroAlt" />" width="16px" />
										</a>
									</td>

							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div> 
	 </div>

		<br>
		<div class="divBarraBotones">
			<c:if test="${empty hasId}">
				<input class="barraBotones" type="submit" value="<fmt:message key="general.botonAgregar"/>" title='<fmt:message key="general.botonAgregar"/>' onclick="ingresar();" />
				<input onclick="limpiar();" class="barraBotones" type="button" value='<fmt:message key="general.botonLimpiar"/>' title='<fmt:message key="general.botonLimpiar"/>' />
			</c:if>

			<c:if test="${!empty hasId}">
				<input id="botonguardar" class="barraBotones" type="button" value="<fmt:message key="general.botonModificar"/>" title='<fmt:message key="general.botonModificar"/>' onclick="modificar();" />
				<input onclick="limpiar();" class="barraBotones" type="button" value='<fmt:message key="general.botonLimpiar"/>' title='<fmt:message key="general.botonLimpiar"/>' />
			</c:if>

			<input onclick="volver();" class="barraBotones" type="button" value='<fmt:message key="general.botonCancelar"/>' title='<fmt:message key="general.botonCancelar"/>' />
		</div>

		<!-- aca se despliega la tabla para agregar dominios o desasociarlos logicamente -->
		<br />

		<c:if test="${fn:length(categoriaForm.resultadosDomCat)>0}">
			<div class="grupoCamposDominio">
					<fieldset class="grupoCampos">
						<legend>
							<fmt:message key="general.dominios" />
						</legend>
						<div id="displayTagDiv" class="tablaDominios">
							<div id="displayTagDiv2">
								<display:table htmlId="tablaListaDomAsociadosId" name="categoriaForm.resultadosDomCat" id="filaId" requestURI="editarCategoria.do?reload=false" pagesize="4">
		
									<display:column style="text-align: center;">
										<a href="javascript:void(0);" onclick="eliminar('${filaId.codigo}','${hasId}')"> 
											<img src="<fmt:message key="general.borrarRegistroSrc" />" height="16px" alt="<fmt:message key="general.borrarRegistroAlt" />" width="16px" /> 
										</a>
									</display:column>
									<display:column property="dominioTO.nombre" titleKey="categoria.dominio" />
								</display:table>
							</div>
						</div>
					</fieldset>
			</div>
		</c:if>

		<div class="mensajeRequerido">
			<p>
				<fmt:message key="general.mensajeRequerido" />
			</p>
		</div>


		<div style="display:none">
		
			<table id="tablaDominioAux">
				<tr id="trDominioAux0">
					<td align="center">  
						<form:label path="dominioTO.codigo"><fmt:message key="categoria.dominio" /><em>*</em></form:label>&nbsp;&nbsp;   
						<form:select id="dominioAuxId" path="dominioTO.tipoDato">
							<form:option value="-1" selected><fmt:message key="general.combo.opcionInicial" /></form:option>
							<form:options items="${categoriaForm.listaComboDominio}"itemLabel="nombre" itemValue="codigo"></form:options>
						</form:select>
						&nbsp;&nbsp;
						<a id="borrarDominioAuxId" href='javascript:void(0);' onclick="eliminarFila(this.id);"> 
							<img src="<fmt:message key="general.borrarRegistroSrc" />" height="16px" alt="<fmt:message key="general.borrarRegistroAlt" />" width="16px" />
						</a>
					</td>
				</tr> 
			</table>
		</div>

	</form:form>
</div>

