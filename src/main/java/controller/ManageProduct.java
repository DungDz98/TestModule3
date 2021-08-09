package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/product"})
public class ManageProduct extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                showCreateProduct(req, resp);
                break;
            case "update":
                showUpdateProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "findByName":
                findProductByName(req, resp);
                break;
            default:
                showProduct(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "update":
                updateProduct(req, resp);
                break;
        }
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.selectAllProduct();
        req.setAttribute("listProduct", products);
        RequestDispatcher rd = req.getRequestDispatcher("view/ShowProduct.jsp");
        rd.forward(req, resp);
    }

    private void showCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        CategoryDAO categoryDAO = new CategoryDAO();
        req.setAttribute("listCategory", categoryDAO.selectAllCategory());
        RequestDispatcher rd = req.getRequestDispatcher("view/CreateProduct.jsp");
        rd.forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idsp = Integer.parseInt(req.getParameter("idsp"));
        productDAO.deleteProduct(idsp);
        resp.sendRedirect("/product");
    }

    private void showUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int idsp = Integer.parseInt(req.getParameter("idsp"));
        CategoryDAO categoryDAO = new CategoryDAO();
        req.setAttribute("listCategory", categoryDAO.selectAllCategory());
        req.setAttribute("productOld", productDAO.selectProduct(idsp));
        RequestDispatcher rd = req.getRequestDispatcher("/view/UpdateProduct.jsp");
        rd.forward(req, resp);
    }

    private void findProductByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fName = req.getParameter("fName");
        List<Product> products = productDAO.findProductByName(fName);
        req.setAttribute("listProduct", products);
        RequestDispatcher rd = req.getRequestDispatcher("view/ShowProduct.jsp");
        rd.forward(req, resp);
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tensp = req.getParameter("tensp");
        int gia = Integer.parseInt(req.getParameter("gia"));
        int soluong = Integer.parseInt(req.getParameter("soluong"));
        String mausac = req.getParameter("mausac");
        String mota = req.getParameter("mota");
        String danhmuc = req.getParameter("danhmuc");
        Product product = new Product(tensp, gia, soluong, mausac, mota, danhmuc);
        productDAO.insertProduct(product);
        resp.sendRedirect("/product");
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idsp = Integer.parseInt(req.getParameter("idsp"));
        String tensp = req.getParameter("tensp");
        int gia = Integer.parseInt(req.getParameter("gia"));
        int soluong = Integer.parseInt(req.getParameter("soluong"));
        String mausac = req.getParameter("mausac");
        String mota = req.getParameter("mota");
        String danhmuc = req.getParameter("danhmuc");
        Product product = new Product(idsp, tensp, gia, soluong, mausac, mota, danhmuc);
        productDAO.updateProduct(product);
        resp.sendRedirect("/product");
    }

}

