package br.com.ebac.animal_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

import br.com.ebac.animal_service.entidades.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{

  @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
  List<Animal> findNotAdopted();
  

  @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
  List<Animal> findAdopted();

  @Query("SELECT a FROM Animal a WHERE a.especie = 'Gato'")
  List<Animal> findCats();

  @Query("SELECT a FROM Animal a WHERE a.especie = 'Cachorro'")
  List<Animal> findDogs();

  @Query("SELECT a.nomeRecebedor, COUNT(a) FROM Animal a WHERE a.dataEntrada BETWEEN :startDate AND :endDate GROUP BY a.nomeRecebedor")
  List<Object[]> countAnimalsRescuedByEmployeeBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
