package com.tourneyhandler.controller;


import com.tourneyhandler.util.TourneyUtil;;
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

import com.tourneyhandler.entities.Player;
import com.tourneyhandler.service.IPlayerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/players")
@Api(tags="Player", value="Servicio Web RESTFull de Players")
public class PlayerController {
	
	TourneyUtil TU;
	
	@Autowired
	private IPlayerService playerService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Players", notes="Servicio para listar todos los players")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Players encontrados"),
			@ApiResponse(code=404, message="Players no encontrados")
	})	
	public ResponseEntity<List<Player>> findAll(){
		try {
			List<Player> players = new ArrayList<>();
			players = playerService.findAll();
			return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Player>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Players", notes="Servicio para listar todos los players")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Players encontrados"),
			@ApiResponse(code=404, message="Players no encontrados")
	})	
	public ResponseEntity<List<Player>> findAllSorted(){
		try {
			List<Player> players = new ArrayList<>();
			players = playerService.findAll();
			TU.Sort(players);
			return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Player>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Buscar Player por Id", notes="Servicio para buscar un player por Id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Player encontrado"),
			@ApiResponse(code=404, message="Player no encontrado")
	})
	public ResponseEntity<Player> findById(@PathVariable("id") Integer id){
		try {
			Optional<Player> player= playerService.findById(id);
			if(!player.isPresent()) {
				return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Player>(player.get(), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Crear Player", notes="Servicio para crear un nuevo player")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Player creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")
	})
	public ResponseEntity<Player> insertPlayer(@Valid @RequestBody Player player){
		try {
			Player playerNew = new Player();
			playerNew = playerService.save(player);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(playerNew.getId()).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception e) {
			return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	@ApiOperation(value="Actualizar Player", notes="Servicio para actualizar un player")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Player actualizado correctamente"),
			@ApiResponse(code=404, message="Player no encontrado")
	})
	public ResponseEntity<Player> updatePlayer(@Valid @RequestBody Player player){
		try {
			playerService.save(player);			
			return new ResponseEntity<Player>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Eliminar Player", notes="Servicio para eliminar un player")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Player eliminado correctamente"),
			@ApiResponse(code=404, message="Player no encontrado")
	})
	public ResponseEntity<Player> deletePlayer(@PathVariable("id") Integer id){
		try {
			Optional<Player> player= playerService.findById(id);
			if(!player.isPresent()) {
				return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
			}
			playerService.deleteById(id);
			return new ResponseEntity<Player>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
