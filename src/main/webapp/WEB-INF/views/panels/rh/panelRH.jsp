<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 21/11/2025
  Time: 11:56 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../cabecera.jspf"%>
<%@include file="../../menus/menuRH.jspf"%>
<main id="main-content">
    <section>
        <header>
            <h3>BIENVENIDO ${usuarioActual.tipoUsuarioDescripcion}, <strong>${usuarioActual.nombreUsuario}</strong></h3>
        </header>
        <h4>Haz accedido como personal de Recursos Humanos, encargado de validar las horas de los trabajadores</h4>
        <p>Correo Electrónico: ${usuarioActual.emailUsuario}</p>
        <form action="<c:url value='/auth/logout' />" method="get" style="display:inline;">
            <button type="submit">Cerrar sesión</button>
        </form>
    </section>
</main>
<%@include file="../../lateral.jspf"%>
<%@include file="../../pie.jspf"%>