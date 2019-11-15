/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.rondatel.arbol.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.com.rondatel.arbol.domain.CorteRes;
import uy.com.rondatel.arbol.repository.CorteResRepository;


/**
 *
 * @author Gean
 */
@Component("corteCuartoService")
public class CorteCuartoService {

    private static CorteResRepository corteCuartoRepository;

    @Autowired
    public void setCorteCuartoRepository(CorteResRepository corteCuartoRepository) {
        CorteCuartoService.corteCuartoRepository = corteCuartoRepository;
    }

    public int guardar(CorteRes corteRes) {

        try {
            List<CorteRes> listaCorteCuarto = corteCuartoRepository.buscarPorCorteCuarto(corteRes.getArticulo(), corteRes.getRes());
            if (listaCorteCuarto == null) {
                corteCuartoRepository.save(corteRes);
                return 1;
            } else if (listaCorteCuarto.size() < 2) {
                corteCuartoRepository.save(corteRes);
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            return 500;
        }

    }

    public String borrar(int articulo, int res) {
        String respuesta = "ERROR";

        try {
            List<CorteRes> listaCorteRes = corteCuartoRepository.buscarPorCorteCuarto(articulo, res);
            CorteRes corteResABorrar = null;
            for (CorteRes corteCuarto : listaCorteRes) {
                corteResABorrar = corteCuarto;
                break;
            }
            if (corteResABorrar != null) {
                corteCuartoRepository.delete(corteResABorrar);
            }

            respuesta = "OK";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;
    }

    public CorteCuartoService() {
    }

    public String consultar(int idArticulo, int idRes) {
        List<CorteRes> listaCorteRes = corteCuartoRepository.buscarPorCorteCuarto(idArticulo, idRes);
        if (listaCorteRes == null) {
            return "true";
        } else if (listaCorteRes.size() < 2) {
            return "true";
        } else {
            return "false";
        }
    }
}
