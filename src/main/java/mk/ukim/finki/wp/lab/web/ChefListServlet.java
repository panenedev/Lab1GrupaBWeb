package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.impl.ChefServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ChefListServlet", urlPatterns = "/listChefs",
        initParams = {
        @WebInitParam(name="day",value="200")
        }
)
public class ChefListServlet extends HttpServlet {


    private final SpringTemplateEngine springTemplateEngine;
    private final ChefServiceImpl chefService;

    public ChefListServlet(SpringTemplateEngine springTemplateEngine, ChefServiceImpl chefService) {
        this.springTemplateEngine = springTemplateEngine;
        this.chefService = chefService;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);


        System.out.println(getServletConfig().getInitParameter("day"));



        context.setVariable("chefs",chefService.listChefs());

        this.springTemplateEngine.process("listChefs.html",context,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
