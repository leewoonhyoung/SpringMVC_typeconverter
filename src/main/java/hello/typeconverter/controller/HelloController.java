package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");// "data" 파라마터에 문자 타입으로 넘어온다.
        Integer intValue = Integer.valueOf(data); // 숫자 타입으로 바꿔준다.
        System.out.println("intValue = " + intValue);
        return "Ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) { // 이렇게 하면 data 파라미터를 자동으로 int 값으로 변경해준다.

        System.out.println("data = " + data);
        return "OK";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort IP = " + ipPort.getIp());
        System.out.println("ipPort PORT = " + ipPort.getPort());
        return "ok";
    }
}
