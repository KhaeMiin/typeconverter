package hlloe.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IntegerToString implements Converter<Integer, String> {

    @Override
    public String convert(Integer source) {
        log.info("converter source={}", source);
        return String.valueOf(source); //숫자를 문자로 변경
    }
}
