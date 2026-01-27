package es.etg.daw.dawes.thym.productos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Producto {
    public Producto() {
    }
    private ProductoId id;
    private String nombre;
    private Double precio;

}
