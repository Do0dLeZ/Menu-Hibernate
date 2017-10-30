package controllers;

import model.entity.Dish;
import model.services.IMenuService;
import model.services.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("serial")
@WebServlet(name = "MenuServlet", urlPatterns = {"/param", "/withDiscount"})
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromPrice = req.getParameter("from-price");
        String toPrice = req.getParameter("to-price");
        String lessThen = req.getParameter("less-then");

        String discount = req.getParameter("show-discount-menu");

        ArrayList<Dish> menu = new ArrayList<>();
        IMenuService menuService = new MenuService();
        if (fromPrice != null && toPrice != null && lessThen != null) {
            if (!lessThen.isEmpty()) {
                menu = menuService.getDishLessThen(Integer.parseInt(lessThen));
            } else if (!fromPrice.isEmpty() && !toPrice.isEmpty()) {
                menu = menuService.getDishBetweenPrices(
                        Integer.parseInt(fromPrice),
                        Integer.parseInt(toPrice)
                );
            }
        } else if (discount != null && discount.equals("true")) {
            menu = menuService.getDishWithDiscount();
        }

        req.setAttribute("menuList", menu);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
