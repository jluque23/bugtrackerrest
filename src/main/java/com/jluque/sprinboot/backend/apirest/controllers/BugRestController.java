package com.jluque.sprinboot.backend.apirest.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jluque.sprinboot.backend.apirest.models.entity.Bug;
import com.jluque.sprinboot.backend.apirest.models.services.IBugService;
import com.jluque.sprinboot.backend.apirest.models.services.IUploadFileService;

//@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5000", "*" })
@CrossOrigin()
@RestController
@RequestMapping("/api")
public class BugRestController {

	@Autowired
	private IBugService bugService;

	@Autowired
	private IUploadFileService uploadService;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/bugs")
	@ResponseStatus(HttpStatus.OK)
	public List<Bug> index() {
		return bugService.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/bugs/page/{page}")
	@ResponseStatus(HttpStatus.OK)
	public Page<Bug> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 32);
		return bugService.findAll(pageable);
	}

//	@Secured({"ROLE_ADMIN","ROLE_USER"})
//	@GetMapping("/bugs/{id}")
//	@ResponseStatus(HttpStatus.OK)
//	public Bug show(@PathVariable Long id) {
//		return bugService.findById(id);
//	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/bugs/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Bug bug = null;

		Map<String, Object> response = new HashMap<>();

		try {
			bug = bugService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (bug == null) {
			response.put("mensaje", "El Bug ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Bug>(bug, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/bugs")
	@ResponseStatus(HttpStatus.CREATED)
	public Bug crear(@RequestBody Bug bug) {
		bug.setEnabled(true);
		return bugService.save(bug);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/bugs/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();

		Bug bug = bugService.findById(id);

		if (!archivo.isEmpty()) {

			String nombreArchivo = null;

			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del bug");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String nombreFotoAnterior = bug.getFoto();

			uploadService.eliminar(nombreFotoAnterior);

			bug.setFoto(nombreArchivo);

			bugService.save(bug);

			response.put("bug", bug);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured({ "ROLE_ADMIN" })
	@PutMapping("/bugs/{id}")
	public ResponseEntity<?> update(@RequestBody Bug bug, @PathVariable Long id) {
		Bug bugActual = bugService.findById(id);
		Bug bugUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (bugActual == null) {
			response.put("mensaje", "Error: no se pudo editar, El bug ID: "
					.concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			bugActual.setEnabled(bug.isEnabled());
			bugActual.setDescripcion(bug.getDescripcion());
			bugActual.setTitle(bug.getTitle());

			bugUpdated = bugService.save(bugActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Bug ha sido actualizado con exito");
		response.put("bug", bugUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
