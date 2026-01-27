package es.etg.daw.dawes.thym.productos.infraestructure.api.dto;

import es.etg.daw.dawes.thym.productos.domain.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoRequest {
    private int categoria;
    private String nombre;
    private double precio;
    

    public ProductoRequest(Producto p) {
        this(1, p.getNombre(), p.getPrecio());
    }

}

