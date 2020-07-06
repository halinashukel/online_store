package by.itcollege.dao;

import by.itcollege.entity.User;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllBy();
    User findById(Long id);
    void deleteById(Long id);
    User save(User user);

//   void update(User user);


}
