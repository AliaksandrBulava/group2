package by.jmp.module13;

import module11.task1.service.PersonService;
import module11.task1.service.PersonServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kiryl_Parfiankou on 3/14/2016.
 */
public class PersonListServlet extends HttpServlet {

    private static PersonService personService = new PersonServiceImpl();
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        PrintWriter out = response.getWriter();
        out.println("Persons:");
        for(String person: personService.getPersons()) {
            out.println(person);
        }

        out.close();
    }
}
