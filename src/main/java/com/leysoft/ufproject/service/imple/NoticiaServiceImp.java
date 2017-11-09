package com.leysoft.ufproject.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leysoft.ufproject.entity.Noticia;
import com.leysoft.ufproject.repository.inter.NoticiaRepository;
import com.leysoft.ufproject.service.inter.NoticiaService;

@Service("noticiaService")
public class NoticiaServiceImp implements NoticiaService {
	
	@Autowired @Qualifier("noticiaRepository")
	private NoticiaRepository noticiaRepository;

	@Override
	public void save(Noticia noticia) {
		noticiaRepository.save(noticia);
	}

	@Override
	public Noticia findById(Integer id) {
		return noticiaRepository.findById(id);
	}

	@Override
	public List<Noticia> findAll() {
		return noticiaRepository.findAll();
	}

	@Override
	public void update(Noticia noticia) {
		noticiaRepository.update(noticia);

	}

	@Override
	public void delete(Integer id) {
		noticiaRepository.delete(id);
	}
}