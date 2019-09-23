package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.UUID;

@XmlRootElement
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
@Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person){
    personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
    return personService.getAllPeople();
    }
    @GetMapping(path ="{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
    return personService.getPersonById(id).orElse(null);
    }
    @DeleteMapping(path ="{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
     personService.deletePerson(id);
    }
    @PutMapping(path ="{id}")
    public void updatepersonById(@PathVariable("id") UUID id,@Valid @NotBlank @RequestBody Person persontoUpdate){
    personService.updatePerson(id,persontoUpdate);
    }
    @GetMapping("test")
    public String test() {
        return "test";
    }

}
