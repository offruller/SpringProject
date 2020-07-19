package by.iba.grigorjev.springproject.service;

import by.iba.grigorjev.springproject.exceptions.ResourceNotFoundException;
import by.iba.grigorjev.springproject.repository.PersonRepository;
import by.iba.grigorjev.springproject.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    public void editPerson(Person person) {
        personRepository.save(person);
    }

    public Person getById(long id) throws ResourceNotFoundException {
        return personRepository.findAllById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void editPerson(Person person, Long id) {
        person.setId(id);
        personRepository.save(person);
    }
}