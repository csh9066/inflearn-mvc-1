package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    /**
     * PathVaraible 사용
     * 변수명이 같으면 생략 가능
     * @PathVaraible("userId") String id == @PathVaraible String userId
     * @param userId
     * @return
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={} orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode"
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug"
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * Content-Type 헤더의 특징은 현재 전송하는 데이터가 어떤 형식의 데이터 타입인지 설명하는 헤더임
     * consumes="application/json"
     * consumes="!application/json"
     * MediaType.APPLICATION_JSON_VALUE
     *
     * 서버는 Content-Type이 맞지 않으면 415(Unsupported Media Type) status code 반환 해야함
     */
    @GetMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 추가 매핑 Media Type
     * Accpet 헤더는 클라이언트 입장에서 나 이런 데이터만 받겠다고 알려주는 헤더임
     * 서버 입장에서는 Accept 헤더에 있는 헤더를 보고 줄 수 있는지 판단 해야함
     * produces="text/html"
     * produces="!text/html"
     * MediaType.TEXT_HTML_VALUE
     *
     * 서버는 Accept 헤더에 맞는 타입의 데이터를 줄 수 없으면 406(Not Acceptable) status code를 반환해야 함
     */
    @GetMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }


}
