package com.example.tugas3;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Instagram> instagrams = generateDummyInstagram();

    private static ArrayList<Instagram> generateDummyInstagram() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("katarinabluu", "Pacar Gue nih.", R.drawable.karina, R.drawable.karin, R.drawable.karinsg, "13.9M", "4", "5.987.765"));
        instagrams1.add(new Instagram("na.jaemin0813", "Halo aku jaemin.", R.drawable.jaemin, R.drawable.feedjae, R.drawable.jaeminsg, "14,3M", "0", "1.554.760"));
        instagrams1.add(new Instagram("imwinter", "si musim dingin.", R.drawable.winterprofile, R.drawable.winterfeed, R.drawable.wintersg, "8.6M", "4", "2.535.126"));
        instagrams1.add(new Instagram("imnotningning", "this is ningning yo.", R.drawable.ningprofile, R.drawable.ningfeed, R.drawable.ningsg, "6.7M", "4", "1.429.820"));
        instagrams1.add(new Instagram("aerichandesu", "just memory.", R.drawable.giselleprofile, R.drawable.gisellefeed, R.drawable.gisellesg, "10.9M", "5", "5.987.765"));
        instagrams1.add(new Instagram("eunwo.o_c", "wonderful world", R.drawable.eunwoprofile, R.drawable.eunwofeed, R.drawable.eunwosg, "44.1M", "6", "3.705.057"));
        return instagrams1;
    }
}
