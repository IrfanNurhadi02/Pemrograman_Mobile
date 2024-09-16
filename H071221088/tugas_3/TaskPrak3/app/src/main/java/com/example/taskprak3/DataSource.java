package com.example.taskprak3;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("Nike", "Just Do It", R.drawable.logo1, R.drawable.postingan1, R.drawable.story1,"306M", "187"));
        instagrams1.add(new Instagram("Adidas", "Impossible Is Nothing", R.drawable.logo2, R.drawable.postingan2, R.drawable.story2, "29M", "720"));
        instagrams1.add(new Instagram("New Balance", "We Got Now", R.drawable.logo3, R.drawable.postingan3, R.drawable.story3, "7.7M", "499"));
        instagrams1.add(new Instagram("Puma", "FOREVER. FASTER.", R.drawable.logo4, R.drawable.postingan4, R.drawable.story4, "13M", "125"));
        instagrams1.add(new Instagram("RipnDip", "Must be nice", R.drawable.logo5, R.drawable.postingan5, R.drawable.story5, "1.4M", "740"));
        instagrams1.add(new Instagram("Bape", "A Bathing Ape", R.drawable.logo6, R.drawable.postingan6, R.drawable.story6, "5.3M", "18"));
        instagrams1.add(new Instagram("cdg", "Comme des Garçons", R.drawable.logo7, R.drawable.postingan7, R.drawable.story7, "141K", "9"));
        instagrams1.add(new Instagram("Dior", "Diyoh", R.drawable.logo8, R.drawable.postingan8, R.drawable.story8, "46.1M", "313"));
        instagrams1.add(new Instagram("vlone", "you live alone, you die alone", R.drawable.logo9, R.drawable.postingan9, R.drawable.story9, "1M", "4"));
        instagrams1.add(new Instagram("balenciaga", "Balencinaga?", R.drawable.logo10, R.drawable.postingan10, R.drawable.story10, "14.5M", "0"));
        return instagrams1;
    }

}
