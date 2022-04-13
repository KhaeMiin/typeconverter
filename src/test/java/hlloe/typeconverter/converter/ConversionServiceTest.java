package hlloe.typeconverter.converter;

import hlloe.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {


    @Test
    void conversionService() {
        //등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToString());
        conversionService.addConverter(new StringIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //사용
//        source, 반환해야할 타입 클래스
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");

        assertThat(conversionService.convert("207.01.01:8080", IpPort.class)).isEqualTo(new IpPort("207.01.01", 8080));

        String ipPort = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPort).isEqualTo("127.0.0.1:8080");



    }
}
