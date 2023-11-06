package ms.com.marvel.developer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.com.marvel.developer.app.BitacoraAccesoApiApp;
import ms.com.marvel.developer.app.DeveloperApp;

@RestController
@RequestMapping("/marvel")
public class DeveloperController {
	
	@Autowired
	private DeveloperApp developerApp;
	
	@Autowired
	private BitacoraAccesoApiApp bitacoraAccesoApiApp;
	
	
	@GetMapping(value = "/v1/public/characters", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> getAllCharacters() {
		
        return new ResponseEntity<>(developerApp.getAllCharacters(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/v1/public/characters/{characterId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> getAllCharactersById(@PathVariable(required=false,name="characterId") Long characterId) {
		
        return new ResponseEntity<>(developerApp.getCharacterById(characterId), HttpStatus.OK);
    }
	
	@GetMapping(value = "/v1/public/bitacora", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object> getBitacora() {
		
        return new ResponseEntity<>(bitacoraAccesoApiApp.getBitacoraAccesoApiLst(), HttpStatus.OK);
    }
}
