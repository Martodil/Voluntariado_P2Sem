<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecera.jspf"%>

<main id="main-content">
    <section class="home-hero">
        <div class="home-hero-text">
            <h2 class="home-title">Sé parte de la experiencia de voluntariado</h2>
            <p class="home-intro">
                Esta plataforma organiza actividades para apoyar a la comunidad, conectar personas con causas
                y hacer más sencillo el seguimiento de tus participaciones.
            </p>

            <div class="home-hero-actions">
                <a href="<spring:url value='/actividades'/>" class="btn-primary">Ver actividades disponibles</a>
                <a href="<spring:url value='/registro'/>" class="btn-secondary">Registrarme como voluntario</a>
            </div>

            <ul class="home-hero-list">
                <li>Explora propuestas clasificadas por tipo de apoyo y nivel de compromiso.</li>
                <li>Registra tu participación y consulta el historial de actividades realizadas.</li>
                <li>Recibe recordatorios y actualizaciones sobre los proyectos en los que colaboras.</li>
            </ul>
        </div>

        <aside class="home-hero-panel">
            <h3 class="home-panel-title">Próxima actividad destacada</h3>
            <p class="home-panel-text">
                Jornada de reforestación y limpieza de áreas verdes en la zona comunitaria.
            </p>
            <div class="home-panel-info">
                <div class="home-panel-row">
                    <span class="home-label">Fecha</span>
                    <span class="home-value">Sábado 14, 09:00 h</span>
                </div>
                <div class="home-panel-row">
                    <span class="home-label">Lugar</span>
                    <span class="home-value">Parque ecológico comunitario</span>
                </div>
                <div class="home-panel-row">
                    <span class="home-label">Cupo estimado</span>
                    <span class="home-value">25 voluntarios</span>
                </div>
            </div>
            <div class="home-panel-tags">
                <span class="badge">Ambiental</span>
                <span class="badge">Comunitario</span>
                <span class="badge">Al aire libre</span>
            </div>
        </aside>
    </section>
</main>

<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
