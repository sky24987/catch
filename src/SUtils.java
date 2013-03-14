// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2009-12-02 14:54:05
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SUtils.java



import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.Vector;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SUtils
{

    public SUtils()
    {
    }

    public static String[] split(String line, int seperator)
    {
        if(line == null)
            return null;
        line = line.trim();
        if(line.length() == 0)
            return null;
        Vector v = new Vector();
        int i;
        int j;
        for(i = 0; (j = line.indexOf(seperator, i)) >= 0; i = j + 1)
            v.addElement(line.substring(i, j).trim());

        v.addElement(line.substring(i).trim());
        int size = v.size();
        String ps[] = new String[size];
        if(size > 0)
            v.copyInto(ps);
        return ps;
    }

    public static String[] split(String line, String seperator)
    {
        if(line == null)
            return null;
        line = line.trim();
        if(line.length() == 0)
            return null;
        Vector v = new Vector();
        int i;
        int j;
        for(i = 0; (j = line.indexOf(seperator, i)) >= 0; i = j + seperator.length())
            v.addElement(line.substring(i, j).trim());

        v.addElement(line.substring(i).trim());
        int size = v.size();
        String ps[] = new String[size];
        if(size > 0)
            v.copyInto(ps);
        return ps;
    }

    public static String fixNumber(long n)
    {
        return fixNumber(n, 8);
    }

    public static String fixNumber(long n, int len)
    {
        char b[] = new char[len];
        for(int i = 0; i < len; i++)
            b[i] = '0';

        return (new DecimalFormat(new String(b))).format(n);
    }

    public static String fixNumber(int n)
    {
        return fixNumber(n, 4);
    }

    public static String fixNumber(int n, int len)
    {
        return fixNumber(n, len);
    }

    public static final boolean isEmpty(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    public static boolean equals(String s1, String s2)
    {
        if(isEmpty(s1))
            return isEmpty(s2);
        else
            return s1.equals(s2);
    }

    public static boolean equalsIgnoreCase(String s1, String s2)
    {
        if(isEmpty(s1))
            return isEmpty(s2);
        else
            return s1.equalsIgnoreCase(s2);
    }

    public static String numStr4Java(String s, char c, char c1)
    {
        if(s == null)
            return null;
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < s.length(); i++)
        {
            char c2 = s.charAt(i);
            if(c2 == c)
                continue;
            if(c2 == c1)
                stringbuffer.append('.');
            else
                stringbuffer.append(c2);
        }

        return stringbuffer.toString();
    }

    public static String takeCommasFromNumStr(String s)
    {
        if(s == null)
            return null;
        if(s.indexOf(',') == -1)
            return s;
        else
            return numStr4Java(s, ',', '.');
    }

    public static String[] enumeration2StringArray(Enumeration enumeration, int i)
    {
        int j = 0;
        String as[] = new String[i];
        while(enumeration.hasMoreElements()) 
            as[j++] = (String)enumeration.nextElement();
        return as;
    }

    public static byte[] chars2bytes(char ac[])
    {
        byte abyte0[] = new byte[ac.length * 2];
        int i = 0;
        for(int j = 0; j < ac.length; j++)
        {
            char c = ac[j];
            char c1 = ac[j];
            abyte0[i++] = (byte)(c >> 8);
            abyte0[i++] = (byte)c1;
        }

        return abyte0;
    }

    public static char[] bytes2chars(byte abyte0[])
        throws Exception
    {
        if(abyte0.length % 2 != 0)
            throw new Exception("Cannot convert an odd number of bytes");
        char ac[] = new char[abyte0.length / 2];
        int i = 0;
        for(int j = 0; j < ac.length; j++)
        {
            byte byte0 = abyte0[i++];
            byte byte1 = abyte0[i++];
            ac[j] = (char)(byte0 << 8 & 0xff00 | byte1 & 0xff);
        }

        return ac;
    }

    public static String padStringWidth(String s, int i)
    {
        StringBuffer stringbuffer = null;
        if(s != null)
        {
            stringbuffer = new StringBuffer(s);
            stringbuffer.setLength(i);
            int j = s.length();
            for(int l = j; l < i; l++)
                stringbuffer.setCharAt(l, ' ');

        } else
        {
            stringbuffer = new StringBuffer(i);
            stringbuffer.setLength(i);
            for(int k = 0; k < i; k++)
                stringbuffer.setCharAt(k, ' ');

        }
        return stringbuffer.toString();
    }

    public static String padStringWidth(int i, int j)
    {
        return padStringWidth(String.valueOf(i), j);
    }

    public static String padStringWidth(float f, int i)
    {
        return padStringWidth(String.valueOf(f), i);
    }

    public static String padStringWidth(long l, int i)
    {
        return padStringWidth(String.valueOf(l), i);
    }

    public static String padStringWidth(double d, int i)
    {
        return padStringWidth(String.valueOf(d), i);
    }

    public static String toHexString(long x, int chars)
    {
        char buf[] = new char[chars];
        for(int charPos = chars; --charPos >= 0;)
        {
            buf[charPos] = hexDigits[(int)(x & 15L)];
            x >>>= 4;
        }

        return new String(buf);
    }

    public static String GBToUnicode(String str)
    {
        try
        {
            String s = new String(str.getBytes("8859_1"), "GB2312");
            return s;
        }
        catch(UnsupportedEncodingException e)
        {
            String s1 = null;
            return s1;
        }
    }

    public static String unicodeToGB(String str)
    {
        if(str == null || str.length() == 0)
            return str;
        try
        {
            String s = new String(str.getBytes("GB2312"), "8859_1");
            return s;
        }
        catch(UnsupportedEncodingException e)
        {
            String s1 = null;
            return s1;
        }
    }

    public static String cnulls(Object obj)
    {
        return cnulls(obj, "");
    }

    public static String cnulls(Object obj, String defaultValue)
    {
        if(obj == null)
            return defaultValue;
        else
            return obj.toString();
    }

    public static String cnulls(String str, String defaultValue)
    {
        if(str == null)
            return defaultValue;
        else
            return str;
    }

    public static String cnulls(String str)
    {
        if(str == null)
            return "";
        else
            return str;
    }

    public static String formatCurrency(double cy)
    {
        return NumberFormat.getCurrencyInstance().format(cy);
    }

    public static String formatNumber(double d, int n)
    {
        String pattern = "#,##0";
        if(n > 0)
        {
            pattern = String.valueOf(String.valueOf(pattern)).concat(".");
            for(int i = 0; i < n; i++)
                pattern = String.valueOf(String.valueOf(pattern)).concat("0");

        }
        return (new DecimalFormat(pattern)).format(d);
    }

    public static int compareToIgnoreCase(String str1, String str2)
    {
        return str1.toLowerCase().compareTo(str2.toLowerCase());
    }

    public static boolean endsWithIgnoreCase(String str, String suffix)
    {
        return str.toLowerCase().endsWith(suffix.toLowerCase());
    }

    public static int indexOfIgnoreCase(String str, int find)
    {
        return str.toLowerCase().indexOf(Character.toLowerCase((char)find));
    }

    public static int indexOfIgnoreCase(String str, int find, int start)
    {
        return str.toLowerCase().indexOf(Character.toLowerCase((char)find), start);
    }

    public static int indexOfIgnoreCase(String str, String find)
    {
        return str.toLowerCase().indexOf(find.toLowerCase());
    }

    public static int indexOfIgnoreCase(String str, String find, int start)
    {
        return str.toLowerCase().indexOf(find.toLowerCase(), start);
    }

    public static int lastIndexOfIgnoreCase(String str, int find)
    {
        return str.toLowerCase().lastIndexOf(Character.toLowerCase((char)find));
    }

    public static int lastIndexOfIgnoreCase(String str, int find, int start)
    {
        return str.toLowerCase().lastIndexOf(Character.toLowerCase((char)find), start);
    }

    public static int lastIndexOfIgnoreCase(String str, String find)
    {
        return str.toLowerCase().lastIndexOf(find.toLowerCase());
    }

    public static int lastIndexOfIgnoreCase(String str, String find, int start)
    {
        return str.toLowerCase().lastIndexOf(find.toLowerCase(), start);
    }

    public static int occurencesOf(String str, char ch)
    {
        char s[] = new char[str.length()];
        str.getChars(0, s.length, s, 0);
        int count = 0;
        for(int i = 0; i < s.length; i++)
            if(s[i] == ch)
                count++;

        return count;
    }

    public static int occurencesOfIgnoreCase(String str, char ch)
    {
        return occurencesOf(str.toLowerCase(), Character.toLowerCase(ch));
    }

    public static String replace(String str, String oldChars, String newChars)
    {
        int len = newChars.length();
        int pos = str.indexOf(oldChars);
        int lastPos = pos;
        for(; pos > -1; pos = str.indexOf(oldChars, lastPos))
        {
            String firstPart = str.substring(0, pos);
            String lastPart = str.substring(pos + oldChars.length(), str.length());
            str = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(firstPart)))).append(newChars).append(lastPart)));
            lastPos = pos + len;
        }

        return str;
    }

    public static String replaceIgnoreCase(String str, String oldChars, String newChars)
    {
        String lowerStr = str.toLowerCase();
        int len = newChars.length();
        int pos = lowerStr.indexOf(oldChars);
        int lastPos = pos;
        for(; pos > -1; pos = lowerStr.indexOf(oldChars, lastPos))
        {
            String firstPart = str.substring(0, pos);
            String lastPart = str.substring(pos + oldChars.length(), str.length());
            str = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(firstPart)))).append(newChars).append(lastPart)));
            lastPos = pos + len;
        }

        return str;
    }

    public static boolean startsWithIgnoreCase(String str, String prefix)
    {
        return str.toLowerCase().startsWith(prefix.toLowerCase());
    }

    public static boolean startsWithIgnoreCase(String str, String prefix, int start)
    {
        return str.toLowerCase().startsWith(prefix.toLowerCase(), start);
    }

    public static String stackToString(Throwable e)
    {
        try
        {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String s1 = String.valueOf(String.valueOf((new StringBuffer("------\r\n")).append(sw.toString()).append("------\r\n")));
            return s1;
        }
        catch(Exception e2)
        {
            String s = "(bad stack2string) ".concat(String.valueOf(String.valueOf(e.getMessage())));
            return s;
        }
    }

    public static String stackToString(Exception e)
    {
        try
        {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String s1 = String.valueOf(String.valueOf((new StringBuffer("------\r\n")).append(sw.toString()).append("------\r\n")));
            return s1;
        }
        catch(Exception e2)
        {
            String s = "(bad stack2string) ".concat(String.valueOf(String.valueOf(e.getMessage())));
            return s;
        }
    }

    public static String byteArrayToString(byte ba[])
    {
        int length = ba.length;
        char buf[] = new char[length * 2];
        int i = 0;
        int j = 0;
        while(i < length) 
        {
            int k = ba[i++];
            buf[j++] = HEX_DIGITS[k >>> 4 & 0xf];
            buf[j++] = HEX_DIGITS[k & 0xf];
        }
        return new String(buf);
    }

    public static byte[] hexFromString(String hex)
    {
        int len = hex.length();
        byte buf[] = new byte[(len + 1) / 2];
        int i = 0;
        int j = 0;
        if(len % 2 == 1)
            buf[j++] = (byte)fromDigit(hex.charAt(i++));
        while(i < len) 
            buf[j++] = (byte)(fromDigit(hex.charAt(i++)) << 4 | fromDigit(hex.charAt(i++)));
        return buf;
    }

    public static int fromDigit(char ch)
    {
        if(ch >= '0' && ch <= '9')
            return ch - 48;
        if(ch >= 'A' && ch <= 'F')
            return (ch - 65) + 10;
        if(ch >= 'a' && ch <= 'f')
            return (ch - 97) + 10;
        else
            throw new IllegalArgumentException(String.valueOf(String.valueOf((new StringBuffer("invalid hex digit '")).append(ch).append("'"))));
    }

    public static String escapeXMLstr(String input)
    {
        if(input == null)
            return null;
        StringBuffer output = new StringBuffer("");
        int len = input.length();
        for(int i = 0; i < len; i++)
        {
            char ch = input.charAt(i);
            if(ch == '&')
            {
                output.append("&amp;");
                continue;
            }
            if(ch == '<')
            {
                output.append("&lt;");
                continue;
            }
            if(ch == '>')
            {
                output.append("&gt;");
                continue;
            }
            if(ch == '\'')
            {
                output.append("&apos;");
                continue;
            }
            if(ch == '"')
                output.append("&quot;");
            else
                output.append(ch);
        }

        return output.toString();
    }

    public static String escapeHTMLstr(String input)
    {
        if(input == null)
            return null;
        StringBuffer output = new StringBuffer("");
        int len = input.length();
        for(int i = 0; i < len; i++)
        {
            char ch = input.charAt(i);
            if(ch == '&')
            {
                output.append("&amp;");
                continue;
            }
            if(ch == '<')
            {
                output.append("&lt;");
                continue;
            }
            if(ch == '>')
            {
                output.append("&gt;");
                continue;
            }
            if(ch == '"')
                output.append("&quot;");
            else
                output.append(ch);
        }

        return output.toString();
    }

    public static String headCharUpperCase(String str)
    {
        if(str == null || "".equals(str))
            return str;
        String headChar = str.substring(0, 1).toUpperCase();
        if(str.length() == 1)
            return headChar;
        else
            return (new StringBuilder()).append(String.valueOf(headChar)).append(String.valueOf(str.substring(1, str.length()))).toString();
    }

    public static String objToString(Object obj)
    {
        try
        {
            ByteArrayOutputStream byteOS = new ByteArrayOutputStream(2048);
            ObjectOutputStream objectOS = new ObjectOutputStream(byteOS);
            objectOS.writeObject(obj);
            objectOS.flush();
            ByteArrayInputStream byteIN = new ByteArrayInputStream(byteOS.toByteArray());
            ByteArrayOutputStream base64OS = new ByteArrayOutputStream(2048);
            BASE64Encoder encoder = new BASE64Encoder();
            encoder.encodeBuffer(byteIN, base64OS);
            base64OS.flush();
            String base64 = new String(base64OS.toByteArray());
            String s1 = base64;
            return s1;
        }
        catch(Exception ex)
        {
            String s = null;
            return s;
        }
    }

    public static Object strToObject(String str)
    {
        try
        {
            ByteArrayInputStream byteIN = new ByteArrayInputStream(str.getBytes());
            ByteArrayOutputStream base64OS = new ByteArrayOutputStream(2048);
            BASE64Decoder decoder = new BASE64Decoder();
            decoder.decodeBuffer(byteIN, base64OS);
            base64OS.flush();
            ObjectInputStream objectIN = new ObjectInputStream(new ByteArrayInputStream(base64OS.toByteArray()));
            Object obj = objectIN.readObject();
            Object obj2 = obj;
            return obj2;
        }
        catch(Exception ex)
        {
            Object obj1 = null;
            return obj1;
        }
    }

    private static final char hexDigits[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static final char HEX_DIGITS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };

}
