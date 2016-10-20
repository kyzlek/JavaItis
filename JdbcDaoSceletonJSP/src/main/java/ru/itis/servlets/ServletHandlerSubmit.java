package ru.itis.servlets;

import ru.itis.factories.ServiceFactory;
import ru.itis.models.Owner;
import ru.itis.services.OwnerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Kyzlek_pc on 20.10.2016.
 */
public class ServletHandlerSubmit extends HttpServlet {

    OwnerService ownerService;

    public void init() throws ServletException {
        super.init();
        ownerService = ServiceFactory.getInstance().getOwnerService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ownerName = request.getParameter("ownerName");
        String ownerId = request.getParameter("ownerId");


        if(ownerName != null && ownerId != null){
            ownerService.addNewOwner(new Owner(Integer.parseInt(ownerId), ownerName));
        }


        //Сохраняем данные в объекте запроса
        //request.setAttribute("statusRequest", statusRequest);
        //Передаем данные (объекты запрос и ответ) в hello.jsp
        getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);

    }
}
