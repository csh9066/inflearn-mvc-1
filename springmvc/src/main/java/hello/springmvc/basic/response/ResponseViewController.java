package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    /**
     * 경로의 이름과 view의 논리 이름과 매칭 
     * 
     * void를 반환하는 경우
     * @Controller를 사용하고 HttpServletResponse, OutputStream 같은 메시지 바디를
     * 처리하는 파라미터가 없으면 요청 URL를 참고해서 논리 뷰 이름을 사용함
     * 
     * 영한님은 이 명시성이 너무 떨어지고 이렇게 딱 맞는 경우도 많이 없어서 권장히지 않는다 함
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
}
