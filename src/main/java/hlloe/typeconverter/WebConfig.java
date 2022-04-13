package hlloe.typeconverter;

import hlloe.typeconverter.converter.IntegerToString;
import hlloe.typeconverter.converter.IpPortToStringConverter;
import hlloe.typeconverter.converter.StringIpPortConverter;
import hlloe.typeconverter.converter.StringToIntegerConverter;
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
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToString());
        registry.addConverter(new StringIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
    }
}
