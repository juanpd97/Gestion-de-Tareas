package dom.jp.GestionTareas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dom.jp.GestionTareas.models.Tarea;
import dom.jp.GestionTareas.services.TareaServiceImpl;



@Controller
public class TareaController {

//Implementar las operaciones básicas:
// Crear una tarea.
// Leer todas las tareas.
// Actualizar una tarea.
// Eliminar una tarea.

    @Autowired
    TareaServiceImpl repo;

    @GetMapping({"/","#","index"})
    public String incio(Model model) {

        Tarea nuevaTarea = new Tarea();
        model.addAttribute("nuevaTarea", nuevaTarea);

        
        return "index";
    }
    

    @PostMapping("tarea/crear")
    public void crearTarea(@RequestBody Tarea unaTarea) {
        repo.guardarTarea(unaTarea);
    }
    



}
