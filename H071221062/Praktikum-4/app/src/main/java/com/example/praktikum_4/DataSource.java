package com.example.praktikum_4;

import com.example.praktikum_4.R;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("sipalingmarvel","marvel"
                ,"Marvel > DC forever"
                , R.drawable.marvel,R.drawable.marvel));

        instagrams1.add(new Instagram("cptnAMRCA", "Captain America"
                ,"INFO LOKER BOSKUUUUU"
                ,R.drawable.captain1,R.drawable.captain1));

        instagrams1.add(new Instagram("manusiabesi", "Ironman"
                ,"I Love U 3000"
                ,R.drawable.ironman1, R.drawable.ironman1));

        instagrams1.add((new Instagram("butoijo","Hulk"
                ,"Tutorial diet dong kak, pengen kurus\uD83C\uDFC3\u200D\uD83D\uDC4A\uD83D\uDE34"
                ,R.drawable.hulk,R.drawable.hulk)));

        instagrams1.add(new Instagram("sidukun", "DR. Strange"
                ,"tidak ada kata menyerah walaupun 1 banding 1jt dari kesuksesan"
                ,R.drawable.dr,R.drawable.dr));

        instagrams1.add(new Instagram("palupalu","Thor"
                ,"sini kuretakkan kepala bapakkau pake palu"
                ,R.drawable.thor, R.drawable.thor));

        instagrams1.add(new Instagram("manusialabalaba","Spiderman"
                , "MJ I still love u until now"
                ,R.drawable.spiderman,R.drawable.spiderman));
        return instagrams1;
    }
}
