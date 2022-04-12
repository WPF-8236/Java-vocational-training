<%@ page import="com.wpf.jsp.service.impl.CategoryServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wpf.jsp.domain.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String action = request.getParameter("action");
    CategoryServiceImpl categoryService = CategoryServiceImpl.getCategoryService();
    if ("getCategoryList".equals(action)) {
        List<Category> categories = categoryService.getCategoriesLimit(3, 1);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
    if ("addCategory".equals(action)) {
        categoryService.add(new Category(request.getParameter("c_name")));
        response.sendRedirect("doCategoryServlet.jsp?action=getCategoryList");
    }
    if ("getOneCategory".equals(action)) {
        Category category = categoryService.findOne(request.getParameter("c_id"));
        request.setAttribute("category", category);
        request.getRequestDispatcher("updatecategory.jsp").forward(request, response);
    }
    if ("updateCategory".equals(action)) {
        categoryService.change(new Category(Integer.parseInt(request.getParameter("c_id")), request.getParameter("c_name")));
        response.sendRedirect("doCategoryServlet.jsp?action=getCategoryList");
    }
    if ("deleteCategory".equals(action)) {
        categoryService.remove(new Category(Integer.parseInt(request.getParameter("c_id"))));
        response.sendRedirect("doCategoryServlet.jsp?action=getCategoryList");
    }
    if ("getCategoriesLimitFirst".equals(action)) {
        List<Category> categories = categoryService.getCategoriesLimitFirst();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
    if ("getCategoriesLimitEnd".equals(action)) {
        List<Category> categories = categoryService.getCategoriesLimitEnd();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
    if ("getCategoriesLimitUpPage".equals(action)) {
        List<Category> categories = categoryService.getCategoriesLimitUpPage();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
    if ("getCategoriesLimitDownPage".equals(action)) {
        List<Category> categories = categoryService.getCategoriesLimitDownPage();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }

%>

