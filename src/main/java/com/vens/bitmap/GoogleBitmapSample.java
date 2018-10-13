package com.vens.bitmap;

import org.roaringbitmap.RoaringBitmap;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/9/17
 */
public class GoogleBitmapSample {
    public static void main(String[] args) {
        RoaringBitmap rr = RoaringBitmap.bitmapOf(1,2,3,1000);
        RoaringBitmap rr2 = new RoaringBitmap();
        rr2.add(4000L,4255L);

        RoaringBitmap rror = RoaringBitmap.or(rr, rr2);
        rr.or(rr2);
        boolean equals = rror.equals(rr);
        if(!equals) throw new RuntimeException("bug");
        // number of values stored?
        long cardinality = rr.getLongCardinality();
        System.out.println(cardinality);
        // a "forEach" is faster than this loop, but a loop is possible:
        for(int i : rr) {
            System.out.println(i);
        }
    }
}
