package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // 컨트롤러에서 데이터를 view로 넘기는 것
    @GetMapping("hello")
    public String Hello(Model model) {
        model.addAttribute("data", "Hello!!");
        return "hello";
    }
}
