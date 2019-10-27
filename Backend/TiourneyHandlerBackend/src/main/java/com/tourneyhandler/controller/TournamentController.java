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

import com.tourneyhandler.entities.Tournament;
import com.tourneyhandler.service.ITournamentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/tournaments")
@Api(tags="Tournament", value="Servicio Web RESTFull de Tournaments")
public class TournamentController {
	
	@Autowired
	private ITournamentService tournamentService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Tournaments", notes="Servicio para listar todos los tournaments")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Tournaments encontrados"),
			@ApiResponse(code=404, message="Tournaments no encontrados")
	})	
	public ResponseEntity<List<Tournament>> findAll(){
		try {
			List<Tournament> tournaments = new ArrayList<>();
			tournaments = tournamentService.findAll();
			return new ResponseEntity<List<Tournament>>(tournaments, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Tournament>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Buscar Tournament por Id", notes="Servicio para buscar un tournament por Id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Tournament encontrado"),
			@ApiResponse(code=404, message="Tournament no encontrado")
	})
	public ResponseEntity<Tournament> findById(@PathVariable("id") Integer id){
		try {
			Optional<Tournament> tournament= tournamentService.findById(id);
			if(!tournament.isPresent()) {
				return new ResponseEntity<Tournament>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Tournament>(tournament.get(), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Tournament>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Crear Tournament", notes="Servicio para crear un nuevo tournament")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Tournament creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")
	})
	public ResponseEntity<Tournament> insertTournament(@Valid @RequestBody Tournament tournament){
		try {
			Tournament tournamentNew = new Tournament();
			tournamentNew = tournamentService.save(tournament);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(tournamentNew.getId()).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception e) {
			return new ResponseEntity<Tournament>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	@ApiOperation(value="Actualizar Tournament", notes="Servicio para actualizar un tournament")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Tournament actualizado correctamente"),
			@ApiResponse(code=404, message="Tournament no encontrado")
	})
	public ResponseEntity<Tournament> updateTournament(@Valid @RequestBody Tournament tournament){
		try {
			tournamentService.save(tournament);			
			return new ResponseEntity<Tournament>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Tournament>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Eliminar Tournament", notes="Servicio para eliminar un tournament")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Tournament eliminado correctamente"),
			@ApiResponse(code=404, message="Tournament no encontrado")
	})
	public ResponseEntity<Tournament> deleteTournament(@PathVariable("id") Integer id){
		try {
			Optional<Tournament> tournament= tournamentService.findById(id);
			if(!tournament.isPresent()) {
				return new ResponseEntity<Tournament>(HttpStatus.NOT_FOUND);
			}
			tournamentService.deleteById(id);
			return new ResponseEntity<Tournament>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Tournament>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
