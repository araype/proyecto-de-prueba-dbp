function functionlogin() {
    fetch("http://127.0.0.1:8080/api/auth/signin")
        .then(response => {
            if (response.ok) {
                // La solicitud de inicio de sesión fue exitosa, redirige a la página "prehome"
                window.location.href = "/prehome"; // Cambia "/prehome" por la URL real de tu página "prehome"
            } else {
                // Manejar errores si es necesario
                console.error("Error en la solicitud de inicio de sesión");
            }
        })
        .catch(error => {
            console.error("Error en la solicitud de inicio de sesión:", error);
        });
}
