

package com.DeliveryOnTimeBackend.Backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DeliveryOnTimeBackend.Backend.model.User;


@Repository
public interface UserRepository extends JpaRepository <User,Integer>{


    
}
