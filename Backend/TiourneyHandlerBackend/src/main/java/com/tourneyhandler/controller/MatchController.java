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

import com.tourneyhandler.entities.Match;
import com.tourneyhandler.service.IMatchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/matchs")
@Api(tags="Match", value="Servicio Web RESTFull de Matchs")
public class MatchController {
	
	@Autowired
	private IMatchService matchService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Matchs", notes="Servicio para listar todos los matchs")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Matchs encontrados"),
			@ApiResponse(code=404, message="Matchs no encontrados")
	})	
	public ResponseEntity<List<Match>> findAll(){
		try {
			List<Match> matchs = new ArrayList<>();
			matchs = matchService.findAll();
			return new ResponseEntity<List<Match>>(matchs, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Match>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Matchs", notes="Servicio para listar todos los matchs")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Matchs encontrados"),
			@ApiResponse(code=404, message="Matchs no encontrados")
	})	
	public ResponseEntity<List<Match>> findAllSorted(){
		try {
			List<Match> matchs = new ArrayList<>();
			matchs = matchService.findAll();
			//Sort
			return new ResponseEntity<List<Match>>(matchs, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Match>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Buscar Match por Id", notes="Servicio para buscar un match por Id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Match encontrado"),
			@ApiResponse(code=404, message="Match no encontrado")
	})
	public ResponseEntity<Match> findById(@PathVariable("id") Integer id){
		try {
			Optional<Match> match= matchService.findById(id);
			if(!match.isPresent()) {
				return new ResponseEntity<Match>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Match>(match.get(), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Match>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Crear Match", notes="Servicio para crear un nuevo match")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Match creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")
	})
	public ResponseEntity<Match> insertMatch(@Valid @RequestBody Match match){
		try {
			Match matchNew = new Match();
			matchNew = matchService.save(match);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(matchNew.getId()).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception e) {
			return new ResponseEntity<Match>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	@ApiOperation(value="Actualizar Match", notes="Servicio para actualizar un match")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Match actualizado correctamente"),
			@ApiResponse(code=404, message="Match no encontrado")
	})
	public ResponseEntity<Match> updateMatch(@Valid @RequestBody Match match){
		try {
			matchService.save(match);			
			return new ResponseEntity<Match>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Match>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Eliminar Match", notes="Servicio para eliminar un match")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Match eliminado correctamente"),
			@ApiResponse(code=404, message="Match no encontrado")
	})
	public ResponseEntity<Match> deleteMatch(@PathVariable("id") Integer id){
		try {
			Optional<Match> match= matchService.findById(id);
			if(!match.isPresent()) {
				return new ResponseEntity<Match>(HttpStatus.NOT_FOUND);
			}
			matchService.deleteById(id);
			return new ResponseEntity<Match>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Match>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
