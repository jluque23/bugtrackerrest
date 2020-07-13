package com.jluque.sprinboot.backend.apirest.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jluque.sprinboot.backend.apirest.models.entity.Producto;
import com.jluque.sprinboot.backend.apirest.models.entity.Publicacion;
import com.jluque.sprinboot.backend.apirest.models.services.IPublicacionService;
import com.jluque.sprinboot.backend.apirest.models.services.IUploadFileService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PublicacionRestController {

	@Autowired
	private IPublicacionService publicacionService;
	
	@Autowired
	private IUploadFileService uploadService;
	
	@GetMapping("/publicaciones")
	public List<Publicacion> index() {
		return publicacionService.findAll();
	}
	
	@GetMapping("/publicaciones/page/{page}")
	@ResponseStatus(HttpStatus.OK)
	public Page<Publicacion> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 15);
		return publicacionService.findAll(pageable);
	}
	
	@GetMapping("/publicaciones/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Publicacion show(@PathVariable Long id) {
		return publicacionService.findById(id);
	}
		
	//@Secured({"ROLE_ADMIN"})
	@PostMapping("/publicaciones")
	public ResponseEntity<?> create(@RequestParam("archivo") MultipartFile archivo, @RequestBody Publicacion publicacion) {
		
		Map<String, Object> response = new HashMap<>();
		
		publicacionService.save(publicacion);
		
		System.out.println("Este es el valor del id publicacion antes de empezar a guardar la imagen" + publicacion.getId() );
		
		if (!archivo.isEmpty()) {
			
			String nombreArchivo = null;
			
			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen de la publicacion");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String nombreFotoAnterior = publicacion.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);

			publicacion.setFoto(nombreArchivo);

			publicacionService.save(publicacion);

			response.put("producto", publicacion);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
