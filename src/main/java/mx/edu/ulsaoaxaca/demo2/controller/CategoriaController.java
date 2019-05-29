package mx.edu.ulsaoaxaca.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.ulsaoaxaca.demo2.dao.CategoriaMapper;
import mx.edu.ulsaoaxaca.demo2.model.Categoria;

@RequestMapping("/categoria")
@RestController
public class CategoriaController {

	@Autowired
	private CategoriaMapper categoriaMapper;
	
	@GetMapping("/todas")
	public List<Categoria> todas() {
		return categoriaMapper.findAll();
	}
	
	@PostMapping("/nueva")
	public List<Categoria> nueva(@RequestParam("nombre") String nombre) {
		categoriaMapper.insert(nombre);
		return categoriaMapper.findAll();
	}
	
	
}
