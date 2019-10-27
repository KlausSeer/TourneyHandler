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

import com.tourneyhandler.entities.Phase;
import com.tourneyhandler.service.IPhaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/phases")
@Api(tags="Phase", value="Servicio Web RESTFull de Phases")
public class PhaseController {
	
	@Autowired
	private IPhaseService phaseService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Phases", notes="Servicio para listar todos los phases")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Phases encontrados"),
			@ApiResponse(code=404, message="Phases no encontrados")
	})	
	public ResponseEntity<List<Phase>> findAll(){
		try {
			List<Phase> phases = new ArrayList<>();
			phases = phaseService.findAll();
			return new ResponseEntity<List<Phase>>(phases, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Phase>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Buscar Phase por Id", notes="Servicio para buscar un phase por Id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Phase encontrado"),
			@ApiResponse(code=404, message="Phase no encontrado")
	})
	public ResponseEntity<Phase> findById(@PathVariable("id") Integer id){
		try {
			Optional<Phase> phase= phaseService.findById(id);
			if(!phase.isPresent()) {
				return new ResponseEntity<Phase>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Phase>(phase.get(), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Phase>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Crear Phase", notes="Servicio para crear un nuevo phase")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Phase creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")
	})
	public ResponseEntity<Phase> insertPhase(@Valid @RequestBody Phase phase){
		try {
			Phase phaseNew = new Phase();
			phaseNew = phaseService.save(phase);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(phaseNew.getId()).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception e) {
			return new ResponseEntity<Phase>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	@ApiOperation(value="Actualizar Phase", notes="Servicio para actualizar un phase")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Phase actualizado correctamente"),
			@ApiResponse(code=404, message="Phase no encontrado")
	})
	public ResponseEntity<Phase> updatePhase(@Valid @RequestBody Phase phase){
		try {
			phaseService.save(phase);			
			return new ResponseEntity<Phase>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Phase>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Eliminar Phase", notes="Servicio para eliminar un phase")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Phase eliminado correctamente"),
			@ApiResponse(code=404, message="Phase no encontrado")
	})
	public ResponseEntity<Phase> deletePhase(@PathVariable("id") Integer id){
		try {
			Optional<Phase> phase= phaseService.findById(id);
			if(!phase.isPresent()) {
				return new ResponseEntity<Phase>(HttpStatus.NOT_FOUND);
			}
			phaseService.deleteById(id);
			return new ResponseEntity<Phase>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Phase>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
