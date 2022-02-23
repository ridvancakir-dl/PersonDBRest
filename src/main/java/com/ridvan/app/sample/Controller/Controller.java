package com.ridvan.app.sample.Controller;

import com.ridvan.app.sample.Models.Person;
import com.ridvan.app.sample.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller
{
    @Autowired
    private IPersonRepository IpersonRepo;

    @GetMapping(value = "/")
    public String hello()
    {
        return "SampleSpringBootApplication";
    }

    @GetMapping(value="/persons")
    public List<Person> getAllUsers()
    {
        return IpersonRepo.findAll();
    }

    @GetMapping(value="/person/{userId}")
    public Person getSingleUser(@PathVariable Long userId)
    {
        return IpersonRepo.findById(userId).orElse(null);
           }


    @PostMapping(value = "/saveperson")
    public Person insertPerson(@RequestBody Person person)
    {
        return IpersonRepo.save(person);
    }

    @DeleteMapping(value = "/{userId}")
    public Person deletePerson(@PathVariable Long userId)
    {
        Optional<Person> p = IpersonRepo.findById(userId);

        if(p.isPresent())
        {
            Long id = p.get().getId();
            IpersonRepo.deleteById(id);
            return p.get();
        }
        else
        {
            return null;
        }
    }
    
    @PutMapping("/{userId}")
    public Person update(@PathVariable Long userId, @RequestBody Person person)
    {
        Optional<Person> p = IpersonRepo.findById(userId);
        if(p.isPresent())
        {
            Person foundedPerson = p.get();
            foundedPerson.setAge(person.getAge());
            foundedPerson.setName(person.getName());
            foundedPerson.setSurname(person.getSurname());
            IpersonRepo.save(foundedPerson);
            return foundedPerson;
        }
        else
            return null;
    }
}
