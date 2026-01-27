package es.etg.daw.dawes.thym.productos.infraestructure.api;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import es.etg.daw.dawes.thym.productos.domain.model.Producto;
import es.etg.daw.dawes.thym.productos.domain.model.ProductoId;
import es.etg.daw.dawes.thym.productos.domain.repository.ProductoRepository;
import es.etg.daw.dawes.thym.productos.infraestructure.api.dto.ProductoRequest;
import es.etg.daw.dawes.thym.productos.infraestructure.api.dto.ProductoResponse;
import es.etg.daw.dawes.thym.productos.infraestructure.mapper.ProductoMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestClientProductoAdapter implements ProductoRepository {

    private final RestClient restClient;

    @Override
    public List<Producto> getAll() {
        return ProductoMapper.toDomain(restClient.get()
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductoResponse>>() {
                }));
    }

    @Override
    public Producto save(Producto t) {
        ProductoRequest nuevo = ProductoMapper.toRequest(t);

        ProductoResponse respuesta = restClient.post()
                .contentType(MediaType.APPLICATION_JSON) // Le mandamos un Json
                .body(nuevo) // Los datos de producto a crear
                .retrieve() // Obtenermos los datos
                .body(new ParameterizedTypeReference<ProductoResponse>() {
                }); // Los pasamos a una respuesta de tipo Producto

        return ProductoMapper.toDomain(respuesta);
    }

    @Override
    public Optional<Producto> getById(ProductoId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public void deteteById(ProductoId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deteteById'");
    }
}
