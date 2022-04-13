package hlloe.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter<S, T> S(파라미터값)를 T(반환값)로 변환
 */
@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) { //
        log.info("converter source={}", source);
        return Integer.valueOf(source);
    }
}
