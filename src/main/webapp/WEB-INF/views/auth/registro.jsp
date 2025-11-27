<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 21/11/2025
  Time: 11:59 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecera.jspf"%>
<%@include file="../menu.jspf"%>

<main id="main-content">
    <section>
        <header>
            <h3>Registro de usuario</h3>
        </header>

        <!-- Mensaje global de error (errores de negocio del Service) -->
        <c:if test="${not empty error}">
            <div style="color:red; margin-bottom: 15px;">
                ${error}
            </div>
        </c:if>

        <!-- Mensaje de validación global -->
        <form:errors cssStyle="color:red;" element="div" />

        <!-- FORMULARIO -->
        <form:form modelAttribute="registroUsuarioFrm" method="post" action="${pageContext.request.contextPath}/auth/registro">

            <!-- ID EMPLEADO -->
            <div style="margin-bottom: 12px;">
                <label for="idEmpleado">ID de empleado:</label><br>
                <form:input path="idEmpleado" id="idEmpleado" />
                <form:errors path="idEmpleado" cssStyle="color:red;" />
            </div>

            <!-- NOMBRE DE USUARIO -->
            <div style="margin-bottom: 12px;">
                <label for="nombreUsuario">Nombre de usuario:</label><br>
                <form:input path="nombreUsuario" id="nombreUsuario" />
                <form:errors path="nombreUsuario" cssStyle="color:red;" />
            </div>

            <!-- EMAIL -->
            <div style="margin-bottom: 12px;">
                <label for="emailUsuario">Correo electrónico:</label><br>
                <form:input path="emailUsuario" id="emailUsuario" />
                <form:errors path="emailUsuario" cssStyle="color:red;" />
            </div>

            <!-- CONTRASEÑA -->
            <div style="margin-bottom: 12px;">
                <label for="password">Contraseña:</label><br>
                <form:password path="password" id="password" />
                <form:errors path="password" cssStyle="color:red;" />
            </div>

            <!-- CONFIRMAR CONTRASEÑA -->
            <div style="margin-bottom: 12px;">
                <label for="confirmarPassword">Confirmar contraseña:</label><br>
                <form:password path="confirmarPassword" id="confirmarPassword" />
                <form:errors path="confirmarPassword" cssStyle="color:red;" />
            </div>

            <!-- SELECCIÓN DE TIPO DE USUARIO -->
            <div style="margin-bottom: 12px;">
                <label for="tipoUsuario">Tipo de usuario:</label><br>

                <form:select path="tipoUsuario" id="tipoUsuario">
                    <form:option value="" label="-- Selecciona una opción --"/>
                    <form:option value="A" label="Administrador"/>
                    <form:option value="R" label="Recursos Humanos"/>
                    <form:option value="E" label="Equipo Operativo"/>
                    <form:option value="T" label="Trabajador"/>
                </form:select>

                <form:errors path="tipoUsuario" cssStyle="color:red;" />
            </div>

            <!-- BOTÓN -->
            <div>
                <button type="submit">Registrar usuario</button>
            </div>

        </form:form>

        <br>
        <a href="${pageContext.request.contextPath}/auth/login">¿Ya tienes una cuenta? Inicia sesión aquí</a>

    </section>
</main>

<%@include file="../lateral.jspf"%>
<%@include file="../pie.jspf"%>