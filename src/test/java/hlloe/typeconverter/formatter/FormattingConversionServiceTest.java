package hlloe.typeconverter.formatter;

import hlloe.typeconverter.converter.IpPortToStringConverter;
import hlloe.typeconverter.converter.StringIpPortConverter;
import hlloe.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        //컨버터 등록
        conversionService.addConverter(new StringIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        //포멧터 등록(부모의 ConversionService 기능을 받아서 쓰기 때문에 가능)
        conversionService.addFormatter(new MyNumberFormatter());

        //컨버터 사용
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);//source: "127.0.0.1:8080", 반환타입: IpPort.class
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        //포멧터 사용
        assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000", Long.class)).isEqualTo(1000L);
    }
}
