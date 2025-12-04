<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../cabeceraB.jspf" %>
<%@ include file="../menus/menuAdmin.jspf" %>

<main id="main-content">
    <section>
        <header>
            <h3>
                <c:choose>
                    <c:when test="${actividad.idActividad == null}">
                        Registrar nueva actividad
                    </c:when>
                    <c:otherwise>
                        Editar actividad
                    </c:otherwise>
                </c:choose>
            </h3>
        </header>

        <!-- DETERMINA AUTOMÁTICAMENTE EL ACTION SEGÚN SI ES ALTA O EDICIÓN -->
        <form:form method="post"
                   modelAttribute="actividad"
                   action="${actividad.idActividad == null
                           ? pageContext.request.contextPath.concat('/actividades/admin/guardar')
                           : pageContext.request.contextPath.concat('/actividades/actualizar')}">

            <!-- ID oculto para edición -->
            <form:hidden path="idActividad"/>

            <!-- SEDE -->
            <label>Sede:</label><br>
            <form:select path="idSede">
                <form:option value="" label="-- Selecciona --"/>
                <form:options items="${sedes}" itemValue="idSede" itemLabel="nombreSede"/>
            </form:select>
            <br><br>

            <!-- SEMESTRE -->
            <label>Semestre:</label><br>
            <form:select path="idSemestre">
                <option value="">-- Selecciona semestre --</option>
                <c:forEach var="sem" items="${semestres}">
                    <option value="${sem.idSemestre}"
                        ${sem.idSemestre == actividad.idSemestre ? 'selected' : ''}>
                            ${sem.noSemestre} - ${sem.anioSemestre}
                    </option>
                </c:forEach>
            </form:select>
            <br><br>

            <!-- TURNO -->
            <label>Turno:</label><br>
            <form:select path="claveTurnoAct">
                <form:option value="" label="-- Selecciona turno --"/>
                <form:options items="${turnos}" itemValue="idTurno" itemLabel="turno"/>
            </form:select>
            <br><br>

            <!-- TÍTULO -->
            <label>Título:</label><br>
            <form:input path="tituloAct" required="true"/>
            <br><br>

            <!-- FECHA -->
            <label>Fecha de la actividad:</label><br>
            <form:input path="fechaAct" type="date" required="true"/>
            <br><br>

            <!-- HORARIO -->
            <label>Horario (ej. 09:00 - 13:00):</label><br>
            <form:input path="horarioAct"/>
            <br><br>

            <!-- RESPONSABLE -->
            <label>Responsable:</label><br>
            <form:input path="responsableAct"/>
            <br><br>

            <!-- CUPO -->
            <label>Cupo máximo:</label><br>
            <form:input path="cupoAct" type="number" min="1"/>
            <br><br>

            <!-- VIGENCIA -->
            <label>Vigencia:</label><br>
            <form:input path="vigenciaAct" type="date"/>
            <br><br>

            <!-- BOTÓN -->
            <button type="submit">
                <c:choose>
                    <c:when test="${actividad.idActividad == null}">
                        Registrar actividad
                    </c:when>
                    <c:otherwise>
                        Guardar cambios
                    </c:otherwise>
                </c:choose>
            </button>

        </form:form>

    </section>
</main>

<%@ include file="../lateral.jspf" %>
<%@ include file="../pie.jspf" %>
