/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.rondatel.arbol.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uy.com.rondatel.arbol.domain.CorteRes;
import uy.com.rondatel.arbol.service.CorteCuartoService;


/**
 *
 * @author Gean
 */
@RestController
@RequestMapping("/arbolWS/corteRes")
public class CorteResController {

    private GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson = gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
    CorteCuartoService ccs = new CorteCuartoService();
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public int guardar(@RequestBody String corteCuartoParam) {
        CorteRes corteRes = gson.fromJson(corteCuartoParam, CorteRes.class);
        return ccs.guardar(corteRes);
    }
    
    @RequestMapping(value = "/borrar")
    public String borrar(@RequestParam(value = "idArticulo") int idArticulo,@RequestParam(value = "idRes") int idRes) {
        
        return ccs.borrar(idArticulo, idRes);
    }
    
    @RequestMapping(value = "/test")
    public String borrar() {
        CorteRes corteRes=new CorteRes();
        corteRes.setArticulo(1);
        corteRes.setRes(1);
        
        
        return gson.toJson(corteRes);
    }
    
    @RequestMapping(value = "/consultar")
    public String consultar(@RequestParam(value = "idArticulo") int idArticulo,@RequestParam(value = "idRes") int idRes) {
        
        return ccs.consultar(idArticulo, idRes);
    }
    
    
    

}
