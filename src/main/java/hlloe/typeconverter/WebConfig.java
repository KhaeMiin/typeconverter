package hlloe.typeconverter;

import hlloe.typeconverter.converter.IntegerToString;
import hlloe.typeconverter.converter.IpPortToStringConverter;
import hlloe.typeconverter.converter.StringIpPortConverter;
import hlloe.typeconverter.converter.StringToIntegerConverter;
import hlloe.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * converter 적용시키기
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //주석처리 : 우선순위 때문에(우선순위가 converter이기 때문에 formatter가 안먹힘 그러므로 주석처리
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToString());
        registry.addConverter(new StringIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
