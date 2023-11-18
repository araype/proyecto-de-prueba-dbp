document.addEventListener('DOMContentLoaded', function () {
    const publicationForm = document.getElementById('publicationForm');
    const publicationsContainer = document.getElementById('publications');

    // Manejar el envío del formulario de publicación
    publicationForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const category = document.getElementById('category').value;
        const title = document.getElementById('title').value;
        const description = document.getElementById('description').value;
        const image = document.getElementById('image').value; // Cambio de "file" a "image"

        // Crea una nueva publicación y muestra en la interfaz de usuario
        createPublication(category, title, description, image);

        // Limpiar el formulario
        publicationForm.reset();
    });

    function createPublication(category, title, description, image) {
        const newPublication = document.createElement('div');
        newPublication.className = 'publication';
        newPublication.innerHTML = `
      <h3>${title}</h3>
      <p>Categoría: ${category}</p>
      <p>${description}</p>
      <img src="${image}" alt="Imagen de la publicación">
      <div class="like-count">Me gusta: 0</div>
      <button class="reactButton">Me gusta</button>
      <button class="reactButton">No me gusta</button>
    `;

        publicationsContainer.appendChild(newPublication);
    }

    publicationsContainer.addEventListener('click', function (event) {
        if (event.target.classList.contains('reactButton')) {
            // Aquí puedes implementar la lógica de "Me gusta" y contar los likes.
        }
    });

    // Ejemplo de carga de publicaciones existentes (deberás obtener estas publicaciones desde el servidor)
    createPublication("Comportamiento Humano", "El aprendizaje", "Apuntes sobre la clase el aprendizaje y del psicoanálisis", "https://i.ibb.co/9n2R7DR/Whats-App-Image-2023-10-25-at-3-04-19-PM-2.jpg");
    createPublication("Comportamiento Humano", "El aprendizaje", "Apuntes sobre la clase el aprendizaje y del psicoanálisis", "https://i.ibb.co/CQS8WRS/Whats-App-Image-2023-10-25-at-3-04-19-PM.jpg");
    createPublication("Comportamiento Humano", "Etapasa psicosexuales", "Apuntes sobre la clase el aprendizaje y del psicoanálisis", "https://i.ibb.co/crGfY9w/Whats-App-Image-2023-10-25-at-3-04-19-PM-1.jpg");
});
