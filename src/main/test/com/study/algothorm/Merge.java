package com.study.algothorm;

/**
 * Created by 14978 on 2017/8/25.
 */
public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi<=lo)return;

        int mid = (lo+hi)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        int i = lo,j=mid+1;
        for(int k=lo;k<=hi;k++)
            aux[k] = a[k];
        for(int k=lo;k<=hi;k++)
        {
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(i,j)) a[k]=aux[i++];
            else a[k]=aux[j++];
        }
    }

    private static boolean less(int i, int j) {

        return aux[i].compareTo(aux[j])>0;
    }

    public static void main(String[] args) {
        Integer[] i = new Integer[]{5,4,3,6,2,81,2,7,1,8,745,32,123};
        Merge.sort(i);
        for(int k=0;k<i.length;k++)
            System.out.print(i[k]+" ");
    }
}
