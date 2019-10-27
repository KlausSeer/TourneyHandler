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

import com.tourneyhandler.entities.Statistics;
import com.tourneyhandler.service.IStatisticsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/statisticss")
@Api(tags="Statistics", value="Servicio Web RESTFull de Statisticss")
public class StatisticsController {
	
	@Autowired
	private IStatisticsService statisticsService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Statisticss", notes="Servicio para listar todos los statisticss")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Statisticss encontrados"),
			@ApiResponse(code=404, message="Statisticss no encontrados")
	})	
	public ResponseEntity<List<Statistics>> findAll(){
		try {
			List<Statistics> statisticss = new ArrayList<>();
			statisticss = statisticsService.findAll();
			return new ResponseEntity<List<Statistics>>(statisticss, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Statistics>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Buscar Statistics por Id", notes="Servicio para buscar un statistics por Id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Statistics encontrado"),
			@ApiResponse(code=404, message="Statistics no encontrado")
	})
	public ResponseEntity<Statistics> findById(@PathVariable("id") Integer id){
		try {
			Optional<Statistics> statistics= statisticsService.findById(id);
			if(!statistics.isPresent()) {
				return new ResponseEntity<Statistics>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Statistics>(statistics.get(), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Statistics>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Crear Statistics", notes="Servicio para crear un nuevo statistics")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Statistics creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")
	})
	public ResponseEntity<Statistics> insertStatistics(@Valid @RequestBody Statistics statistics){
		try {
			Statistics statisticsNew = new Statistics();
			statisticsNew = statisticsService.save(statistics);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(statisticsNew.getId()).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception e) {
			return new ResponseEntity<Statistics>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	@ApiOperation(value="Actualizar Statistics", notes="Servicio para actualizar un statistics")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Statistics actualizado correctamente"),
			@ApiResponse(code=404, message="Statistics no encontrado")
	})
	public ResponseEntity<Statistics> updateStatistics(@Valid @RequestBody Statistics statistics){
		try {
			statisticsService.save(statistics);			
			return new ResponseEntity<Statistics>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Statistics>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Eliminar Statistics", notes="Servicio para eliminar un statistics")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Statistics eliminado correctamente"),
			@ApiResponse(code=404, message="Statistics no encontrado")
	})
	public ResponseEntity<Statistics> deleteStatistics(@PathVariable("id") Integer id){
		try {
			Optional<Statistics> statistics= statisticsService.findById(id);
			if(!statistics.isPresent()) {
				return new ResponseEntity<Statistics>(HttpStatus.NOT_FOUND);
			}
			statisticsService.deleteById(id);
			return new ResponseEntity<Statistics>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Statistics>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
