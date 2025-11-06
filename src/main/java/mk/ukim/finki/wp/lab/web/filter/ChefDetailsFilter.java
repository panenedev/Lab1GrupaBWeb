package mk.ukim.finki.wp.lab.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/chefDetails")
public class ChefDetailsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String chefId = req.getParameter("chefId");
        String dishId = req.getParameter("dishId");
        if (chefId == null || chefId.isEmpty()){
            resp.sendRedirect("/listChefs");
        } else if (dishId==null || dishId.isEmpty()) {
            resp.sendRedirect("/dish");
        } else {
            filterChain.doFilter(req,resp);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
