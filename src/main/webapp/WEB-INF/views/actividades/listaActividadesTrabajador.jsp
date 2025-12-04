<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../cabeceraB.jspf"%>
<%@include file="../menus/menuTrabajador.jspf"%>

<main id="main-content">
    <section>
        <header>
            <h3>Actividades disponibles (Trabajador)</h3>
        </header>

        <!-- Mensajes flash opcionales -->
        <c:if test="${not empty mensajeOk}">
            <div class="mensaje-ok">${mensajeOk}</div>
        </c:if>
        <c:if test="${not empty mensajeError}">
            <div class="mensaje-error">${mensajeError}</div>
        </c:if>

        <table class="tabla-actividades">
            <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Fecha</th>
                <th>Horario</th>
                <th>Responsable</th>
                <th>Cupo</th>
                <th>Vigencia</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="act" items="${actividades}">
                <tr>
                    <td>${act.idActividad}</td>
                    <td>${act.tituloAct}</td>
                    <td>${act.fechaAct}</td>
                    <td>${act.horarioAct}</td>
                    <td>${act.responsableAct}</td>
                    <td>${act.cupoAct}</td>
                    <td>${act.vigenciaAct}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/actividades/${act.idActividad}/inscribirse"
                              method="post" style="display:inline;">
                            <button type="submit">Inscribirme</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>

<%@include file="../lateral.jspf"%>
<%@include file="../pie.jspf"%>
