import java.util.*;

class FoodRatings {
    // Maps food name to its Food object
    private Map<String, Food> foodMap = new HashMap<>();
    // Maps cuisine to a TreeSet of Foods sorted by rating desc, then name asc
    private Map<String, TreeSet<Food>> cuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);
            cuisineMap.computeIfAbsent(cuisines[i], k -> new TreeSet<>()).add(food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        Food food = foodMap.get(foodName);
        TreeSet<Food> set = cuisineMap.get(food.cuisine);
        set.remove(food); // Remove old version
        food.rating = newRating;
        set.add(food);    // Reinsert updated version
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }

    private static class Food implements Comparable<Food> {
        String name, cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food other) {
            if (this.rating != other.rating)
                return Integer.compare(other.rating, this.rating); // Descending rating
            return this.name.compareTo(other.name); // Lexicographical name
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Food && ((Food) o).name.equals(this.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */