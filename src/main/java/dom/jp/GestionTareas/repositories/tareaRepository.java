package dom.jp.GestionTareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dom.jp.GestionTareas.models.Tarea;

public interface tareaRepository extends JpaRepository<Tarea, Integer>{

}
