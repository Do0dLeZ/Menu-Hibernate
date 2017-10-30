package controllers;

import model.services.IMenuService;
import model.services.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(name = "AddDish", urlPatterns = {"/add_dish"})
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dishName = req.getParameter("dish-name");
        String weight = req.getParameter("weight");
        String price = req.getParameter("price");
        String discountStr = req.getParameter("discount");

        IMenuService menuService = new MenuService();

        boolean wasAdded = menuService.addDish(dishName,
                Double.parseDouble(price),
                Integer.parseInt(weight),
                discountStr != null && !discountStr.isEmpty() ? Integer.parseInt(discountStr) : null);

        if (wasAdded)
            resp.sendRedirect("index.jsp");
    }
}
