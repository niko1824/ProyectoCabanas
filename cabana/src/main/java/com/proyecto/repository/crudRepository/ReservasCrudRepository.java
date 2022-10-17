package com.proyecto.repository.crudRepository;

import com.proyecto.entities.Reservas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservasCrudRepository extends CrudRepository<Reservas,Integer> {

    /*JPQL*/

    public List<Reservas>findAllByStatus(String status);

    public List<Reservas>findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);


    @Query("select c.client, COUNT(c.client) FROM Reservas AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]>countTotalReservasByClient();
}
