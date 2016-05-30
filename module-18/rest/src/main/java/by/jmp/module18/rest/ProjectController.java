package by.jmp.module18.rest;

import by.jmp.module16.domain.Employee;
import by.jmp.module16.domain.Project;
import by.jmp.module16.service.EmployeeService;
import by.jmp.module16.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Kiryl_Parfiankou on 4/13/2016.
 */
@RestController
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    public ProjectController() {
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
    public Project getProject(@PathVariable String id) {
        return projectService.get(Long.valueOf(id));
    }


    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public Project createProject(@ModelAttribute Project project) {
        return projectService.create(project);
    }

    @RequestMapping(value = "/projects", method = RequestMethod.DELETE)
    public void deleteProject(String id) {
        projectService.delete(Long.valueOf(id));
    }

    @RequestMapping(value = "/projects", method = RequestMethod.PUT)
    public Project updateProject(Project project) {
        return projectService.update(project);
    }
}
