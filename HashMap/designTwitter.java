package HashMap;
import java.util.*;

class PairTweet{
    int key, value;
    PairTweet(int k, int v){
        this.key = k;
        this.value = v;
    }
}
class ListNode{
    PairTweet val;
    ListNode next;
    ListNode(PairTweet val){
        this.val = val;
        this.next = null;
    }
}
class Twitter {

    ListNode tweets;
    HashMap<Integer, ArrayList<Integer>> followings;
    public Twitter() {
        followings = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(tweets == null)
            tweets = new ListNode(new PairTweet(userId, tweetId));
        else{
            ListNode newNode = new ListNode(new PairTweet(userId, tweetId));
            newNode.next = tweets;
            tweets = newNode;
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer> followList = followings.getOrDefault(userId, null);
        if(followList == null)
            followList = new ArrayList<Integer>();

        ListNode tweet = tweets;
        while(ans.size() != 10 && tweet != null){
            if(followList.contains(tweet.val.key) || userId == tweet.val.key)
                ans.add(tweet.val.value);
            tweet = tweet.next;
        } 
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        ArrayList<Integer> followList = followings.getOrDefault(followerId, null);
        if(followList == null)
            followings.put(followerId, new ArrayList<Integer>());
        followings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        ArrayList<Integer> followList = followings.getOrDefault(followerId, null);
        if(followList == null) return;

        for(int index = 0; index < followList.size(); index++){
            if(followList.get(index) == followeeId){
                followList.remove(index);
                break;
            }
        }
    }
}
public class designTwitter {
    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1, 2);
        t.postTweet(2, 6);
        System.out.println(t.getNewsFeed(1));
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1));

    }
}
