package mx.edu.ulsaoaxaca.demo2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.edu.ulsaoaxaca.demo2.model.Materia;
import mx.edu.ulsaoaxaca.demo2.model.Pregunta;

@Mapper
public interface MateriaMapper {

	
	@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "nombre", column = "nombre")
     })
	
	@Insert("INSERT into materia(nombre) values(#{nombre}")
	public void insert(@Param("nombre") String nombre);
	
	@Delete("DELETE FROM materia WHERE id =#{id}")
	public void delete(int id);
		
	@Select("SELECT * FROM materia WHERE id=#{id}")
	public List<Materia> findOne(int id);
	
	//public Usuario getUser(@Param("username") String username, @Param("contrasena") String contrasena);
	@Select("select * from materia")
	public List<Materia> findAll();
}
