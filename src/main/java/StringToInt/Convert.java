package StringToInt;

public class Convert {
    public static int stringConvert(String string){
        int integer = Integer.parseInt(string);
        if (integer < -32767 && integer > 32767){
            throw new RuntimeException("the range is between [-32767,32767]");
        }
        return integer;
    }
}
