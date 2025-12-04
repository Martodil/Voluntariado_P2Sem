<%@include file="../../cabeceraB.jspf"%>
<%@include file="../../menus/menuAdmin.jspf"%>
    <main id="main-content">
        <section>
            <header>
                <h3>BIENVENIDO ${usuarioActual.tipoUsuarioDescripcion}, <strong>${usuarioActual.nombreUsuario}</strong></h3>
            </header>
            <h4>Haz accedido como administrador</h4>
            <p>Correo Electr&oacute;nico: ${usuarioActual.emailUsuario}</p>
            <form action="<c:url value='/auth/logout'/>" method="get" style="display:inline;">
                <button type="submit">Cerrar sesi&oacute;n</button>
            </form>
        </section>
    </main>
<%@include file="../../lateral.jspf"%>
<%@include file="../../pie.jspf"%>
