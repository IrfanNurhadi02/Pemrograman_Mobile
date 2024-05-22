package com.example.praktikum3;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<UserData> users = generateDummyUsers();

    private static ArrayList<UserData> generateDummyUsers() {
        ArrayList<UserData> users = new ArrayList<>();
        users.add(new UserData(R.drawable.ironman, R.drawable.ff1, "IRONMAN", R.drawable.irnfeed, "halo dek, hari ini mau kemana?", 1000, 2000));
        users.add(new UserData(R.drawable.thor, R.drawable.ff2, "THOR", R.drawable.thorfeed, "MAU KU PALU PALA BAPAKKAU?", 3000, 4000));
        users.add(new UserData(R.drawable.captain, R.drawable.ff3, "CAPTAIN", R.drawable.captainfeed, "Jomblo, yang minat dm aja", 5000, 6000));
        users.add(new UserData(R.drawable.deadpool, R.drawable.ff4, "DEADPOOL", R.drawable.deadfeed, "Menerima job pelawak daerah sudiang", 7000, 8000));
        users.add(new UserData(R.drawable.spiderman, R.drawable.ff5, "SPIDERMAN", R.drawable.spiderfeed, "Saya sebenarnya 3 orang", 9000, 1000));
        users.add(new UserData(R.drawable.black, R.drawable.ff6, "BLACK WIDOW", R.drawable.blackfeed, "Nyesel banget ngorbanin diri buat suami orang", 2999, 1999));
        users.add(new UserData(R.drawable.loki, R.drawable.ff7, "LOKI", R.drawable.lokifeed, "Kadang baik kadang jahat", 2345, 5678));
        users.add(new UserData(R.drawable.hulk, R.drawable.f8, "HULK", R.drawable.hulkfeed, "Lagi mau diet, takut nanti dibilangin pas lebaran", 9999, 2222));
        users.add(new UserData(R.drawable.mantis, R.drawable.ff9, "MANTIS", R.drawable.mantisfeed, "Aku bisa baca pikiran kamu hehehe", 1234, 5432));
        users.add(new UserData(R.drawable.dr, R.drawable.ff10, "DR.STRANGE", R.drawable.drfeed, "1 banding 1juta kau mencintaikuuu", 2003, 2006));

        return users;
    }
}

