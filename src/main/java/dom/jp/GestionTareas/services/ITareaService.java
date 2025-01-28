package dom.jp.GestionTareas.services;

import java.util.List;

import dom.jp.GestionTareas.models.Tarea;

public interface ITareaService {

    public void guardarTarea(Tarea unaTarea);
    public void eliminarTarea(int id);
    public Tarea buscarTareaPorId(int id);
    public List<Tarea> buscarTodasLasTareas();
    
}
