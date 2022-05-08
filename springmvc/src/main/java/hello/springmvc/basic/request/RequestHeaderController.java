package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Optional;

@Slf4j
@RestController
public class RequestHeaderController {
    
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          // @RequestHeader 도 변수명을 이용해 특정 헤더를 받을 수 있음 마찬가지로 옵셔널 사용 가능
                          @RequestHeader String host,
                          // 쿠키도 @PathVariable 처럼 변수명으로 쿠키를 받을 수 있음 또한 옵셔널로도 받을 수 있음
                          @CookieValue Optional<String> myCookie) {
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("host={}", host);
        log.info("cookie={}", myCookie.get());
        return "ok";
    }
}
