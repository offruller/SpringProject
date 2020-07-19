package by.iba.grigorjev.springproject.service;

import by.iba.grigorjev.springproject.exceptions.ResourceNotFoundException;
import by.iba.grigorjev.springproject.entity.Person;

import java.util.List;


public interface PersonService {
    List<Person> getAllPerson();
    void addNewPerson(Person person);
    void deletePerson(Person person );
    void editPerson(Person person, Long id);
    Person getById(long id) throws ResourceNotFoundException;
}