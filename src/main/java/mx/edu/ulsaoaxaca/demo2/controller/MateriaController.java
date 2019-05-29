package mx.edu.ulsaoaxaca.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.ulsaoaxaca.demo2.dao.MateriaMapper;
import mx.edu.ulsaoaxaca.demo2.model.Materia;
import mx.edu.ulsaoaxaca.demo2.model.Pregunta;

@RequestMapping("/materia")
@RestController
public class MateriaController {

	@Autowired
	private MateriaMapper categoriaMapper;
	
	@GetMapping("/todas")
	public List<Materia> todas() {
		return categoriaMapper.findAll();
	}
	
	@PostMapping("/nueva")
	public List<Materia> nueva(@RequestParam("nombre") String nombre) {
		categoriaMapper.insert(nombre);
		return categoriaMapper.findAll();
	}
	
	
}