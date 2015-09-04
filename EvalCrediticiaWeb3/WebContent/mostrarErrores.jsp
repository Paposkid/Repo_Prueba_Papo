<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- Se muestran los mensajes Informativos -->
<c:if test="${mensaje != null}">
	<div class="mensajeInformativo">${mensaje}</div>
</c:if>

<!-- Se muestran los mensajes de advertencia -->
<c:if test="${advertencia != null}">
	<div class="mensajeAdvertencia">${advertencia}</div>
</c:if>

<!-- Se muestran los mensajes de errores -->
<c:if test="${error != null}">
	<div class="mensajeError">${error}</div>
</c:if>