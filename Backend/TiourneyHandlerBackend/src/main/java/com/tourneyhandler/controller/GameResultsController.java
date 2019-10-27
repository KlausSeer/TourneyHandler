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

import com.tourneyhandler.entities.GameResults;
import com.tourneyhandler.service.IGameResultsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/gameResultss")
@Api(tags="GameResults", value="Servicio Web RESTFull de GameResultss")
public class GameResultsController {
	
	@Autowired
	private IGameResultsService gameResultsService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar GameResultss", notes="Servicio para listar todos los gameResultss")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="GameResultss encontrados"),
			@ApiResponse(code=404, message="GameResultss no encontrados")
	})	
	public ResponseEntity<List<GameResults>> findAll(){
		try {
			List<GameResults> gameResultss = new ArrayList<>();
			gameResultss = gameResultsService.findAll();
			return new ResponseEntity<List<GameResults>>(gameResultss, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<GameResults>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Buscar GameResults por Id", notes="Servicio para buscar un gameResults por Id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="GameResults encontrado"),
			@ApiResponse(code=404, message="GameResults no encontrado")
	})
	public ResponseEntity<GameResults> findById(@PathVariable("id") Integer id){
		try {
			Optional<GameResults> gameResults= gameResultsService.findById(id);
			if(!gameResults.isPresent()) {
				return new ResponseEntity<GameResults>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<GameResults>(gameResults.get(), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<GameResults>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Crear GameResults", notes="Servicio para crear un nuevo gameResults")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="GameResults creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")
	})
	public ResponseEntity<GameResults> insertGameResults(@Valid @RequestBody GameResults gameResults){
		try {
			GameResults gameResultsNew = new GameResults();
			gameResultsNew = gameResultsService.save(gameResults);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(gameResultsNew.getId()).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception e) {
			return new ResponseEntity<GameResults>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	@ApiOperation(value="Actualizar GameResults", notes="Servicio para actualizar un gameResults")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="GameResults actualizado correctamente"),
			@ApiResponse(code=404, message="GameResults no encontrado")
	})
	public ResponseEntity<GameResults> updateGameResults(@Valid @RequestBody GameResults gameResults){
		try {
			gameResultsService.save(gameResults);			
			return new ResponseEntity<GameResults>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<GameResults>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Eliminar GameResults", notes="Servicio para eliminar un gameResults")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="GameResults eliminado correctamente"),
			@ApiResponse(code=404, message="GameResults no encontrado")
	})
	public ResponseEntity<GameResults> deleteGameResults(@PathVariable("id") Integer id){
		try {
			Optional<GameResults> gameResults= gameResultsService.findById(id);
			if(!gameResults.isPresent()) {
				return new ResponseEntity<GameResults>(HttpStatus.NOT_FOUND);
			}
			gameResultsService.deleteById(id);
			return new ResponseEntity<GameResults>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<GameResults>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
