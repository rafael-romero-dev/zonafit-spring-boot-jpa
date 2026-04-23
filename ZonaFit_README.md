# 💪 ZonaFit GYM — Sistema de Gestión de Gimnasio

> Aplicación de consola desarrollada en Java con Spring Boot que permite
> gestionar los clientes de un gimnasio mediante un CRUD completo,
> conectada a MySQL a través de Spring Data JPA con arquitectura en capas.

---

## 🛠️ Tecnologías

| Capa | Tecnología |
|------|------------|
| Lenguaje | Java 21 |
| Framework | Spring Boot 4.0.3 |
| Persistencia | Spring Data JPA + Hibernate |
| Base de Datos | MySQL |
| Conector BD | MySQL Connector/J |
| Boilerplate | Lombok |
| Build | Maven |
| IDE | IntelliJ IDEA |

---

## 🏗️ Arquitectura

```
src/main/java/gm/zona_fit/
├── modelo/
│   └── Cliente.java             # Entidad JPA mapeada a tabla Cliente
├── repositorio/
│   └── ClienteRepositorio.java  # Repositorio JPA (extiende JpaRepository)
├── Servicio/
│   ├── IClienteServicio.java    # Interfaz del servicio
│   └── ClienteServicio.java     # Implementación con @Service
└── ZonaFitApplication.java      # Punto de entrada + menú de consola (CommandLineRunner)
```

- **Arquitectura en capas**: Modelo → Repositorio → Servicio → Aplicación
- **Patrón Repository** con Spring Data JPA (sin SQL manual)
- **Inyección de dependencias** con `@Autowired`
- **Aplicación de consola** sin servidor web (`spring.main.web-application-type=none`)
- **Logging** con SLF4J + Logback en todas las operaciones

---

## 🗄️ Base de Datos

### 📌 Nombre: `zona_fit_db`

**Tabla: `Cliente`**

| Campo | Tipo | Descripción |
|-------|------|-------------|
| `idCliente` | INT (PK, AUTO_INCREMENT) | Identificador único del cliente |
| `nombre` | VARCHAR | Nombre del cliente |
| `apellido` | VARCHAR | Apellido del cliente |
| `membresia` | INT | Número o tipo de membresía |

> La estrategia DDL está en `none` — la base de datos debe existir previamente.

---

## ⚙️ Funcionalidades

El menú de consola ofrece las siguientes operaciones:

| Opción | Descripción |
|--------|-------------|
| 1 | Listar todos los clientes registrados |
| 2 | Buscar cliente por ID |
| 3 | Agregar nuevo cliente |
| 4 | Modificar datos de un cliente existente |
| 5 | Eliminar cliente por ID |
| 6 | Salir de la aplicación |

---

## 🚀 Cómo ejecutar

### Requisitos previos
- Java 21+
- Maven 3.8+
- MySQL corriendo localmente en el puerto `3306`

### 1. Clona el repositorio
```bash
git clone https://github.com/rafael-romero-dev/zonafit-spring-boot-jpa.git
cd zonafit-spring
```

### 2. Crea la base de datos en MySQL
```sql
CREATE DATABASE zona_fit_db;
USE zona_fit_db;

CREATE TABLE Cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre    VARCHAR(100) NOT NULL,
    apellido  VARCHAR(100) NOT NULL,
    membresia INT          NOT NULL
);
```

### 3. Configura la contraseña de MySQL

Abre `src/main/resources/application.properties` y reemplaza la contraseña:

```properties
spring.datasource.password=tu_password_aqui
```

O bien, usa una variable de entorno (recomendado):
```bash
export DB_PASSWORD=tu_password_aqui
```

### 4. Compila y ejecuta
```bash
mvn spring-boot:run
```

---

## 🔐 Seguridad y configuración

- La contraseña de la BD usa variable de entorno `${DB_PASSWORD:fallback}` para no exponerla en el código
- `spring.jpa.show-sql=false` — las queries SQL no se imprimen en producción
- `PhysicalNamingStrategyStandardImpl` — Hibernate respeta los nombres de columna tal como se definen en la entidad sin convertirlos a snake_case

---

## 👤 Autor

**Rafael Romero Negrete**  
Ingeniero en Sistemas Computacionales — Instituto Tecnológico de Cuautla

- LinkedIn: [linkedin.com/in/rafael-romero2110](https://linkedin.com/in/rafael-romero2110)
- GitHub: [github.com/rafael-romero-dev](https://github.com/rafael-romero-dev)
