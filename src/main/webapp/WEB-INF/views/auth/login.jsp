<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 21/11/2025
  Time: 11:54 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecera.jspf"%>
<%@include file="../menu.jspf"%>

<main id="main-content">
    <section>
        <header>
            <h3>Iniciar sesión</h3>
        </header>

        <!-- Mensaje de error del LoginController -->
        <c:if test="${not empty errorLogin}">
            <div style="color:red; margin-bottom: 15px;">
                ${errorLogin}
            </div>
        </c:if>

        <!-- Formulario de Login -->
        <form:form modelAttribute="loginFrm" method="post" action="${pageContext.request.contextPath}/auth/login">

            <div style="margin-bottom: 12px;">
                <label for="usuario">Usuario o correo electrónico:</label><br>
                <form:input path="usuario" id="usuario" />
                <form:errors path="usuario" cssStyle="color:red;" />
            </div>

            <div style="margin-bottom: 12px;">
                <label for="password">Contraseña:</label><br>
                <form:password path="password" id="password" />
                <form:errors path="password" cssStyle="color:red;" />
            </div>

            <div>
                <button type="submit">Ingresar</button>
            </div>

        </form:form>

        <br>
        <a href="${pageContext.request.contextPath}/auth/registro">¿No tienes cuenta? Regístrate aquí</a>

    </section>
</main>

<%@include file="../lateral.jspf"%>
<%@include file="../pie.jspf"%>
