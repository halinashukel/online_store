package by.itcollege.dao;

import by.itcollege.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findAllBy();
    Contact findById(Long id);
    void deleteById(Long id);
    Contact save(Contact contact);


}
