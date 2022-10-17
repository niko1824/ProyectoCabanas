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


    @Query("SELECT c.client, COUNT(c.client) from Reservas AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]>countTotalReservasByClient();
}
