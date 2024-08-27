package org.example.bank.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bank.service.IAccountService;
import org.example.bank.service.impl.AccountServiceImpl;

import java.io.IOException;

public class AccountServlet extends HttpServlet {

    private final IAccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String transferFrom = req.getParameter("transferFrom");
        String transferTo = req.getParameter("transferTo");
        double transferAmt = Double.parseDouble(req.getParameter("transferAmt"));

        accountService.transfer(transferFrom, transferTo, transferAmt);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
