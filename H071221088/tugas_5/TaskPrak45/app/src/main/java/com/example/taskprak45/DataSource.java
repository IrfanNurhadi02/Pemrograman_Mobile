package com.example.taskprak45;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams =generateDummyInstagram();

    private static ArrayList<Instagram> generateDummyInstagram() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("Fauzan", "Fauzan Baihaqi", "Foto miror"
                ,R.drawable.profil1, R.drawable.post1));

        instagrams1.add(new Instagram("fatan", "Muhammad Fathan", "Foto nol koma lima"
                ,R.drawable.profil2, R.drawable.post2));

        instagrams1.add(new Instagram("Ramadan", "Saldang Rama", "Ala ala dikit"
                ,R.drawable.profil3, R.drawable.post3));

        instagrams1.add(new Instagram("Alqa", "Alqa Imoet", "Imut banget jancoeg"
                ,R.drawable.profil4, R.drawable.post4));

        instagrams1.add(new Instagram("Padel", "Muhammad Fadel", "Login bang"
                ,R.drawable.profil5, R.drawable.post5));

        return instagrams1;

    }

}
