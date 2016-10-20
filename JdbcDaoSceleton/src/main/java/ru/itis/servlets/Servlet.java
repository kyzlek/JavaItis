package ru.itis.servlets;

import ru.itis.factories.DaoFactory;
import ru.itis.factories.ServiceFactory;
import ru.itis.models.Owner;
import ru.itis.services.OwnerService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyzlek_pc on 20.10.2016.
 */
public class Servlet extends HttpServlet {

    OwnerService ownerService;

    public void init() throws ServletException{
        super.init();
        ownerService = ServiceFactory.getInstance().getOwnerService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        List<Owner> allOwners = ownerService.getAllOwners();

        for(int i=0; i<allOwners.size(); i++){
            out.println("<h3>" + allOwners.get(i).toString() + "<h3>");
        }


    }
}
