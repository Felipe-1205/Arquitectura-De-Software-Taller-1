# Arquitectura de Software - Taller 1

## 📂 Estructura del Proyecto
Arquitectura-De-Software-Taller-1-main/
├── backend-facturacion # Microservicio de facturación (Kotlin/Spring)
├── backend-pedidos # Microservicio de pedidos (Kotlin/Spring)
├── frontend-blazor # Frontend en Blazor (C#/.NET)
├── docker-compose.yml # Configuración Docker
└── README.md # Documentación
## ⚙️ Requisitos
- Docker Desktop 4.25+ ([Descargar](https://www.docker.com/products/docker-desktop/))
- 4 GB de RAM libre

## 🚀 Despliegue Rápido
1. **Iniciar Docker Desktop**
2. **Ejecutar en terminal:**
cd Arquitectura-De-Software-Taller-1-main
docker compose up --build
## 🌐 Acceso a Servicios
Frontend Blazor: http://localhost:5000
API Pedidos: http://localhost:8081/pedidos
API Facturación: http://localhost:8082/facturas
RabbitMQ Manager: http://localhost:15672 (user/password)
Consola H2 (Pedidos): http://localhost:9091 (admin/admin123)
Consola H2 (Facturación): http://localhost:9092 (admin/admin123)

Las bases de datos se inicializan automáticamente con los scripts ubicados en backend-*/src/main/resources/schema.sql. Para acceso manual:

## Comandos Útiles
# Detener servicios
docker compose down
# Limpiar todo (volúmenes + imágenes)
docker compose down -v --rmi all
# Ver logs específicos
docker compose logs backend-pedidos
# Reconstruir imágenes
docker compose build --no-cache
