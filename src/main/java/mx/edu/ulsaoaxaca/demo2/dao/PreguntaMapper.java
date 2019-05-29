package mx.edu.ulsaoaxaca.demo2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.edu.ulsaoaxaca.demo2.model.Pregunta;

@Mapper
public interface PreguntaMapper {
	
	@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "materiaId", column = "materiaId"),
        @Result(property = "pregunta", column = "pregunta"),
        @Result(property = "respuestaCorrecta", column = "respuestaCorrecta")
      })
	
	@Insert("INSERT into pregunta(materiaId, pregunta, respuestaCorrecta) values(materiaId, pregunta, respuestaCorrecta)")
	public void createPregunta(Pregunta pregunta);
	
	@Delete("DELETE FROM pregunta WHERE id =#{id}")
	public void deletePregunta(int id);
		
	@Select("SELECT * FROM pregunta WHERE id=#{id}")
	public List<Pregunta> findOne(int id);
	
	//public Usuario getUser(@Param("username") String username, @Param("contrasena") String contrasena);
	@Select("select * from pregunta")
	public List<Pregunta> findAll();
}
