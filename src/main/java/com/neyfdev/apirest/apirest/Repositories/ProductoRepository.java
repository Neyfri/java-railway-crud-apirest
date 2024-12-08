package com.neyfdev.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neyfdev.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
