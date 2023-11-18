/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controller;

import com.emergentes.bean.BeanContacto;
import com.emergentes.entidades.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zerlu
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanContacto daoContacto = new BeanContacto();
        Contacto c = new Contacto();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        switch (action) {
            case "add":
                request.setAttribute("contacto", c);
                request.getRequestDispatcher("formAgenda.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                c = daoContacto.buscar(id);
                request.setAttribute("contacto", c);
                request.getRequestDispatcher("formAgenda.jsp").forward(request, response);

                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                daoContacto.eliminar(id);
                response.sendRedirect("ContactoController");
                break;
            case "view":
                List<Contacto> lista = daoContacto.listarTodos();
                request.setAttribute("contactos", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanContacto daoContacto = new BeanContacto();
        Contacto c = new Contacto();

        c.setId(Integer.parseInt(request.getParameter("id")));
        c.setNombre(request.getParameter("nombre"));
        c.setTelefono(request.getParameter("telefono"));
        c.setCorreo(request.getParameter("correo"));
        if (c.getId() == 0) {
            daoContacto.insertar(c);
        } else {
            daoContacto.editar(c);
        }
        response.sendRedirect("ContactoController");
    }

    private void nuevo(){
        BeanContacto dao= new BeanContacto();
        Contacto c = new Contacto();
        c.setNombre("jhonatan");
        c.setTelefono("7894656");
        c.setCorreo("jhon@gmail.com");
        
        dao.insertar(c);
    }
    private void mostrar(){

           
        BeanContacto jpa= new BeanContacto();
        
        List<Contacto> lista=jpa.listarTodos();
        for (Contacto item : lista) {
            System.out.println(item.toString()); 
        }
    }
    private void eliminar(){
                BeanContacto dao=new BeanContacto();
        Integer id = 3;
        dao.eliminar(id);
    }
    private void editar(){
        BeanContacto dao=new BeanContacto();
        Integer id=2;
        Contacto c = dao.buscar(id);
        
        c.setNombre("Luis");
    }
    
    private void mostrare(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanContacto jpa = new BeanContacto();
        List<Contacto> lista = jpa.listarTodos();

        // Establecer la lista como un atributo de la solicitud para usarla en el JSP
        request.setAttribute("listaContactos", lista);

        // Enviar la solicitud al JSP
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
