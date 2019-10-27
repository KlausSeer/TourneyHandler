package com.tourneyhandler.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tourneyhandler.entities.Format;
import com.tourneyhandler.service.IFormatService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/formats")
@Api(tags="Format", value="Servicio Web RESTFull de Formats")
public class FormatController {
	
	@Autowired
	private IFormatService formatService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Formats", notes="Servicio para listar todos los formats")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Formats encontrados"),
			@ApiResponse(code=404, message="Formats no encontrados")
	})	
	public ResponseEntity<List<Format>> findAll(){
		try {
			List<Format> formats = new ArrayList<>();
			formats = formatService.findAll();
			return new ResponseEntity<List<Format>>(formats, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Format>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Buscar Format por Id", notes="Servicio para buscar un format por Id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Format encontrado"),
			@ApiResponse(code=404, message="Format no encontrado")
	})
	public ResponseEntity<Format> findById(@PathVariable("id") Integer id){
		try {
			Optional<Format> format= formatService.findById(id);
			if(!format.isPresent()) {
				return new ResponseEntity<Format>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Format>(format.get(), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Format>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Crear Format", notes="Servicio para crear un nuevo format")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Format creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")
	})
	public ResponseEntity<Format> insertFormat(@Valid @RequestBody Format format){
		try {
			Format formatNew = new Format();
			formatNew = formatService.save(format);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(formatNew.getId()).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception e) {
			return new ResponseEntity<Format>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	@ApiOperation(value="Actualizar Format", notes="Servicio para actualizar un format")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Format actualizado correctamente"),
			@ApiResponse(code=404, message="Format no encontrado")
	})
	public ResponseEntity<Format> updateFormat(@Valid @RequestBody Format format){
		try {
			formatService.save(format);			
			return new ResponseEntity<Format>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Format>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Eliminar Format", notes="Servicio para eliminar un format")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Format eliminado correctamente"),
			@ApiResponse(code=404, message="Format no encontrado")
	})
	public ResponseEntity<Format> deleteFormat(@PathVariable("id") Integer id){
		try {
			Optional<Format> format= formatService.findById(id);
			if(!format.isPresent()) {
				return new ResponseEntity<Format>(HttpStatus.NOT_FOUND);
			}
			formatService.deleteById(id);
			return new ResponseEntity<Format>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Format>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
