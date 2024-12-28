package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView1() {
        return new ModelAndView("/response/hello")
                .addObject("data", "hello!");
    }

    @RequestMapping("/response-view-v15")
    public String responseView4(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    /**
     *
     * @param model
     * Model은 뷰에 데이터를 전달해야 할 때
     * @return
     */
    @RequestMapping("/response-view-v2")
    public String responseView2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    /**
     * @param model
     */
    @RequestMapping("/response/hello")
    public void responseView3(Model model) {
        model.addAttribute("data", "hello!");
    }
}
