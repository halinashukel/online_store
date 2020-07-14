package by.itcollege.dao;

import by.itcollege.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllBy();
    User findById(Long id);
    void deleteById(Long id);
    User save(User user);

    Optional <User> findUserById(Long id);
    User findByName(String name);

//   void update(User user);


}
