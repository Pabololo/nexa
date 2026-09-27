# Nexa · Gestión inteligente

Mockup interactivo de escritorio creado con Java 17, JavaFX, FXML y Maven. La aplicación muestra un panel de inventario y un asistente de chat con respuestas simuladas; no usa servicios externos ni una base de datos.

## Requisitos

- JDK 17 o superior instalado.
- Conexión a internet la primera vez para descargar Maven y las dependencias.
- Windows, macOS o Linux con entorno gráfico para abrir la ventana JavaFX.

No hace falta instalar Maven: el proyecto incluye Maven Wrapper.

## Ejecutar

Desde la carpeta del proyecto:

**Windows (PowerShell o CMD):**

```powershell
.\mvnw.cmd clean javafx:run
```

**macOS / Linux:**

```bash
bash ./mvnw clean javafx:run
```

En IntelliJ IDEA también se puede abrir la carpeta que contiene `pom.xml`, esperar a que Maven importe las dependencias y ejecutar `org.example.AppLauncher`.

## Publicar y compartir en GitHub

1. Crea un repositorio vacío en GitHub (sin README ni otros archivos iniciales).
2. Desde una terminal abierta en esta carpeta, inicializa y sube el proyecto. Sustituye la URL por la de tu repositorio:

   ```bash
   git init -b main
   git add .
   git commit -m "Preparar demo JavaFX para GitHub"
   git remote add origin https://github.com/USUARIO/REPOSITORIO.git
   git push -u origin main
   ```

   También puedes abrir esta carpeta con GitHub Desktop y usar **Publish repository**.
3. Comparte el enlace del repositorio. Tus compañeros pueden clonarlo y ejecutar los comandos anteriores.

Incluye el código fuente y Maven Wrapper; excluye `target/` y los archivos locales de IntelliJ. GitHub Actions compila el proyecto automáticamente en Windows, macOS y Linux al subir cambios o abrir un pull request.

## Interacciones de la demo

- Iniciar y cerrar sesión cambia el estado mostrado en la barra superior.
- El menú lateral permite alternar entre Inventario y Chatbot IA.
- Inventario permite añadir productos de prueba, alternar el filtro de stock bajo y mostrar una notificación de exportación.
- Chatbot IA muestra conversaciones de ejemplo y responde con un mensaje simulado al enviar texto.

Los datos son temporales: no se guardan al cerrar la aplicación.
