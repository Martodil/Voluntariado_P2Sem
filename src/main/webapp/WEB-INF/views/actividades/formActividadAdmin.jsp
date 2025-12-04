<%@include file="../cabeceraB.jspf"%>
<%@include file="../menus/menuAdmin.jspf"%>

<main id="main-content">
    <section>
        <header>
            <h3>Registrar nueva actividad</h3>
        </header>

        <form:form method="post"
                   modelAttribute="actividad"
                   action="${pageContext.request.contextPath}/actividades/admin/guardar">

            <!-- SEDE -->
            <label for="idSede">Sede:</label>
            <label for="idSede">Sede:</label>
            <form:select path="idSede" id="idSede" required="true">
                <form:option value="" label="-- Selecciona una sede --" />
                <form:options items="${sedes}" itemValue="idSede" itemLabel="nombreSede" />
            </form:select>
            <br/>

            <br/>
            <!-- SEMESTRE -->
            <label for="idSemestre">Semestre:</label>
            <form:select path="idSemestre" id="idSemestre" required="true">
                <form:option value="" label="-- Selecciona semestre --" />
                <c:forEach var="sem" items="${semestres}">
                    <form:option value="${sem.idSemestre}">
                        ${sem.noSemestre} - ${sem.anioSemestre}
                    </form:option>
                </c:forEach>
            </form:select>
            <br/>

            <br/>

            <!-- TURNO -->
            <label for="claveTurnoAct">Turno:</label>
            <form:select path="claveTurnoAct" id="claveTurnoAct" required="true">
                <form:option value="" label="-- Selecciona turno --" />
                <form:options items="${turnos}" itemValue="idTurno" itemLabel="turno" />
            </form:select>
            <br/>
            <br/>

            <!-- TITULO -->
            <label for="tituloAct">Título de la actividad:</label>
            <form:input path="tituloAct" id="tituloAct" required="true"/>
            <br/>
            <br/>

            <!-- FECHA -->
            <label for="fechaAct">Fecha de la actividad:</label>
            <form:input path="fechaAct" id="fechaAct" type="date" required="true"/>
            <br/>
            <br/>

            <!-- HORARIO -->
            <label for="horarioAct">Horario:</label>
            <form:input path="horarioAct" id="horarioAct" placeholder="08:00-12:00"/>
            <br/>
            <br/>

            <!-- RESPONSABLE -->
            <label for="responsableAct">Responsable:</label>
            <form:input path="responsableAct" id="responsableAct" />
            <br/>
            <br/>
            <!-- CUPO -->
            <label for="cupoAct">Cupo máximo:</label>
            <form:input path="cupoAct" id="cupoAct" type="number" min="1" />
            <br/>
            <br/>

            <!-- VIGENCIA -->
            <label for="vigenciaAct">Vigencia:</label>
            <form:input path="vigenciaAct" id="vigenciaAct" type="date" />
            <br/>
            <br/>


            <button type="submit">Guardar actividad</button>

        </form:form>
    </section>
</main>

<%@include file="../lateral.jspf"%>
<%@include file="../pie.jspf"%>
