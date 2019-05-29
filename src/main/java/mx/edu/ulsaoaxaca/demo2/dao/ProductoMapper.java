package mx.edu.ulsaoaxaca.demo2.dao;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import mx.edu.ulsaoaxaca.demo2.model.Producto;

/**
 * ProductoMapper
 */
@Mapper
public interface ProductoMapper {

    @Select("select id, nombre, categoria_id, cantidad from producto")
    public List<Producto> findAll();
    
    @Insert("insert into producto(nombre, categoria_id, cantidad) values(#{nombre}, #{categoria_id}, #{cantidad})")
    public void insert(@Param("nombre") String nombre, @Param("categoria_id") Integer categoria_id, @Param("cantidad") Integer cantidad);
}