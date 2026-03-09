package com.thekingmoss.domain.repository;

import com.thekingmoss.domain.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICarritoRepository extends JpaRepository<Carrito, Long> {
    List<Carrito> findByUsuarioId(Long usuarioId);
    Optional<Carrito> findByUsuarioIdAndProductoProductoId(Long usuarioId, Long productoId);
    
    // --BY SHE: Usar @Query para asegurar que la eliminación funcione correctamente
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("DELETE FROM Carrito c WHERE c.usuario.id = :usuarioId")
    void deleteByUsuarioId(@Param("usuarioId") Long usuarioId);
}