<%@include file="../../cabecera.jspf"%>
<%@include file="../../menus/menuTrabajador.jspf"%>
<main id="main-content">
    <section>
        <header>
            <h3>BIENVENIDO ${usuarioActual.tipoUsuarioDescripcion}, <strong>${usuarioActual.nombreUsuario}</strong></h3>
        </header>
        <h4>Haz accedido como trabajador, debes participar en las diferentes actividades que propongan</h4>
        <p>Correo Electrónico: ${usuarioActual.emailUsuario}</p>
        <form action="<c:url value='/auth/logout' />" method="get" style="display:inline;">
            <button type="submit">Cerrar sesión</button>
        </form>
    </section>
</main>
<%@include file="../../lateral.jspf"%>
<%@include file="../../pie.jspf"%>