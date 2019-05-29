package mx.edu.ulsaoaxaca.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.ulsaoaxaca.demo2.dao.ProductoMapper;
import mx.edu.ulsaoaxaca.demo2.model.Producto;


/**
 * ProductoController
 */
@RequestMapping("/producto")
@RestController
public class ProductoController {

    @Autowired
    private ProductoMapper productoMapper;

    @GetMapping("/todas")
    public List<Producto> todas() {
        return productoMapper.findAll();
    }

    @PostMapping("/nueva")
    public List<Producto> nueva(@RequestParam("nombre") String nombre, @RequestParam("categoria_id") Integer categoria_id, @RequestParam("cantidad") Integer cantidad) {
        productoMapper.insert(nombre, categoria_id, cantidad);
        return productoMapper.findAll();
    }
}