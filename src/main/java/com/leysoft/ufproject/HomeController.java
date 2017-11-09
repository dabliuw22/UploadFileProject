package com.leysoft.ufproject;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.slugify.Slugify;
import com.leysoft.ufproject.converter.inter.FileConverter;
import com.leysoft.ufproject.converter.inter.NoticiaConverter;
import com.leysoft.ufproject.entity.ImagenContenedor;
import com.leysoft.ufproject.entity.Noticia;
import com.leysoft.ufproject.service.inter.NoticiaService;
import com.leysoft.ufproject.validator.ImagenValidator;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired @Qualifier("noticiaService")
	private NoticiaService noticiaService;
	
	@Autowired @Qualifier("fileConverter")
	private FileConverter fileConverter; 
	
	@Autowired @Qualifier("noticiaConverter")
	private NoticiaConverter noticiaConverter;
	
	@Autowired
	private ImagenValidator validator;
	
	private Slugify slugify;
	
	@InitBinder("ImagenContenedor")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("noticias", noticiaConverter.entityToModel(noticiaService.findAll()));
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("noticia", new Noticia());
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addNoticia(@Valid @ModelAttribute("noticia") Noticia noticia,
			BindingResult result) {
		if(!result.hasErrors()) {
			slugify = new Slugify();
			String slug = slugify.slugify(noticia.getTitulo());
			noticia.setSlug(slug);
			noticiaService.save(noticia);
			return "redirect:/add-imagen/"+noticia.getId();
		}
		return "home";
	}
	
	@RequestMapping(value = "/add-imagen/{id}", method = RequestMethod.GET)
	public String addImgen(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("noticia", noticiaService.findById(id));
		model.addAttribute("imagen", new ImagenContenedor());
		return "add-imagen";
	}
	@RequestMapping(value = "/add-imagen/{id}", method = RequestMethod.POST)
	public String addImgen(@Valid @ModelAttribute("imagen") ImagenContenedor imagen, 
			@PathVariable("id") Integer id, BindingResult result, 
			Model model) throws IOException {
		validator.validate(imagen, result);
		if(!result.hasErrors()) {
			System.out.println(imagen.getFile().getContentType());
			Noticia noticia = noticiaService.findById(id);
			noticia.setImagen(fileConverter.fileToByte(imagen.getFile()));
			noticia.setNombreImagen(imagen.getFile().getOriginalFilename());
			noticia.setTipoImagen(imagen.getFile().getContentType());
			//noticia.setEncode(Base64.getEncoder().encodeToString(noticia.getImagen()));
			noticiaService.update(noticia);
			return "redirect:/";
		}
		return "add-imagen";
	}
	
	@RequestMapping(value = "/noticia/imagen/{nombre-imagen}/{id}", method = RequestMethod.GET)
	public void getImagen(@PathVariable("nombre-imagen") String nombreImagen, 
			@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
		Noticia noticia = noticiaService.findById(id);
		if(noticia != null) {
			response.setHeader("Content-Type", noticia.getTipoImagen());
			response.getOutputStream().write(noticia.getImagen());
		}
	}
}
