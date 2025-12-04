<%@include file="../cabeceraB.jspf"%>
<%@include file="../menus/menuTrabajador.jspf"%>

<style>

    .cards-container {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
        gap: 25px;
        padding: 30px;
    }

    /* TARJETA */
    .card {
        background: #ffffff;
        padding: 20px;
        border-radius: 12px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        transition: transform 0.2s ease, box-shadow 0.2s ease;
    }

    .card:hover {
        transform: translateY(-4px);
        box-shadow: 0 6px 16px rgba(0,0,0,0.15);
    }

    /* TITULO */
    .card h3 {
        margin-top: 0;
        margin-bottom: 10px;
        font-size: 1.3rem;
        color: #333;
    }

    /* CAMPOS */
    .card p {
        margin: 5px 0;
        color: #444;
        font-size: 0.95rem;
    }

    /* BOTÓN (opcional, como en tu referencia) */
    .btn-inscribirse {
        margin-top: 15px;
        display: block;
        width: 100%;
        text-align: center;
        padding: 10px;
        background-color: #6b3e2e;
        color: #fff;
        font-weight: bold;
        border: none;
        border-radius: 20px;
        cursor: pointer;
        transition: background-color .2s ease;
    }

    .btn-inscribirse:hover {
        background-color: #4c2d22;
    }

</style>

<main id="main-content">
    <section>
        <header>
            <h3>Actividades disponibles</h3>
        </header>
        <div class="cards-container">
            <!-- Mensajes flash opcionales -->
            <c:if test="${not empty mensajeOk}">
                <div class="mensaje-ok">${mensajeOk}</div>
            </c:if>
            <c:if test="${not empty mensajeError}">
                <div class="mensaje-error">${mensajeError}</div>
            </c:if>

            <c:forEach var="act" items="${actividades}">
                <div class="card">

                    <h3>${act.tituloAct}</h3>

                    <p><strong>Fecha:</strong> ${act.fechaAct}</p>
                    <p><strong>Horario:</strong> ${act.horarioAct}</p>
                    <p><strong>Responsable:</strong> ${act.responsableAct}</p>
                    <p><strong>Cupo:</strong> ${act.cupoAct}</p>
                    <p><strong>Vigencia:</strong> ${act.vigenciaAct}</p>
                    <form action="${pageContext.request.contextPath}/actividades/${act.idActividad}/inscribirse" method="post">
                        <button type="submit" class="btn-inscribirse">¡Registrarme!</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </section>
</main>

<%@include file="../lateral.jspf"%>
<%@include file="../pie.jspf"%>
