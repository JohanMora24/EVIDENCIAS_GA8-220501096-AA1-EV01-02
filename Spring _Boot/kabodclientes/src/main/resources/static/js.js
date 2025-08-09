document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("formRegistro");
    const mensajeDiv = document.getElementById("mensaje-registro");

    if (!form) {
        console.error("No se encontró el formulario con id 'formRegistro'");
        return;
    }

    form.addEventListener("submit", async function (e) {
        e.preventDefault();

        // Leer campos del formulario (IDs acordes a tu HTML)
        const idValor = document.getElementById("idCliente").value.trim();
        const nombre = document.getElementById("nombreCliente").value.trim();
        const telefono = document.getElementById("telefonoCliente").value.trim();
        const email = document.getElementById("emailCliente").value.trim();
        const direccion = document.getElementById("direccionCliente").value.trim();
        const contrasena = document.getElementById("contrasena").value;
        const confirmar = document.getElementById("confirmar-contrasena").value;

        // Limpia mensaje anterior
        mensajeDiv.textContent = "";
        mensajeDiv.style.backgroundColor = "";
        mensajeDiv.style.color = "";

        // Validaciones básicas
        if (contrasena !== confirmar) {
            mensajeDiv.textContent = "❌ Las contraseñas no coinciden ❌";
            mensajeDiv.style.color = "white";
            mensajeDiv.style.backgroundColor = "red";
            alert("❌ Las contraseñas no coinciden ❌");
            return;
        }

        if (!idValor) {
            mensajeDiv.textContent = "❌ El número de documento es obligatorio ❌";
            mensajeDiv.style.color = "white";
            mensajeDiv.style.backgroundColor = "red";
            alert("❌ El número de documento es obligatorio ❌");
            return;
        }

        const idClienteNum = parseInt(idValor, 10);
        if (isNaN(idClienteNum)) {
            mensajeDiv.textContent = "❌ El número de documento debe ser numérico ❌";
            mensajeDiv.style.color = "white";
            mensajeDiv.style.backgroundColor = "red";
            alert("❌ El número de documento debe ser numérico ❌");
            return;
        }

        // Construir objeto con camelCase (coincide con Cliente.java)
        const cliente = {
            idCliente: idClienteNum,
            nombreCliente: nombre,
            telefonoCliente: telefono,
            emailCliente: email,
            direccionCliente: direccion,
            idVendedor: null,
            contrasena: contrasena
        };

        // Mostrar JSON que se va a enviar (útil para depuración)
        console.log("JSON que se va a enviar:", JSON.stringify(cliente));

        try {
            const response = await fetch("http://localhost:8081/api/clientes", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(cliente)
            });

            if (response.ok) {
                // Éxito
                mensajeDiv.textContent = "✅ Registro exitoso. Redirigiendo al login...";
                mensajeDiv.style.color = "white";
                mensajeDiv.style.backgroundColor = "green";
                alert("✅ Registro exitoso ✅");
                form.reset();

                // Redirigir a login.html después de 2 segundos
                setTimeout(() => {
                    window.location.href = "login.html";
                }, 2000);
            } else {
                // Error devuelto por el servidor
                const textoError = await response.text().catch(() => "");
                console.error("Mensaje del servidor:", textoError || response.status);
                mensajeDiv.textContent = "❌ Error al registrar el cliente ❌";
                mensajeDiv.style.color = "white";
                mensajeDiv.style.backgroundColor = "red";
                alert("❌ Error al registrar el cliente ❌");
            }
        } catch (error) {
            // Error de conexión u otro
            console.error("Error en la solicitud:", error);
            mensajeDiv.textContent = "❌ Error en la conexión con el servidor ❌";
            mensajeDiv.style.color = "white";
            mensajeDiv.style.backgroundColor = "red";
            alert("❌ Error en la conexión con el servidor ❌");
        }
    });
});


 // =========================
// LOGIN DE CLIENTE
// =========================
const loginForm = document.getElementById("formLogin");

if (loginForm) {
    loginForm.addEventListener("submit", async function (e) {
        e.preventDefault();

        const email = document.getElementById("loginEmail").value.trim();
        const contrasena = document.getElementById("loginContrasena").value.trim();

        if (!email || !contrasena) {
            alert("Por favor ingrese su correo y contraseña");
            return;
        }

        try {
            const response = await fetch("http://localhost:8081/api/clientes/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ emailCliente: email, contrasena: contrasena })
            });

            const text = await response.text();

            if (text.startsWith("OK")) {
                alert("✅ Inicio de sesión exitoso ✅");
                sessionStorage.setItem("emailCliente", email);

                // Obtener idCliente a partir del email
                try {
                    const responseCliente = await fetch(`http://localhost:8081/api/clientes/email/${encodeURIComponent(email)}`);
                    if (responseCliente.ok) {
                        const clienteData = await responseCliente.json();
                        sessionStorage.setItem("idCliente", clienteData.idCliente);
                    } else {
                        console.warn("No se pudo obtener el idCliente");
                        sessionStorage.removeItem("idCliente");
                    }
                } catch (error) {
                    console.error("Error al obtener idCliente:", error);
                    sessionStorage.removeItem("idCliente");
                }

                window.location.href = "inicio.html";
            } else {
                alert(text);
            }
        } catch (error) {
            console.error("Error en el login:", error);
            alert("❌ Error en la conexión con el servidor ❌");
        }
    });
}

    // =========================
    // MENSAJE BIENVENIDA Y BOTÓN CERRAR SESIÓN EN inicio.html
    // =========================
    const mensajeDiv = document.getElementById("mensaje-bienvenida");
    const btnCerrarSesion = document.getElementById("btnCerrarSesion");

    if (mensajeDiv) {
        const email = sessionStorage.getItem("emailCliente");
        if (email) {
            mensajeDiv.textContent = `Bienvenido ✔ - ${email}`;
            mensajeDiv.style.color = "#000000";
            mensajeDiv.style.fontWeight = "bold";

            if (btnCerrarSesion) {
                btnCerrarSesion.style.display = "inline-block";
            }
        } else {
            // Si no hay sesión activa, ocultar botón si existe
            if (btnCerrarSesion) {
                btnCerrarSesion.style.display = "none";
            }
        }
    }

    if (btnCerrarSesion) {
        btnCerrarSesion.addEventListener("click", function () {
            sessionStorage.removeItem("emailCliente");
            window.location.href = "login.html";
        });
    }


    // === FORMULARIO CONTACTO ===
    const formContacto = document.getElementById("form-contacto");
    if (formContacto) {
        const mensajeContacto = document.createElement("div");
        formContacto.appendChild(mensajeContacto);

        formContacto.addEventListener("submit", async function (e) {
            e.preventDefault();

            const nombre = document.getElementById("nombre").value.trim();
            const email = document.getElementById("email").value.trim();
            const telefono = document.getElementById("telefono").value.trim();
            const mensaje = document.getElementById("mensaje").value.trim();

            mensajeContacto.textContent = "";
            mensajeContacto.style.color = "";
            mensajeContacto.style.backgroundColor = "";

            if (!nombre || !email || !mensaje) {
                mensajeContacto.textContent = "❌ Nombre, correo y mensaje son obligatorios";
                mensajeContacto.style.color = "white";
                mensajeContacto.style.backgroundColor = "red";
                return;
            }

            try {
                const response = await fetch("http://localhost:8081/api/contacto", {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify({ nombre, email, telefono, mensaje })
                });

                if (response.ok) {
                    
                    mensajeContacto.textContent = "✅ Mensaje enviado con éxito";
                    mensajeContacto.style.color = "white";
                    mensajeContacto.style.backgroundColor = "green";
                    formContacto.reset();
                } else {
                    const errorText = await response.text();
                    mensajeContacto.textContent = "❌ Error: " + errorText;
                    mensajeContacto.style.color = "white";
                    mensajeContacto.style.backgroundColor = "red";
                }
            } catch (error) {
                mensajeContacto.textContent = "❌ Error de conexión con el servidor";
                mensajeContacto.style.color = "white";
                mensajeContacto.style.backgroundColor = "red";
                console.error(error);
            }
        });
    }
//Recuperación de correo//

document.addEventListener("DOMContentLoaded", function () {
    const formRecuperacion = document.getElementById("formRecuperacion");
    const mensajeRecuperacionDiv = document.getElementById("mensaje-recuperacion");

    if (!formRecuperacion) return;

    formRecuperacion.addEventListener("submit", function(e) {
        e.preventDefault();

        const email = document.getElementById("emailRecuperacion").value.trim();

        if (!email) {
            mensajeRecuperacionDiv.textContent = "❌ Por favor ingrese su correo electrónico";
            mensajeRecuperacionDiv.style.color = "white";
            mensajeRecuperacionDiv.style.backgroundColor = "red";
            return;
        }

        // Aquí puedes agregar lógica para enviar el correo más adelante

        mensajeRecuperacionDiv.textContent = "✅ Mensaje enviado con éxito. Revise su correo.";
        mensajeRecuperacionDiv.style.color = "white";
        mensajeRecuperacionDiv.style.backgroundColor = "green";

        formRecuperacion.reset();
    });
});

// =========================
// Funciones auxiliares
// =========================
function mostrarError(mensaje, div) {
    div.textContent = mensaje;
    div.style.color = "white";
    div.style.backgroundColor = "red";
    alert(mensaje);
}

function mostrarExito(mensaje, div) {
    div.textContent = mensaje;
    div.style.color = "white";
    div.style.backgroundColor = "green";
    alert(mensaje);
}







