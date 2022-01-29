package dio.springboot.personapi.controller;

import dio.springboot.personapi.dto.MessageResponseDTO;
import dio.springboot.personapi.entity.Person;
import dio.springboot.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // retorna codigo http 201, seguindo padrão verbos http
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);

    }
}
