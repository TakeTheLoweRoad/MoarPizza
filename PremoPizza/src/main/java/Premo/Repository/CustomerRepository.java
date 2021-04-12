package Premo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Premo.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
