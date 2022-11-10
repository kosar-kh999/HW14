import StringToInt.Convert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConvertTest {
    Convert convert;
    @BeforeEach
    void setUp(){
        convert = new Convert();
    }

    @Test
    public void test(){
        convert.stringConvert("102");
        Assertions.assertEquals(convert.stringConvert("102") , 102);
    }

    @Test
    public void testRange(){
        RuntimeException exception = assertThrows(RuntimeException.class , () -> convert.stringConvert("400000"));
        Assertions.assertEquals("the range is between [-32767,32767]",exception.getMessage());
    }

}
