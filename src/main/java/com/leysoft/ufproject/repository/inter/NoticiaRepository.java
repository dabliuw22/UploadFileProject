package com.leysoft.ufproject.repository.inter;

import java.util.List;

import com.leysoft.ufproject.entity.Noticia;

public interface NoticiaRepository {
	
	public void save(Noticia noticia);
	
	public Noticia findById(Integer id);
	
	public List<Noticia> findAll();
	
	public void update(Noticia noticia);
	
	public void delete(Integer id);
}
