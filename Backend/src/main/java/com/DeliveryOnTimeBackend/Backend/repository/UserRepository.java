

package com.DeliveryOnTimeBackend.Backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DeliveryOnTimeBackend.Backend.model.user;


@Repository
public interface UserRepository extends JpaRepository <user,Integer>{


    
}
