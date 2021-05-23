package com.spring.react.io.repository;

import com.spring.react.io.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query(value="select * from employees e where e.user_id = :userId",nativeQuery=true)
    UserEntity findByUserId(@Param("userId") String userId);
}
