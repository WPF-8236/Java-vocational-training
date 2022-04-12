<%@ page import="com.wpf.jsp.service.impl.ProductServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wpf.jsp.domain.Product" %>
<%@ page import="com.wpf.jsp.service.impl.ProviderServiceImpl" %>
<%@ page import="com.wpf.jsp.service.impl.CategoryServiceImpl" %>
<%@ page import="com.wpf.jsp.domain.Provider" %>
<%@ page import="com.wpf.jsp.domain.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String action = request.getParameter("action");
    ProductServiceImpl productService = ProductServiceImpl.getProductService();
    ProviderServiceImpl providerService = ProviderServiceImpl.getProviderService();
    CategoryServiceImpl categoryService = CategoryServiceImpl.getCategoryService();
    if ("getProductList".equals(action)) {
        List<Product> products = productService.getProductsLimit(3, 1);
        request.setAttribute("products", products);
        List<Provider> providers = providerService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("providers", providers);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
    if ("addProduct".equals(action)) {
        productService.add(new Product(request.getParameter("pt_name"), Double.parseDouble(request.getParameter("pt_price")), Integer.parseInt(request.getParameter("pt_c_id")), Integer.parseInt(request.getParameter("pt_p_id"))));
        response.sendRedirect("doProductServlet.jsp?action=getProductList");
    }
    if ("getPCId".equals(action)) {
        List<Provider> providers = providerService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("providers", providers);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("addproduct.jsp").forward(request, response);
    }
    if ("getOneProduct".equals(action)) {
        Product product = productService.findOne(request.getParameter("pt_id"));
        request.setAttribute("product", product);
        List<Provider> providers = providerService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("providers", providers);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
    }
    if ("updateProduct".equals(action)) {
        productService.change(new Product(Integer.parseInt(request.getParameter("pt_id")), request.getParameter("pt_name"), Double.parseDouble(request.getParameter("pt_price")), Integer.parseInt(request.getParameter("pt_c_id")), Integer.parseInt(request.getParameter("pt_p_id"))));
        response.sendRedirect("doProductServlet.jsp?action=getProductList");
    }
    if ("deleteProduct".equals(action)) {
        productService.remove(new Product(Integer.parseInt(request.getParameter("pt_id"))));
        response.sendRedirect("doProductServlet.jsp?action=getProductList");
    }
    if ("getProductsLimitFirst".equals(action)) {
        List<Product> products = productService.getProductsLimitFirst();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
    if ("getProductsLimitEnd".equals(action)) {
        List<Product> products = productService.getProductsLimitEnd();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
    if ("getProductsLimitUpPage".equals(action)) {
        List<Product> products = productService.getProductsLimitUpPage();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
    if ("getProductsLimitDownPage".equals(action)) {
        List<Product> products = productService.getProductsLimitDownPage();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
%>

