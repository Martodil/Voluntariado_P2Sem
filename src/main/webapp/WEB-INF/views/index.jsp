<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecera.jspf"%>

<main id="main-content">
    <section class="home-hero">
        <div class="home-hero-text">
            <h2 class="home-title">S&eacute; parte de la experiencia de voluntariado</h2>
            <p class="home-intro">
                Esta plataforma organiza actividades para apoyar a la comunidad, conectar personas con causas
                y hacer más sencillo el seguimiento de tus participaciones.
            </p>

            <%@include file="menu.jspf"%>

            <ul class="home-hero-list">
                <li>Explora propuestas clasificadas por tipo de apoyo y nivel de compromiso.</li>
                <li>Registra tu participación y consulta el historial de actividades realizadas.</li>
                <li>Recibe recordatorios y actualizaciones sobre los proyectos en los que colaboras.</li>
            </ul>

        </div>
        <%@include file="lateral.jspf"%>
    </section>
</main>


<%@include file="pie.jspf"%>
