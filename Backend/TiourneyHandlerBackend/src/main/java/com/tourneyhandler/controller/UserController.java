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

import com.tourneyhandler.entities.User;
import com.tourneyhandler.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/users")
@Api(tags="User", value="Servicio Web RESTFull de Users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listar Users", notes="Servicio para listar todos los users")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Users encontrados"),
			@ApiResponse(code=404, message="Users no encontrados")
	})	
	public ResponseEntity<List<User>> findAll(){
		try {
			List<User> users = new ArrayList<>();
			users = userService.findAll();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Buscar User por Id", notes="Servicio para buscar un user por Id")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="User encontrado"),
			@ApiResponse(code=404, message="User no encontrado")
	})
	public ResponseEntity<User> findById(@PathVariable("id") Integer id){
		try {
			Optional<User> user= userService.findById(id);
			if(!user.isPresent()) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Crear User", notes="Servicio para crear un nuevo user")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="User creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")
	})
	public ResponseEntity<User> insertUser(@Valid @RequestBody User user){
		try {
			User userNew = new User();
			userNew = userService.save(user);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(userNew.getId()).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	@ApiOperation(value="Actualizar User", notes="Servicio para actualizar un user")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="User actualizado correctamente"),
			@ApiResponse(code=404, message="User no encontrado")
	})
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
		try {
			userService.save(user);			
			return new ResponseEntity<User>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Eliminar User", notes="Servicio para eliminar un user")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="User eliminado correctamente"),
			@ApiResponse(code=404, message="User no encontrado")
	})
	public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
		try {
			Optional<User> user= userService.findById(id);
			if(!user.isPresent()) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
			userService.deleteById(id);
			return new ResponseEntity<User>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
