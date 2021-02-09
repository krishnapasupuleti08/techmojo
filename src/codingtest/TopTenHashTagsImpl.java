package codingtest;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopTenHashTagsImpl implements TopTenHashTagInterface{

    Map<String, Integer> hashTagCount;

    TopTenHashTagsImpl(){
        hashTagCount = new HashMap<>();
    }

    public void extractHashTagsFromTweet(String tweet){

        Matcher matcher = Pattern.compile("#([A-Za-z0-9]+)").matcher(tweet);

        while (matcher.find()){
            String hashTag = matcher.group(1);
            if(hashTagCount.containsKey(hashTag)){
                int increasedCount = hashTagCount.get(hashTag) + 1;
                hashTagCount.put(matcher.group(1),increasedCount );
            }
            else{
                hashTagCount.put(matcher.group(1),1);
            }
        }
    }
    public List<String> getTopTenHashtags(){
        Queue<String> topTen = new PriorityQueue<>(Comparator.comparingInt(a -> hashTagCount.get(a)));
        for(String hashTag: hashTagCount.keySet()){
            topTen.add(hashTag);
            if(topTen.size()>10)
                topTen.poll();
        }
        return new LinkedList<>(topTen);
    }
}
