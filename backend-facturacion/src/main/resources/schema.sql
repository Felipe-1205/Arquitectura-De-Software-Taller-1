CREATE TABLE IF NOT EXISTS facturas (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  pedido_id BIGINT NOT NULL,
  costo DOUBLE PRECISION NOT NULL
);