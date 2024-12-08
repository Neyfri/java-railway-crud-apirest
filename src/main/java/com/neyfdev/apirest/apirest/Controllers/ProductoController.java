package com.neyfdev.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neyfdev.apirest.apirest.Entities.Producto;
import com.neyfdev.apirest.apirest.Repositories.ProductoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping()
    public List<Producto> traerProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto traeProductoPorId(@PathVariable Long id){
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con ID: " + id));
    }
    
    @PostMapping()
    public Producto crearProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto modificarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto){
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con ID: " + id));

        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con ID: " + id));

        productoRepository.delete(producto);

        return "El producto con ID: " + id + " Eliminado correctamente";
    }
}
