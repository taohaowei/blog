package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackUpDBUtil {

    private static String binDir = "mysqldump";
    private static String host = " -h localhost";
    private static String username = " -uroot";
    private static String password = " -pcdkj5@marker";
    private static String table = "blog_00";
    private static String dbTable = " " + table;

    private static String savePath = "/root/" + table + "-";

    public static String backup() {
        try {
            Runtime rt = Runtime.getRuntime();
            String backupFile = savePath + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".sql";
            StringBuilder command = new StringBuilder();
            command.append(binDir + host + username + password + dbTable);

            // 调用 调用mysql的安装目录的命令
            Process child = rt.exec(command.toString());
            // 设置导出编码为utf-8。这里必须是utf-8
            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

            InputStreamReader xx = new InputStreamReader(in, "utf-8");
            // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码

            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // 组合控制台输出信息字符串
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            // 要用来做导入用的sql目标文件：
            File file = new File(backupFile);
            if(!file.exists()){
                file.mkdirs();
                file.delete();
                file.createNewFile();
            }
            FileOutputStream fout = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
            writer.write(outStr);
            writer.flush();
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();

            return backupFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void load(String fPath) {
        try {
            Runtime rt = Runtime.getRuntime();

            // 调用 mysql 的 cmd:
            StringBuilder command = new StringBuilder();
            command.append(binDir + host + username + password);
            Process child = rt.exec(command.toString() + " --default-character-set=utf8 " + table);
            OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流      
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fPath), "utf-8"));
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
            writer.write(outStr);
            // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免      
            writer.flush();
            // 别忘记关闭输入输出流      
            out.close();
            br.close();
            writer.close();

            System.out.println("");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}