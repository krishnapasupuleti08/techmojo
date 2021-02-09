package codingtest;

import java.util.List;

public interface TopTenHashTagInterface {

        void extractHashTagsFromTweet(String tweet);
        List<String> getTopTenHashtags();
}
