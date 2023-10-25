document
  .getElementById("register-form")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // Esto previene el comportamiento por defecto del formulario (no se recargará la página).

    const username = document.querySelector(
      'input[placeholder="Usuario"]'
    ).value;
    const fullname = document.querySelector(
      'input[placeholder="Nombre"]'
    ).value;
    const password = document.querySelector(
      'input[placeholder="Contraseña"]'
    ).value;
    const email = document.querySelector(
      'input[placeholder="Correo Electrónico"]'
    ).value;

    const userData = {
      username: username,
      fullname: fullname,
      password: password,
      email: email,
    };

    fetch("/user", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(userData),
    })
      .then((response) => response.json())
      .then((data) => {
        if (data && data.id) {
          alert("Usuario registrado con éxito!");
        } else {
          alert("Error al registrar el usuario.");
        }
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("Ocurrió un error al intentar registrar al usuario.");
      });
  });

