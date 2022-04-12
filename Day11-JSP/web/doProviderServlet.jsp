<%@ page import="java.util.List" %>
<%@ page import="com.wpf.jsp.service.impl.ProviderServiceImpl" %>
<%@ page import="com.wpf.jsp.domain.Provider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    request.setCharacterEncoding("utf-8");
    String action = request.getParameter("action");
    ProviderServiceImpl providerService = ProviderServiceImpl.getProviderService();
    if ("getProviderList".equals(action)) {
        List<Provider> providers = providerService.getProvidersLimit(3, 1);
        request.setAttribute("providers", providers);
        request.getRequestDispatcher("provider.jsp").forward(request, response);
    }
    if ("addProvider".equals(action)) {
        providerService.add(new Provider(request.getParameter("p_name"), request.getParameter("p_tele"), request.getParameter("p_email"), request.getParameter("p_address")));
        response.sendRedirect("doProviderServlet.jsp?action=getProviderList");
    }
    if ("getOneProvider".equals(action)) {
        Provider provider = providerService.findOne(request.getParameter("p_id"));
        request.setAttribute("provider", provider);
        request.getRequestDispatcher("updateprovider.jsp").forward(request, response);
    }
    if ("updateProvider".equals(action)) {
        providerService.change(new Provider(Integer.parseInt(request.getParameter("p_id")), request.getParameter("p_name"), request.getParameter("p_tele"), request.getParameter("p_email"), request.getParameter("p_address")));
        response.sendRedirect("doProviderServlet.jsp?action=getProviderList");
    }
    if ("deleteProvider".equals(action)) {
        providerService.remove(new Provider(Integer.parseInt(request.getParameter("p_id"))));
        response.sendRedirect("doProviderServlet.jsp?action=getProviderList");
    }
    if ("getProvidersLimitFirst".equals(action)) {
        List<Provider> providers = providerService.getProvidersLimitFirst();
        request.setAttribute("providers", providers);
        request.getRequestDispatcher("provider.jsp").forward(request, response);
    }
    if ("getProvidersLimitEnd".equals(action)) {
        List<Provider> providers = providerService.getProvidersLimitEnd();
        request.setAttribute("providers", providers);
        request.getRequestDispatcher("provider.jsp").forward(request, response);
    }
    if ("getProvidersLimitUpPage".equals(action)) {
        List<Provider> providers = providerService.getProvidersLimitUpPage();
        request.setAttribute("providers", providers);
        request.getRequestDispatcher("provider.jsp").forward(request, response);
    }
    if ("getProvidersLimitDownPage".equals(action)) {
        List<Provider> providers = providerService.getProvidersLimitDownPage();
        request.setAttribute("providers", providers);
        request.getRequestDispatcher("provider.jsp").forward(request, response);
    }
%>