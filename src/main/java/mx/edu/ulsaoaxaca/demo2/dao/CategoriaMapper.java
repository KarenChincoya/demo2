package mx.edu.ulsaoaxaca.demo2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import mx.edu.ulsaoaxaca.demo2.model.Categoria;

@Mapper
public interface CategoriaMapper {
	
	@Select("Select id, nombre from categoria")
	public List<Categoria> findAll();

	@Insert("insert into categoria(nombre) values(#{nombre})")
	public void insert(@Param("nombre") String nombre);
	
	
}
