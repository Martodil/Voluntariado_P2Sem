<%@include file="../cabeceraB.jspf"%>
<%@include file="../menus/menuTrabajador.jspf"%>

<main id="main-content">
  <section>
    <header>
      <h3>Mis actividades inscritas</h3>
    </header>

    <c:if test="${empty inscripciones}">
      <p>No tienes actividades inscritas por el momento.</p>
    </c:if>

    <c:if test="${not empty inscripciones}">
      <table class="tabla-actividades">
        <thead>
        <tr>
          <th>ID Inscripción</th>
          <th>Título actividad</th>
          <th>Fecha</th>
          <th>Horario</th>
          <th>Estado</th>
          <th>Fecha de registro</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ins" items="${inscripciones}">
          <tr>
            <td>${ins.idInscripcion}</td>
            <td>${ins.actividad.tituloAct}</td>
            <td>${ins.actividad.fechaAct}</td>
            <td>${ins.actividad.horarioAct}</td>
            <td>${ins.estado}</td>
            <td>${ins.fechaRegistro}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </c:if>
  </section>
</main>

<%@include file="../lateral.jspf"%>
<%@include file="../pie.jspf"%>
