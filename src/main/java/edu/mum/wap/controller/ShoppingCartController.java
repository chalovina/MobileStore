package edu.mum.wap.controller;

import edu.mum.wap.dao.ShoppingCartDAO;
import edu.mum.wap.dao.impl.ShoppingCartDAOImpl;
import edu.mum.wap.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShoppingCartController extends HttpServlet {

    private ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAOImpl();
    private ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        if (session != null && session.getAttribute("shoppingCart") != null) {
            shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        } else {
            session.setAttribute("shoppingCart", shoppingCart);
        }
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }


}
