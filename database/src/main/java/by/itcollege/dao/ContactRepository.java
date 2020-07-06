package by.itcollege.dao;

import by.itcollege.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findAllBy();
    Contact findById(Long id);
    void deleteById(Long id);
    Contact save(Contact contact);

}
