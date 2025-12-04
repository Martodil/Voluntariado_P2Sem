<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 21/11/2025
  Time: 11:56 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../cabeceraB.jspf"%>
<%@include file="../../menus/menuEquipoOp.jspf"%>
<main id="main-content">
    <section>
        <header>
            <h3>BIENVENIDO ${usuarioActual.tipoUsuarioDescripcion}, <strong>${usuarioActual.nombreUsuario}</strong></h3>
        </header>
        <h4>Haz accedido como personal encargado del equipo operativo</h4>
        <p>Correo Electr&oacute;nico: ${usuarioActual.emailUsuario}</p>
        <form action="<c:url value='/auth/logout' />" method="get" style="display:inline;">
            <button type="submit">Cerrar sesi&oacute;n</button>
        </form>
    </section>
</main>
<%@include file="../../lateral.jspf"%>
<%@include file="../../pie.jspf"%>