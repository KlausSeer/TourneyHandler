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

import com.tourneyhandler.entities.Team;
import com.tourneyhandler.service.ITeamService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/teams")
@Api(tags="Team", value="Servicio Web RESTFull de Teams")
public class TeamController {
	
	@Autowired
	private ITeamService teamService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Teams", notes="Servicio para listar todos los teams")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Teams encontrados"),
			@ApiResponse(code=404, message="Teams no encontrados")
	})	
	public ResponseEntity<List<Team>> findAll(){
		try {
			List<Team> teams = new ArrayList<>();
			teams = teamService.findAll();
			return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Team>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Buscar Team por Id", notes="Servicio para buscar un team por Id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Team encontrado"),
			@ApiResponse(code=404, message="Team no encontrado")
	})
	public ResponseEntity<Team> findById(@PathVariable("id") Integer id){
		try {
			Optional<Team> team= teamService.findById(id);
			if(!team.isPresent()) {
				return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Team>(team.get(), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Team>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Crear Team", notes="Servicio para crear un nuevo team")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Team creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")
	})
	public ResponseEntity<Team> insertTeam(@Valid @RequestBody Team team){
		try {
			Team teamNew = new Team();
			teamNew = teamService.save(team);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(teamNew.getId()).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception e) {
			return new ResponseEntity<Team>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	@ApiOperation(value="Actualizar Team", notes="Servicio para actualizar un team")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Team actualizado correctamente"),
			@ApiResponse(code=404, message="Team no encontrado")
	})
	public ResponseEntity<Team> updateTeam(@Valid @RequestBody Team team){
		try {
			teamService.save(team);			
			return new ResponseEntity<Team>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Team>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Eliminar Team", notes="Servicio para eliminar un team")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Team eliminado correctamente"),
			@ApiResponse(code=404, message="Team no encontrado")
	})
	public ResponseEntity<Team> deleteTeam(@PathVariable("id") Integer id){
		try {
			Optional<Team> team= teamService.findById(id);
			if(!team.isPresent()) {
				return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
			}
			teamService.deleteById(id);
			return new ResponseEntity<Team>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Team>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
