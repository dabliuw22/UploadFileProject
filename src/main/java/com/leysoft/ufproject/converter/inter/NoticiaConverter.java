package com.leysoft.ufproject.converter.inter;

import java.util.List;

import com.leysoft.ufproject.entity.Noticia;
import com.leysoft.ufproject.model.NoticiaModel;

public interface NoticiaConverter {
	
	public NoticiaModel entityToModel(Noticia noticia);
	
	public Noticia modelToEntity(NoticiaModel noticiaModel);
	
	public List<NoticiaModel> entityToModel(List<Noticia> noticias);
}
