# 🌿 TheKingMoss - API REST

**TheKingMoss** es una API RESTful desarrollada con Spring Boot que gestiona un sistema de ventas de diferentes tipos de **musgos**. Permite manejar categorías, productos, pedidos, imágenes y direcciones de nuestros usuarios, con autenticación basada en JWT y control de roles (ADMIN / USER).

---

## 🔧 Tecnologías Utilizadas

- **Lenguaje**: Java 17  
- **Framework**: Spring Boot 3.4.5  
- **Seguridad**: Spring Security + JWT  
- **Base de Datos**: MySQL 8  
- **Dependencias Principales**:
  - **Spring Data JPA**: Para interactuar con la base de datos.
  - **Spring Web**: Para crear APIs RESTful.
  - **Spring Security**: Para autenticación y autorización.
  - **Lombok**: Para reducir código repetitivo (getters, setters, constructores).
  - **MySQL Connector**: Para la conexión con la base de datos MySQL.
- **Herramientas de Desarrollo**:
  - **Spring DevTools**: Para recargar automáticamente cambios durante el desarrollo.
- **Herramientas**:
  - **Postman**: Para pruebas de los endpoints de la API.
- **Librería JWT**:
  - **JJWT**: Para generación y verificación de tokens JWT
 
---

## 🚀 Cómo Configurar y Ejecutar el Proyecto

### Requisitos Previos
- **Java JDK 17**: Para ejecutar el backend.
- **MySQL**: Para la base de datos
- (Opcional) **Postman** para pruebas

---

## ⚙️ Variables de Entorno

El archivo `application.yml` utiliza variables externas para mayor seguridad y flexibilidad.

### ¿Cómo definirlas en IntelliJ IDEA?

1. Ve a `Run > Edit Configurations...`
2. Selecciona tu configuración (por ejemplo: `ThekingmossApplication`)
3. Haz clic en **Modify Options > Add Environment Variables**
4. Agrega las siguientes variables:

| Variable    | Valor de ejemplo            |
|-------------|-----------------------------|
| `PORT`      | `8080`                      |
| `USER_NAME`  | `tu_usuario`               |
| `PASSWORD_DB`  | `tu_contraseña`          |
| `SECRET`    | `claveSegura1234`           |

Estas variables se utilizan automáticamente desde `application.yml` usando el formato `${VARIABLE}`.

---

## 🚀 Instalación y Ejecución
1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/Daniel-JA03/thekingmoss.git
   cd thekingmoss

2. **Configurar la base de datos**:
    - Crear una base de datos MySQL llamada `thekingmoss`.
    - Actualizar las credenciales en `src/main/resources/application.yml  `.   

   ```yml
   spring:
      datasource:
        url: jdbc:mysql://localhost:3306/thekingmoss
        username: ${USER_NAME}
        password: ${PASSWORD_DB}
        driver-class-name: com.mysql.cj.jdbc.Driver
    ```

3. **Ejecutar el proyecto**:

    ```bash
   ./gradlew bootRun
    ```

4. **La API estará disponible en**:

    ```bash
   http://localhost:8080
    ```

---

## 📁 Estructura del Proyecto
```plaintext
thekingmoss/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.thekingmoss
│   │   │       ├── application/       
│   │   │       │   ├── dto/               
│   │   │       │   ├── mapper/             
│   │   │       │   ├── service/            
│   │   │       ├── domain/
│   │   │       │   ├── entity/         
│   │   │       │   ├── repository/     
│   │   │       ├── security/          
│   │   │       │   ├── filter/        
│   │   │       │   ├── util/               
│   │   │       ├── web/
│   │   │       │   ├── config/       
│   │   │       │   ├── controller/     
│   │   │       │   └── exception/      
│   │   │       └── ThekingmossApplication.java 
│   │   └── resources/
│   │       └── application.yml          
├── test/
│   └── ...                              
└── imagesProducts/
    └── default.jpg                     
```

---

## 🔐 Seguridad y Roles

La API implementa autenticación con **JWT (JSON Web Token)**.

- `ROLE_ADMIN`: Acceso completo
- `ROLE_USER`: Acceso limitado

---

## 🌐 Endpoints Principales

| Método | Endpoint | Descripción | Acceso |
|--------|----------|-------------|--------|
| **POST**   | `/api/auth/login` | Iniciar sesión y obtener token JWT | Público |
| **GET**    | `/api/categoria` | Listar categorías de musgos | Público |
| **POST**   | `/api/categoria` | Crear categoría | ADMIN |
| **GET**    | `/api/producto` | Listar productos de musgos | Público |
| **POST**   | `/api/producto` | Crear producto | ADMIN |
| **GET**    | `/api/pedidos` | Listar pedidos | Público |
| **POST**   | `/api/pedidos` | Crear pedido | ADMIN / USER |
| **GET**   | `/api/pedidos/{pedidoId}/detalles` | ver detalles del pedido | ADMIN / USER |
| **POST**   | `/api/pedidos/{pedidoId}/detalles` | Crear detalle del pedido | ADMIN / USER |

---

## 🧪 Colección de Postman

Puedes importar esta colección en Postman para probar todos los endpoints de forma rápida:

📥 [Descargar colección Postman](thekingmoss-postman-collection.json)

> Recuerda usar el token JWT obtenido en el login para autorizar tus peticiones protegidas:

