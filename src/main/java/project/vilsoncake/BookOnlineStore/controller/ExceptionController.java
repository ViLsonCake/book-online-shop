package project.vilsoncake.BookOnlineStore.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.vilsoncake.BookOnlineStore.constant.MessageConst;

import static project.vilsoncake.BookOnlineStore.constant.MessageConst.*;

@Controller
public class ExceptionController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            final int statusCode = Integer.parseInt(status.toString());

            switch (statusCode) {
                case 403 -> {
                    model.addAttribute("status", statusCode);
                    model.addAttribute("statusError", ERROR_403_MESSAGE);
                    return "error/error-template.html";
                }
                case 404 -> {
                    model.addAttribute("status", statusCode);
                    model.addAttribute("statusError", ERROR_404_MESSAGE);
                    return "error/error-template.html";
                }
            }
        }
        model.addAttribute("statusError", "");
        return "error/error-template.html";
    }
}
