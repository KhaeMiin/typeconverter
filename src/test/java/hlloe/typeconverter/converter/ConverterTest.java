package hlloe.typeconverter.converter;

import hlloe.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @DisplayName("문자를 숫자로")
    @Test
    void stringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("숫자를 문자로")
    @Test
    void integerToString() {
        IntegerToString converter = new IntegerToString();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @DisplayName("IpPort 객체를 String 변환")
    @Test
    void stringToIpPort() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @DisplayName("String 문자열을 IpPort 객체로")
    @Test
    void ipPortToString() {
        StringIpPortConverter converter = new StringIpPortConverter();
        IpPort result = converter.convert("127.0.0.1:8080");
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080)); //@EqualsAndHashCode (참조값이 달라도 객체 안의 값이 같으면 true가 반환됨)
    }
}
