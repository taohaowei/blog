package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by TaoHaoWei on 2018/5/19.
 * 本人新建博客：www.mynight.top
 * 欢迎交友和指正 ^_^
 */
public class BlogUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String fileToString(String filePath)
    {
        StringBuffer sb = new StringBuffer();

        System.out.println("fileToString()方法：filePath = "+filePath);

        File file = new File(filePath);
        if(!file.exists())
        {
            System.out.println();
            return "";
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String src;
            while ((src=br.readLine())!=null)
            {
                sb.append(src);
            }
        } catch (FileNotFoundException e) {
            System.out.println("fileToString()方法：内容文件不存在");
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            System.out.println("fileToString()方法：读取过程出错");
            e.printStackTrace();
            return "";
        }

        return sb.toString();
    }


    public static void strSaveToFile(String context, String filePath) throws IOException {
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(context);
        fileWriter.close();
        fileWriter.close();
    }

}
