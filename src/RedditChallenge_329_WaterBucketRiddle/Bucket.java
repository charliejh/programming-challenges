package RedditChallenge_329_WaterBucketRiddle;

public class Bucket {

    /** The buckets current amount of water */
    private int water = 0;
    /** The amount of water the bucket can hold */
    private int capacity;

    /**
     * Constructor
     */
    public Bucket(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Empties the bucket
     */
    public void empty() { water = 0; }

    /**
     * Fills the bucket to it's capacity
     */
    public void fill() { water = capacity; }

    /**
     * Transfers water from bucket a -> b
     * @param b Another bucket
     */
    public void transfer(Bucket b) {
        while (b.water < b.capacity && water > 0) {
            b.water++;
            water--;
        }
    }

    /**
     * Getters
     */
    public int getWater() { return water; }
    public int getCapacity() { return capacity; }

}
