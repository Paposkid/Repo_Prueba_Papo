package cl.clarochile.aplicaciones.evalcrediticia.business;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cl.clarochile.aplicaciones.evalcrediticia.form.CategoriaForm;
import cl.clarochile.aplicaciones.evalcrediticia.to.CategoriaTO;

/**
 * CategoriaBusiness es una interface donde se encuentran todos los metodos a
 * ser implementados en la clase CategoriaBusinessImpl.
 * 
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 19/03/2013
 * @version 1.0
 */
public interface CategoriaBusiness {

	/**
	 * Método que permite insertar una categoria.
	 * 
	 * @param categoriaTO
	 * @throws Exception
	 */
	public void insertarCategoria(CategoriaTO categoriaTO) throws Exception;

	/**
	 * Método que permite actualizar una categoria.
	 * 
	 * @param categoriaTO
	 * @throws Exception
	 */
	public void actualizarCategoria(CategoriaTO categoriaTO) throws Exception;

	/**
	 * Método que permite listar las categorias.
	 * 
	 * @param categoriaTO
	 * @return List<CategoriaTO>
	 * @throws Exception
	 */
	public List<CategoriaTO> listarCategorias(CategoriaTO categoriaTO) throws Exception;

	/**
	 * Método que permite obtener una categoria por código.
	 * 
	 * @param categoriaTO
	 * @return CategoriaTO
	 * @throws Exception
	 */
	public CategoriaTO obtenerCategoriaPorCodigo(CategoriaTO categoriaTO) throws Exception;

	/**
	 * @param categoriaForm
	 * @return HSSFWorkbook
	 * @throws Exception
	 */
	public HSSFWorkbook generarReporte(CategoriaForm categoriaForm) throws Exception;
	
	public List<CategoriaTO> listarCategorias2(CategoriaTO categoriaTO) throws Exception;

}
