package com.cqupt.pda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Jack Lu
 * @Date: 2022/5/24 18:26
 */
@Controller
public class LoginController {
    @GetMapping("/")
    public String login() {
        return "index";
    }

    @GetMapping("/newpage")
    public String loginnewpage() {
        return "pad";
    }

    @ResponseBody
    @PostMapping("/login")
    public String Login(@RequestParam("account") String account, @RequestParam("password") String password, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = LoginController.class.getClassLoader().getResourceAsStream("login.properties");
        properties.load(resourceAsStream);
        String password1 = properties.getProperty(account);
        HttpSession session = req.getSession();
        session.setAttribute("loginUser", account);

        if (password1 != null && password.equals(password1) && !("".equals(password1))) {
            switch (account) {
                case "u1":
                    return "u1";
                case "u2":
                    return "u2";
                case "u3":
                    return "u3";
                case "u4":
                    return "u4";
                default:
                    return "null";
            }
        } else {
            return "null";
        }
    }

    @GetMapping("/redir1")
    public String redirect1() {
        return "indexQ2-1";
    }

    @GetMapping("/redir2")
    public String redirect2() {
        return "indexQ2-2";
    }

    @GetMapping("/redir3")
    public String redirect3() {
        return "indexQ2-3";
    }

    @GetMapping("/redir4")
    public String redirect4() {
        return "indexQ3";
    }

    @GetMapping("/material")
    public String material(){
        return "material";
    }
}
