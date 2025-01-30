package dom.jp.GestionTareas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dom.jp.GestionTareas.models.Tarea;
import dom.jp.GestionTareas.repositories.tareaRepository;

@Service
public class TareaServiceImpl implements ITareaService{

    private final tareaRepository repo;
    
    public TareaServiceImpl(tareaRepository repo) {
        this.repo = repo;
    }


    @Override
    public void guardarTarea(Tarea unaTarea) {
        
        repo.save(unaTarea);
    }

    @Override
    public void eliminarTarea(int id) {
        repo.deleteById(id);
    }

    @Override
    public Tarea buscarTareaPorId(int id) {
       Tarea tarea = repo.findById(id).orElse(null);
       return tarea;
    }

    @Override
    public List<Tarea> buscarTodasLasTareas() {
        List<Tarea> listaTareas = repo.findAll();
        return listaTareas;
    }


    @Override
    public void editarTarea(Tarea tarea) {
       Tarea editTarea = repo.findById(tarea.getId()).orElse(null);
       
       if (editTarea != null) {
           editTarea.setDescripcion(tarea.getDescripcion());
           editTarea.setEstado(tarea.getEstado());
           editTarea.setFechaCreacion(tarea.getFechaCreacion());
           editTarea.setFechaVencimiento(tarea.getFechaVencimiento());
           editTarea.setTitulo(tarea.getTitulo());

           repo.save(editTarea);
       }
    }



}
