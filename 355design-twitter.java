import java.util.*;

class Twitter {
    private static int timestamp = 0;

    // Data structures to store tweets, followers, and user data
    private Map<Integer, List<Tweet>> userTweets; // User ID -> List of Tweets
    private Map<Integer, Set<Integer>> followers; // User ID -> Set of followers

    // Tweet class to store tweet information
    private class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        userTweets = new HashMap<>();
        followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));

        // Ensure the user follows themselves
        follow(userId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> feed = new ArrayList<>();
        if (followers.containsKey(userId)) {
            for (int followeeId : followers.get(userId)) {
                if (userTweets.containsKey(followeeId)) {
                    feed.addAll(userTweets.get(followeeId));
                }
            }
        }

        // Sort the tweets by time in descending order
        feed.sort((a, b) -> b.time - a.time);

        // Return the IDs of the top 10 tweets
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(10, feed.size()); i++) {
            result.add(feed.get(i).id);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId) && followerId != followeeId) {
            followers.get(followerId).remove(followeeId);
        }
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
