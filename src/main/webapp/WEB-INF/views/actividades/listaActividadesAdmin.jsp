<%@include file="../cabeceraB.jspf"%>
<%@include file="../menus/menuAdmin.jspf"%> <%-- o el menú que uses --%>

<main id="main-content">
    <section>
        <header>
            <h3>Actividades registradas</h3>
        </header>

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
                        <!-- EDITAR -->
                        <a href="${pageContext.request.contextPath}/actividades/editar/${act.idActividad}">
                            Editar
                        </a>

                        <!-- ELIMINAR -->
                        <form action="${pageContext.request.contextPath}/actividades/eliminar/${act.idActividad}"
                              method="post"
                              style="display:inline;"
                              onsubmit="return confirm('¿Seguro que deseas eliminar esta actividad?');">
                            <button type="submit">Eliminar</button>
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
