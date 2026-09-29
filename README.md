# Caso 1: Inventario y riesgo de quiebre

## 1. Objetivo, actores y alcance

**Objetivo:** Consultar existencias, estimar riesgo de quiebre y recomendar transferencia entre bodegas o compra, con aprobación humana antes de ejecutar.

**Actores:**
- Encargados de bodega.
- Gerente de compras.
- Sistema de compras existente.

**Alcance:** Módulos de inventario, pronóstico, recomendaciones, aprobación y auditoría. Integración con el sistema de compras.

## 2. Requisitos funcionales y de calidad

**Funcionales:**
- Consultar existencias por producto y bodega.
- Estimar riesgo de quiebre.
- Generar recomendación de transferencia o compra.
- Permitir aprobación o rechazo humano.
- Registrar auditoría de cada acción.
- Integrarse con el sistema de compras.

**Calidad:**
- Disponibilidad.
- Trazabilidad.
- Tiempo de respuesta adecuado.
- Consistencia de datos.

## 3. Diagramas C4

**Contexto:** Usuario (encargado) → Sistema de Inventario → Sistema de Compras existente.

**Contenedores:** Aplicación web (React), API REST (Spring Boot), Base de datos PostgreSQL, Sistema de compras externo.

## 4. Flujo de una operación crítica

1. Usuario consulta existencias.
2. Sistema calcula riesgo de quiebre.
3. Sistema genera recomendación (transferencia o compra).
4. Usuario aprueba o rechaza.
5. Si se aprueba, se ejecuta la acción (transferencia o compra).
6. Se registra en auditoría.

## 5. Stack propuesto

- Spring Boot (API REST).
- PostgreSQL (base de datos).
- React (interfaz web).
- Docker (contenedores).
- REST (integración).
- RabbitMQ solo si hay procesos asíncronos.
- Redis solo si se justifica caché.

## 6. ADR

**ADR 001: Monolito modular**
Se elige monolito modular porque el equipo es pequeño, el dominio está acoplado y se requiere consistencia transaccional. Permite separar módulos internamente sin la complejidad de microservicios. Si el volumen crece, se puede extraer el módulo de pronóstico como microservicio.

**ADR 002: Spring Boot + PostgreSQL**
Spring Boot por su madurez, ecosistema y facilidad de configuración. PostgreSQL por robustez, soporte transaccional y buen rendimiento.

## 7. Riesgos y mitigaciones

1. **Falla del servicio de pronóstico:** usar último cálculo conocido y notificar.
2. **Recomendaciones erróneas:** aprobación humana obligatoria.
3. **Integración con compras:** usar API REST con reintentos e idempotencia.

## 8. Métricas

- **Negocio:** Reducción de quiebres de stock.
- **Técnica:** Tiempo de aprobación de recomendaciones.
