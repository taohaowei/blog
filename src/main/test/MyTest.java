import org.junit.Test;

/**
 * Created by Taohaowei on 2017/8/7.
 *
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他
 * 分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得
 * 最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 输入描述:
 第一行：n，表示h数组元素个数
 第二行：n个h数组元素
 第三行：m，表示w数组元素个数
 第四行：m个w数组元素

 输出描述:
 上台表演学生人数

 输入例子1:
 3
 2 2 3
 2
 3 1

 输出例子1:
 1
 */
public class MyTest {
    static String b = "54321123";
    static String a = "12345";
    static int blen = b.length();
    static int alen = a.length();
    @Test
    public void er()
    {

        int flag = 0;
        int baifen = 0;
        char ach[] = a.toCharArray();
        char bch[] = b.toCharArray();
        int[][] src = new int[alen][blen];
        int[] sum = new int[blen+alen];
        for(int i=0;i<alen;i++)
        {
            for(int j=0;j<blen;j++)
            {
                src[i][j] = toint(ach[i])*toint(bch[j]);
            }
        }
        for(int i=0;i<blen+alen-1;i++)
        {
            int itmp = 0;int jtmp = i;

            if(i>=blen)
            {
                itmp = i-blen+1;
                jtmp = blen-1;
            }

                while (true)
                {
                    sum[i] = sum[i] + src[itmp][jtmp];
                    if(!isAllowed(itmp,jtmp))break;
                    itmp++;
                    jtmp--;
                }
//                System.out.printf("%4d",src[i][j]);
//            System.out.println();
        }
        for (int i=0;i<blen+alen;i++)
            System.out.printf("%4d",sum[i]);

    }
    private boolean isAllowed(int i, int j)
    {
        if (i<alen-1&&j>0)
            return true;
        return false;
    }
    private int toint(char ch)
    {
        return ch-'0';
    }
}
