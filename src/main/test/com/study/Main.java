package com.study;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ai = new int[n];
        int sumA = 0, sumB =0;
        for(int i=0;i<n;i++)
        {
            ai[i] = sc.nextInt();
            sumA += ai[i];
        }
        int m = sc.nextInt();
        int[] bi = new int[m];
        for(int i=0;i<m;i++)
        {
            bi[i] = sc.nextInt();
            sumB += bi[i];
        }
        Arrays.sort(ai);
        Arrays.sort(bi);//对两个数组进行排序

        if(sumB>sumA)
            System.out.print(exchange(ai,bi,sumA,sumB));
        else
            System.out.print(exchange(bi,ai,sumB,sumA));
    }

    private static int exchange(int[] ai, int[] bi, int sumA, int sumB) {
        int deta = (sumB-sumA)%2==0?(sumB-sumA)/2:((sumB-sumA)/2+1);//得到差距值的一半
        if(deta==0||deta==1)return deta;
        Tmp min = new Tmp();
        for(int i=ai.length-1;i>=0;i--)
        {
            Tmp minTmp = new Tmp();
            for(int j=0;j<bi.length;j++)
            {
                if(bi[j]-ai[i]>0){
                    int src = bi[j]-ai[i];
                    minTmp = compare(minTmp,src,deta);
                }
            }
            min = compare(min,minTmp.chaju,deta);
        }
        deta -= min.chaju;//完成第一次交换

        //开始第二次交换
        min = new Tmp();
        for(int i=0;i<ai.length;i++)
        {
            Tmp minTmp = new Tmp();
            for(int j=0;j<bi.length;j++)
            {
                if(bi[j]-ai[i]>0){
                    int src = bi[j]-ai[i];
                    minTmp = compare(minTmp,src,deta);
                }
            }
            min = compare(min,minTmp.chaju,deta);
        }

        return 0;
    }

    private static Tmp compare(Tmp min, int src, int deta) {
        Tmp tmp = new Tmp();

        if(Math.abs(deta-min.chaju)>Math.abs(deta-src))//判断传入的数据，返回差值最接近的
        {
            tmp.chaju=Math.abs(deta-src);
            if((deta-src)<0)
                tmp.zhengfu=-1;
            return tmp;
        }else {
            return min;
        }
    }

    private static class Tmp {
        int zhengfu=1;
        int chaju=1000000000;
    }
}