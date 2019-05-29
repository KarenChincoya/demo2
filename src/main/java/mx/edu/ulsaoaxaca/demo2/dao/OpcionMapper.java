package mx.edu.ulsaoaxaca.demo2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.edu.ulsaoaxaca.demo2.model.Opcion;
import mx.edu.ulsaoaxaca.demo2.model.Pregunta;

@Mapper
public interface OpcionMapper {
	
	@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "idPregunta", column = "idPregunta"),
        @Result(property = "opcion", column = "opcion")
     })
	
	@Insert("INSERT into pregunta(idPregunta, opcion) values(#{idPregunta}, #{opcion}")
	public void insert(Opcion pregunta);
	
	@Delete("DELETE FROM pregunta WHERE id =#{id}")
	public void delete(int id);
		
	@Select("SELECT * FROM pregunta WHERE id=#{id}")
	public List<Opcion> findOne(int id);
	
	//public Usuario getUser(@Param("username") String username, @Param("contrasena") String contrasena);
	@Select("select * from opcion")
	public List<Opcion> findAll();
	
}
