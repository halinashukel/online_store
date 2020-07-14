package by.itcollege.dao;

import by.itcollege.entity.PersonalInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, Long> {

    List<PersonalInfo> findAllBy();
    PersonalInfo findById(Long id);
    void deleteById(Long id);
    PersonalInfo save(PersonalInfo personalInfo);
}
