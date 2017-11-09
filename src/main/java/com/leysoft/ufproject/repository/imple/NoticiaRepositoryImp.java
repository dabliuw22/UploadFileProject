package com.leysoft.ufproject.repository.imple;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leysoft.ufproject.entity.Noticia;
import com.leysoft.ufproject.repository.inter.NoticiaRepository;

@Repository("noticiaRepository") @Transactional
public class NoticiaRepositoryImp implements NoticiaRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void save(Noticia noticia) {
		sessionFactory.getCurrentSession().save(noticia);
	}

	@Override
	@Transactional(readOnly = true)
	public Noticia findById(Integer id) {
		return (Noticia) sessionFactory.getCurrentSession().get(Noticia.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Noticia> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Noticia.class).list();
	}

	@Override
	@Transactional
	public void update(Noticia noticia) {
		sessionFactory.getCurrentSession().update(noticia);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Noticia noticia = findById(id);
		if(noticia != null) {
			sessionFactory.getCurrentSession().delete(noticia);
		}
	}
}