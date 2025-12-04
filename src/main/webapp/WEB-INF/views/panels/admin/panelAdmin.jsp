<%@include file="../../cabeceraB.jspf"%>
<%@include file="../../menus/menuAdmin.jspf"%>
    <main id="main-content">
        <section class="admin-profile">
            <div class="admin-card">
                <h3 class="admin-title">
                    BIENVENIDO ${usuarioActual.tipoUsuarioDescripcion},
                    <span>${usuarioActual.nombreUsuario}</span>
                </h3>
                <p class="admin-subtitle">
                    Has accedido como administrador del programa de voluntariado.
                </p>

                <div class="admin-section">
                    <h4>Perfil de tu cuenta</h4>
                    <div class="admin-info-row">
                        <span class="admin-label">Nombre</span>
                        <span class="admin-value">${usuarioActual.nombreUsuario}</span>
                    </div>
                    <div class="admin-info-row">
                        <span class="admin-label">Rol</span>
                        <span class="admin-value">${usuarioActual.tipoUsuarioDescripcion}</span>
                    </div>
                    <div class="admin-info-row">
                        <span class="admin-label">Correo electr&oacute;nico</span>
                        <span class="admin-value">${usuarioActual.emailUsuario}</span>
                    </div>
                </div>

                <div class="admin-section">
                    <h4>Acciones como administrador</h4>
                    <ul class="admin-actions-list">
                        <li>Registrar y actualizar actividades de voluntariado.</li>
                        <li>Revisar y aprobar inscripciones de voluntarios.</li>
                        <li>Consultar listas de participantes y sus asistencias.</li>
                        <li>Gestionar la informaci&oacute;n general del programa.</li>
                    </ul>
                </div>

                <div class="admin-actions-footer">
                    <form action="<c:url value='/auth/logout'/>" method="get">
                        <button type="submit" class="btn-secondary admin-logout-btn">
                            Cerrar sesi&oacute;n
                        </button>
                    </form>
                </div>
            </div>
        </section>
    </main>
<%@include file="../../lateral.jspf"%>
<%@include file="../../pie.jspf"%>
