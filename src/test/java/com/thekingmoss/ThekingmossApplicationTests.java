package com.thekingmoss;

import com.thekingmoss.application.dto.categoria.CategoriaResponseDto;
import com.thekingmoss.application.dto.producto.ProductoRequestDto;
import com.thekingmoss.application.dto.producto.ProductoResponseDto;
import com.thekingmoss.application.service.ICategoriaService;
import com.thekingmoss.application.service.IProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ThekingmossApplicationTests {

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private IProductoService productoService;


    @Test
    void listarCategorias() {
        List<CategoriaResponseDto> categorias = categoriaService.listarCategorias();

        assertNotNull(categorias);
    }


    @Test
    void listarProductos() {
    }


    @Test
    void categoriaServiceNoEsNulo() {
        assertNotNull(categoriaService);
    }




    @Test
    void crearProductoConDatosReales() {

        ProductoRequestDto request = new ProductoRequestDto();
        request.setNombreProducto("Producto Test");
        request.setStock(10);
        request.setPrecioUnitario(new BigDecimal("25.50"));
        request.setDescuento(new BigDecimal("0.00"));
        request.setDescripcion("Producto creado desde prueba unitaria");
        request.setTamanio("M");
        request.setPeso(new BigDecimal("1.00"));
        request.setCategoriaId(1L);

        ProductoResponseDto producto = productoService.crearProducto(request);

        assertNotNull(producto);
        assertEquals("Producto Test", producto.getNombreProducto());
    }


}