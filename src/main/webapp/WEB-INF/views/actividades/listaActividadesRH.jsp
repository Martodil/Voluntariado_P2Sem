<%@include file="../cabeceraB.jspf"%>
<%@include file="../menus/menuRH.jspf"%> <%-- o el menú que uses --%>

<main id="main-content">
    <section>
        <header>
            <h3 style="padding-left: 30px;">Actividades registradas</h3>
        </header>

        <div class="cards-container">

            <c:forEach var="act" items="${actividades}">
                <div class="card">

                    <h3>${act.tituloAct}</h3>

                    <p><strong>Fecha:</strong> ${act.fechaAct}</p>
                    <p><strong>Horario:</strong> ${act.horarioAct}</p>
                    <p><strong>Responsable:</strong> ${act.responsableAct}</p>
                    <p><strong>Cupo:</strong> ${act.cupoAct}</p>
                    <p><strong>Vigencia:</strong> ${act.vigenciaAct}</p>

                </div>
            </c:forEach>

        </div>
    </section>
</main>

<%@include file="../lateral.jspf"%>
<%@include file="../pie.jspf"%>
