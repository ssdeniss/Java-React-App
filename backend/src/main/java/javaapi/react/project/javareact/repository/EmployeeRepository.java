package javaapi.react.project.javareact.repository;

import javaapi.react.project.javareact.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
