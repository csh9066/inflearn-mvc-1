package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().print("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParam2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    /**
     * 영한님 관점에서 너무 과하다는 생각이 있음 명확하게 @RequsetParam을 사용하는 걸 추천하다고 함
     * v3가 가장 good
     */
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    /**
     * required = true 가 default
     * 옵셔널로 처리하는게 가능 옵셔널로 처리 하는게 개인적으로 좀 더 좋은거 같다
     * 기본타입 옵셔널은 안되는 거 같다 OptionalInt 같은 거
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = false) String username,
            @RequestParam Optional<Integer> age) {
        log.info("username={}, age={}", username, age.get());
        return "ok";
    }

    /**
     * @RequestParam defaultValue를 설정할 수 있다.
     * 나는 옵셔널 orElse를 이용하는게 좀더 좋다고 생각함
     */
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "babo") String username,
            @RequestParam Optional<Integer> age) {
        log.info("username={}, age={}", username, age.orElse(2));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

}
