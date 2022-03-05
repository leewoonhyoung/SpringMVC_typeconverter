package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {
    @Override
    public IpPort convert(String source) {
        log.info("convert source={}", source);

        //"127.0.0.1:8080"

        String[] split = source.split(":"); // : 기준으로 자른다.
        //["127.0.0.1", "8080"]

        String ip = split[0]; // 0번째 칸은 ip를 의미한다.
        //"127.0.0.1"

        int port = Integer.parseInt(split[1]); // 1번쨰 칸은 port로 의미한다.
        //"8080"

        return new IpPort(ip, port);
    }
}
