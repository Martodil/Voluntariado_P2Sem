<%@include file="../cabecera.jspf"%>
<%@include file="../menus/menuD.jspf"%>

<main id="main-content">
    <section style="max-width: 480px; margin: 0 auto;">
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
                <label for="emailUsuario">Correo electr&oacute;nico:</label><br>
                <form:input path="emailUsuario" id="emailUsuario" />
                <form:errors path="emailUsuario" cssStyle="color:red;" />
            </div>

            <!-- CONTRASEÑA -->
            <div style="margin-bottom: 12px;">
                <label for="password">Contrase&ntilde;a:</label><br>
                <form:password path="password" id="password" />
                <form:errors path="password" cssStyle="color:red;" />
            </div>

            <!-- CONFIRMAR CONTRASEÑA -->
            <div style="margin-bottom: 12px;">
                <label for="confirmarPassword">Confirmar contrase&ntilde;a:</label><br>
                <form:password path="confirmarPassword" id="confirmarPassword" />
                <form:errors path="confirmarPassword" cssStyle="color:red;" />
            </div>

            <!-- SELECCIÓN DE TIPO DE USUARIO -->
            <div style="margin-bottom: 12px;">
                <label for="tipoUsuario">Tipo de usuario:</label><br>

                <form:select path="tipoUsuario" id="tipoUsuario">
                    <form:option value="" label="-- Selecciona una opcion --"/>
                    <form:option value="A" label="Administrador"/>
                    <form:option value="R" label="Recursos Humanos"/>
                    <form:option value="E" label="Equipo Operativo"/>
                    <form:option value="T" label="Trabajador"/>
                </form:select>

                <form:errors path="tipoUsuario" cssStyle="color:red;" />
            </div>

            <!-- Datos Trabajador -->
            <div id="datosTrabajador" style="display:none; border: 1px solid #ccc; padding: 0.5rem; margin-bottom: 1rem;">
                <h4>Datos de trabajador</h4>

                <label for="deptotrab">Departamento:</label>
                <form:input path="deptotrab" id="deptotrab"/><br/>

                <label for="puestoTrab">Puesto:</label>
                <form:input path="puestoTrab" id="puestoTrab"/><br/>
            </div>

            <!-- Datos RH -->
            <div id="datosRH" style="display:none;">
                <h4>Datos de Recursos Humanos</h4>

                <label for="areaResponsableRh">&Aacute;rea responsable:</label>
                <form:input path="areaResponsableRh" id="areaResponsableRh"/><br/>

            </div>

            <!-- Datos Equipo Operativo -->
            <div id="datosEqOper" style="display:none;">
                <h4>Datos de Equipo Operativo</h4>

                <label for="areaResponsableEqOper">&Aacute;rea responsable:</label>
                <form:input path="areaResponsableEqOper" id="areaResponsableEqOper"/><br/>

                <label for="inventarioAsignadoEqOper">Inventario asignado:</label>
                <form:input path="inventarioAsignadoEqOper" id="inventarioAsignadoEqOper"/><br/>

                <label for="telefonoContactoEqOper">Tel&eacute;fono de contacto:</label>
                <form:input path="telefonoContactoEqOper" id="telefonoContactoEqOper"/><br/>
            </div>

            <!-- BOTÓN -->
            <div>
                <button type="submit">Registrar usuario</button>
            </div>

        </form:form>

        <br>
        <a href="${pageContext.request.contextPath}/auth/login">¿Ya tienes una cuenta? Inicia sesi&oacute;n aqu&iacute;</a>

        <script>
            const selectTipo = document.getElementById('tipoUsuario');
            const datosTrabajador = document.getElementById('datosTrabajador');
            const datosRH = document.getElementById('datosRH');
            const datosEqOper = document.getElementById('datosEqOper');

            function actualizarSecciones() {
                const tipo = selectTipo.value;

                datosTrabajador.style.display = (tipo === 'T') ? 'block' : 'none';
                datosRH.style.display          = (tipo === 'R') ? 'block' : 'none';
                datosEqOper.style.display      = (tipo === 'E') ? 'block' : 'none';
                // Admin (A) no muestra nada extra
            }

            selectTipo.addEventListener('change', actualizarSecciones);
            actualizarSecciones();
        </script>

    </section>
</main>

<%@include file="../pie.jspf"%>