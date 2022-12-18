proyecto desarrollado de acuerdo a los requerimientos en java web 8 nativo con maven
Base de datos en mysql

Consultas sql

Producto con mas stock
SELECT * FROM tbl_producto t WHERE t.stock_producto = ( SELECT MAX( stock_producto ) FROM tbl_producto); 
Producto mas vendido
SELECT id_producto, SUM(cantidad_venta) as Cantidad FROM tbl_venta GROUP BY id_producto