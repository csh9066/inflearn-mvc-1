package hello.servlet.basic.web.frontcontroller.v3;

import hello.servlet.basic.web.frontcontroller.ModelView;

import java.util.Map;
/*
* ControllerV3
* - ModeView를 이용해 서블릿에 종속적이지 않은 개발 가능
* - 마찬가지로 process도 단순한 paramMap을 받아 서블릿에 종속적이지 않음
* */
public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
