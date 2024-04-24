package com.example.tugasprak4;

import android.net.Uri;
import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Post> posts = generatePosts();
    public static User user = new User("nana", "Na Jaemin", R.drawable.user);

    public static ArrayList<Post> generatePosts() {
        User eunwoo = new User("eunwoo", "Cha Eun Woo", R.drawable.profile);
        User taeyong = new User("tyongfs", "Taeyong", R.drawable.taeyong);
        User jaehyun = new User("peachzen", "Jaehyun", R.drawable.jaehyun);
        User haechan = new User("sunflower", "Haechan", R.drawable.haechan);
        User mark = new User("markzen", "Mark", R.drawable.mark);
        User jisung = new User("asteroid", "Jisung", R.drawable.jisung);
        ArrayList<Post> dump = new ArrayList<>();
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "eunwoo_post"), "Lee Dong-min ( Korea :  이동민 ; lahir 30 Maret 1997), dikenal secara profesional sebagai Cha Eun-woo ( 차은우 ), adalah penyanyi dan aktor Korea Selatan di bawah label Fantagio . Dia adalah anggota boy band Korea Selatan Astro .", eunwoo));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "taeyong_post"), "Taeyong adalah seorang rapper utama, penulis lagu, penari utama, koreografer, visual, produser, composer, model, editor, YouTuber, influencer, dan penyanyi asal Korea Selatan.", taeyong));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "jaehyun_post"), "His birth name is Jeong Jae Hyun, but he legalized to Jeong Yoon Oh (정윤오).", jaehyun));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "haechan_post"), "Selain jago bernyanyi, Haechan NCT ternyata banyak memiliki bakat yang sangat luar biasa, salah satunya adalah hafal puluhan koreografi dance dari berbagai genre boy group dan girl group.", haechan));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "mark_post"), "Mark Lee (born August 2, 1999), also professionally known as Mark, is a Canadian singer, rapper, dancer and songwriter based in South Korea.", mark));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "jisung_post"), "Hobi Jisung NCT adalah menari, rap, menyanyi, dan lain-lain. Sedangkan, karakter favoritnya di film Marvel adalah Iron Man.", jisung));
        return dump;
    }
}
