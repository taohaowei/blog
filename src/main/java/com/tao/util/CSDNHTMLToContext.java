package com.tao.util;

import java.io.*;

/**
 * Created by Taohaowei on 2017/8/2.
 */
public class CSDNHTMLToContext {



    public static void delCodeBarAndFoot() throws Exception {
        File file = new File("C:\\tmp\\csdnContext.html");
        StringBuffer sb = new StringBuffer();
        String src = "";
        BufferedReader br = new BufferedReader(new FileReader(file));
        //从数据流重先读取除字段。
        while((src=br.readLine())!=null)
            sb.append(src);
        br.close();
        //除掉代码头和尾部
        String head = "<div class=\"bar\" style=\"padding-left:45px\"><div class=\"to";
        String foot = "代码片\" style=\"border:none; position:relative; top:2px; left:2px\"></a></span></div></div>";
        String replaceString  = "";
        while (sb.indexOf(head)!=-1) {
//            sb.replace(0,20,"");
            sb.replace(sb.indexOf(head),sb.indexOf(foot)+foot.length(),replaceString);
        }
        String context = sb.toString();
//        context = context.replaceAll("<div class=\"bar\" style=\"padding-left:45px\"><div class=\"tools\" style=\"padding:3px 8px 10px 10px; font-size:9px; line-height:normal; font-family:Verdana,Geneva,Arial,Helvetica,sans-serif; color:silver; border-left-width:3px; border-left-style:solid; border-left-color:rgb(108,226,108); background-color:rgb(248,248,248)\"><strong>[plain]</strong>&nbsp;<a target=\"_blank\" href=\"http://blog.csdn.net/wlwlwlwl015/article/details/18047169#\" class=\"ViewSource\" title=\"view plain\" style=\"text-decoration:none; border:none; padding:1px; margin:0px 10px 0px 0px; font-size:9px; color:rgb(12,137,207); display:inline-block; width:16px; height:16px; text-indent:-2000px; background-color:inherit\">view plain</a><span>&nbsp;<a target=\"_blank\" href=\"http://blog.csdn.net/wlwlwlwl015/article/details/18047169#\" class=\"CopyToClipboard\" title=\"copy\" style=\"text-decoration:none; border:none; padding:1px; margin:0px 10px 0px 0px; font-size:9px; color:rgb(12,137,207); display:inline-block; width:16px; height:16px; text-indent:-2000px; background-color:inherit\">copy</a><div style=\"position: absolute; left: 670px; top: 1494px; width: 19px; height: 19px; z-index: 99;\"><embed id=\"ZeroClipboardMovie_3\" src=\"http://static.blog.csdn.net/scripts/ZeroClipboard/ZeroClipboard.swf\" loop=\"false\" menu=\"false\" quality=\"best\" bgcolor=\"#ffffff\" width=\"19\" height=\"19\" name=\"ZeroClipboardMovie_3\" align=\"middle\" allowscriptaccess=\"always\" allowfullscreen=\"false\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" flashvars=\"id=3&amp;width=19&amp;height=19\" wmode=\"transparent\"></div></span><div style=\"position:absolute; left:508px; top:1856px; width:18px; height:18px; z-index:99\"></div><span>&nbsp;</span><span class=\"tracking-ad\"><a target=\"_blank\" href=\"https://code.csdn.net/snippets/152175\" title=\"在CODE上查看代码片\" style=\"text-decoration:none; border:none; padding:1px; margin:0px 10px 0px 0px; font-size:9px; color:rgb(12,137,207); display:inline-block; width:16px; height:16px; background-color:inherit\"><img src=\"https://code.csdn.net/assets/CODE_ico.png\" width=\"12\" height=\"12\" alt=\"在CODE上查看代码片\" style=\"border:none; position:relative; top:1px; left:2px\"></a></span><span class=\"tracking-ad\"><a target=\"_blank\" href=\"https://code.csdn.net/snippets/152175/fork\" title=\"派生到我的代码片\" style=\"text-decoration:none; border:none; padding:1px; margin:0px 10px 0px 0px; font-size:9px; color:rgb(12,137,207); display:inline-block; width:16px; height:16px; background-color:inherit\"><img src=\"https://code.csdn.net/assets/ico_fork.svg\" width=\"12\" height=\"12\" alt=\"派生到我的代码片\" style=\"border:none; position:relative; top:2px; left:2px\"></a></span></div></div>div>","");
        context = context.replaceAll("<div class=\"save_code tracking-ad\" data-mod=\"popu_249\"><a href=\"javascript:;\" target=\"_blank\"><img src=\"http://static.blog.csdn.net/images/save_snippets.png\"></a></div>","");
        file.delete();
        file.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(context,0,context.length());
        bw.close();
    }

    public static void main(String[] args) {
        try {
            delCodeBarAndFoot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
