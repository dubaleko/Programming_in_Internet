package by.belstu.it.dubaleko.basejava; //пакет используемый для работы
import static  java.lang.Math. *;

public class JavaTest { /** @author Dubaleko Valentin */ /** @version 11.0.2  */

    static int sint;
    public static final int Y  = 2;

    public static void main(String[] args) { /** @return void  */

        // переменные примитивных типов
        char first = '1';
        int second = 2; /** @value 2*/
        short third = 3;
        byte four = 4;
        long five = 33333333333333335L;
        boolean six = true;

        System.out.println("string + int = " + "string" + second);
        System.out.println("string + char = " + "hom" + first);
        System.out.println("string + double = " + "123" + 12.4);

        byte bt = 4 + 100;
        int x = (int) (14.5 + 25456565665L);
        long fix = (long) 2 + 2147483647;
        System.out.println("long :" + fix);
        System.out.println("Вывод значения без инициализации " + sint);

        //логические операции
        boolean xz = false ^ true;
        System.out.println(xz + " = false ^ true");
        boolean xs = true && false;
        System.out.println(xs + " = true && false");
        // boolean mybool = xz + xs;

        // подбор типа данных для значения
        long t = 0x7fff_ffff_fffL;
        System.out.println(t);
        long l = 9223372036854775807L;
        System.out.println(l);

        // работа с char
        char m = 'a' + '\u0061' + 97;
        System.out.println("Сумма трех char " + m);

        System.out.println("3.45%2.4 =" + 3.45 % 2.4);
        System.out.println("1.0/0.0 = " + 1.0 / 0.0);
        System.out.println("0.0/0.0 = " + 0.0 / 0.0);
        System.out.println("log(-345) = " + log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));

        final int X = 1; //константа

        //математические операции
        System.out.println("Math.PI = " + PI);
        System.out.println("Math E = " + E);
        System.out.println("round(Math.PI) = " + round(PI));
        System.out.println("round(Math.E) = " + round(E));
        System.out.println("random = " + random());

        //Переменные с сылочным типом данных
        Boolean bool = false;
        Character chr = 'a';
        Integer in = 10;
        Byte bte = 1;
        Short sh = 9;
        Long lg = 15L;
        Double db = 4.5;

        System.out.println("Отрицание " + !bool);
        System.out.println("short + integer = " + sh + in);
        System.out.print("false | true =");
        System.out.println(bool | true);
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);

        Integer iob = 10;
        int i = iob.intValue();
        Byte bob = 1;
        byte b = bob.byteValue();

        System.out.print("Integer.parseInt ");
        System.out.println(Integer.parseInt("23"));
        System.out.print("Integer.toHexString ");
        System.out.println(Integer.toHexString(20));
        System.out.print("Integer.compare ");
        System.out.println(Integer.compare(7, 6));
        System.out.print("Integer.toString ");
        System.out.println(Integer.toString(55));
        System.out.print("Integer.bitCount ");
        System.out.println(Integer.bitCount(9));

        String str = "2345";
        String newstr = "2345";

        Integer.parseInt(str);
        Integer.valueOf(str);

        byte[] arr = str.getBytes();
        str = new String(arr);

        Boolean.parseBoolean(newstr);
        Boolean.valueOf(newstr);

        System.out.println(str.equals(newstr));
        System.out.println(str.compareTo(newstr));
        System.out.println(str == newstr);

        newstr = null;
        System.out.println(str.equals(newstr));
        //System.out.println(str.compareTo(newstr));
        System.out.println(str == newstr);

        String randstring = "str my";
        randstring.split(" ");
        System.out.print("Contains ");
        System.out.println(randstring.contains("s"));
        System.out.print("Length ");
        System.out.println(randstring.length());
        System.out.print("HashCode ");
        System.out.println(randstring.hashCode());

        //массивы
        char[][] c1;
        char[] c2;
        char[] c3;
        c1 = new char[3][];
        c1[0] = new char[1];
        c1[1] = new char[2];
        c1[2] = new char[3];
        for (int j = 0; j < 1; j++) c1[0][j] = 'a';
        for (int j = 0; j < 2; j++) c1[1][j] = 'a';
        for (int j = 0; j < 3; j++) c1[2][j] = 'a';
        System.out.println("c1.length = " + c1.length);
        System.out.println("c1[0].length = " + c1[0].length);
        System.out.println("c1[1].length = " + c1[1].length);
        System.out.println("c1[2].length = " + c1[2].length);
        c2 = new char[]{'a', 'b', 'c'};
        c3 = new char[]{'c', 'd', 'e'};
        boolean comRez = (c2 == c3);
        c2 = c3;
        System.out.println("Contains of c1[2]:");
        for (char j : c1[2]) {
            System.out.println(j);
        }

        //работа с классом WrapperString
        WrapperString mynewstr = new WrapperString("java");
        mynewstr.replace('j', 'm');
        System.out.println(mynewstr);

        //анонимный класс
        WrapperString mystr = new WrapperString("lalalala")
        {
            public WrapperString delete (char newChar)
            {
                String newstr = getStr().replace(newChar , '\u0000');
                System.out.print("String after delete symbol: ");
                System.out.println(newstr);
                WrapperString myst = new WrapperString(newstr)
                {
                    public void replace (char oldChar , char newChar)
                    {
                        String newstr = getStr().replace(newChar, oldChar);
                        System.out.print("String after replace symbol : ");
                        System.out.println(newstr);
                    }
                };
                return myst;
            }
        }.delete('a');
        mystr.replace('m','l');

    }
}
