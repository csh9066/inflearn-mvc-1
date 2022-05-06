package hello.servlet.basic.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    /***
     * v3랑 비교점은 model을 파라미터로 받고
     * 논리 주소를 반환 함
     * @param paramMap
     * @param model
     * @return String
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
