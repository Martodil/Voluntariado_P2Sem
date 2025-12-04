<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../cabecera.jspf"%>
<%@include file="../../menus/menuAdmin.jspf"%>
<main id="main-content">
    <section>
        <header>
            <h3>Página de voluntariado</h3>
            <p>Panel de administración del programa de voluntariado. Aquí puedes revisar el estado general de las actividades y del equipo.</p>
        </header>

        <section>
            <h4>Resumen general</h4>
            <p>
                Desde este panel puedes monitorear las actividades activas, el número de voluntarios inscritos y las tareas pendientes de aprobación.
                Utiliza el menú inferior para navegar entre los módulos de actividades, voluntarios y reportes.
            </p>
        </section>

        <section>
            <h4>Acciones rápidas</h4>
            <ul>
                <li>Registrar nuevas actividades de voluntariado.</li>
                <li>Revisar y aprobar inscripciones de voluntarios.</li>
                <li>Consultar la lista de actividades próximas.</li>
                <li>Ver el historial de participación de los voluntarios.</li>
            </ul>
        </section>
    </section>
</main>
<%@include file="../../lateral.jspf"%>
<%@include file="../../pie.jspf"%>

