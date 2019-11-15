/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.rondatel.arbol.repository;

/**
 *
 * @author Gean
 */


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uy.com.rondatel.arbol.domain.CorteRes;

@RepositoryRestResource(path = "defaultCorteCuartoWS")
public interface CorteResRepository extends CrudRepository<CorteRes, Integer> {
    @Query(value = "select * from corte_res c where c.articulo = :articulo and c.res=:corte ", nativeQuery = true)
    List<CorteRes> buscarPorCorteCuarto(@Param("articulo") int articulo,@Param("corte") int corte);
    
}
