package com.leysoft.ufproject.converter.imple;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Component;

import com.leysoft.ufproject.converter.inter.NoticiaConverter;
import com.leysoft.ufproject.entity.Noticia;
import com.leysoft.ufproject.model.NoticiaModel;

@Component("noticiaConverter")
public class NoticiaConverterImp implements NoticiaConverter {

	@Override
	public NoticiaModel entityToModel(Noticia noticia) {
		NoticiaModel model = new NoticiaModel();
		model.setId(noticia.getId());
		model.setTitulo(noticia.getTitulo());
		model.setResumen(noticia.getResumen());
		model.setContenido(noticia.getContenido());
		model.setSlug(noticia.getSlug());
		model.setImagen(noticia.getImagen());
		model.setNombreImagen(noticia.getNombreImagen());
		model.setTipoImagen(noticia.getTipoImagen());
		model.setEncode(Base64.getEncoder().encodeToString(noticia.getImagen()));
		return model;
	}

	@Override
	public Noticia modelToEntity(NoticiaModel noticiaModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<NoticiaModel> entityToModel(List<Noticia> noticias) {
		List< NoticiaModel> models = new ArrayList<>();
		noticias.forEach(n -> models.add(entityToModel(n)));
		return models;
	}

}
