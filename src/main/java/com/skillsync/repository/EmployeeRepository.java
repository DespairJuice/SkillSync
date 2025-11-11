package com.skillsync.repository;

import com.skillsync.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Encuentra empleados con disponibilidad mayor a cierto valor
    List<Employee> findByDisponibilidadGreaterThan(double disponibilidad);

    // Busca empleados por nombre (ignora mayúsculas/minúsculas)
    List<Employee> findByNombreContainingIgnoreCase(String nombre);

    // Consulta personalizada: empleados con cierta habilidad
    @Query("SELECT e FROM Employee e JOIN e.skills s WHERE LOWER(s.nombre) = LOWER(:skillName)")
    List<Employee> findBySkillName(String skillName);
}