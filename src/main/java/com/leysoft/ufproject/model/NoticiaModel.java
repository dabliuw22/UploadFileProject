package com.leysoft.ufproject.model;

public class NoticiaModel {
	
	private Integer id;
	
	private String titulo;
	
	private String slug;
	
	private String resumen;
	
	private String contenido;
	
	private byte[] imagen;
	
	private String nombreImagen;
	
	private String tipoImagen;
	
	private String encode;

	public NoticiaModel() {}

	public NoticiaModel(Integer id, String titulo, String slug, String resumen, String contenido, byte[] imagen,
			String nombreImagen, String tipoImagen, String encode) {
		this.id = id;
		this.titulo = titulo;
		this.slug = slug;
		this.resumen = resumen;
		this.contenido = contenido;
		this.imagen = imagen;
		this.nombreImagen = nombreImagen;
		this.tipoImagen = tipoImagen;
		this.encode = encode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public String getTipoImagen() {
		return tipoImagen;
	}

	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}
}
