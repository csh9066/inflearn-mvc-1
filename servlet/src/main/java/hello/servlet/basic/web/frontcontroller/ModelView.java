package hello.servlet.basic.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/*
* ModelView의 역할
*   - view의 논리 이름을 호출 한다.
*   - 모델을 반환한다.
* 장점 
*   - 서블릿에 종속적이지 않은 개발 가능
*   - 논리 이름을 반환해 물리 경로에 의존하지 않음 물리 경로는 viewResolver가 처리
* */
@Getter @Setter
public class ModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
