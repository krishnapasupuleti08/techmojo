package codingtest;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        TopTenHashTagsImpl topTenHashtags = new TopTenHashTagsImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many tweets you wanna enter?: ");
        int totalTweetsCount = sc.nextInt();
        sc.nextLine();
        while(totalTweetsCount-->0){
            System.out.println("Tweet here:");
            String tweet = sc.nextLine();
            topTenHashtags.extractHashTagsFromTweet(tweet);
        }
        List<String> topTen = topTenHashtags.getTopTenHashtags();
        System.out.println("Top hashtags are: ");
        topTen.forEach(hashTag -> System.out.println("#"+hashTag));

    }
}
