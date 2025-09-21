class MovieRentingSystem {
    private Map<Integer, TreeSet<MovieEntry>> available;
    private TreeSet<MovieEntry> rented;
    private Map<String, Integer> priceMap;

    private static class MovieEntry implements Comparable<MovieEntry> {
        int shop, movie, price;

        MovieEntry(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        @Override
        public int compareTo(MovieEntry other) {
            if (this.price != other.price) return this.price - other.price;
            if (this.shop != other.shop) return this.shop - other.shop;
            return this.movie - other.movie;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MovieEntry)) return false;
            MovieEntry other = (MovieEntry) o;
            return this.shop == other.shop && this.movie == other.movie;
        }

        @Override
        public int hashCode() {
            return Objects.hash(shop, movie);
        }
    }

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>();
        priceMap = new HashMap<>();

        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            MovieEntry me = new MovieEntry(shop, movie, price);
            available.computeIfAbsent(movie, k -> new TreeSet<>()).add(me);
            priceMap.put(shop + "_" + movie, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;

        for (MovieEntry me : available.get(movie)) {
            result.add(me.shop);
            if (result.size() == 5) break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "_" + movie);
        MovieEntry me = new MovieEntry(shop, movie, price);
        available.get(movie).remove(me);
        rented.add(me);
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "_" + movie);
        MovieEntry me = new MovieEntry(shop, movie, price);
        rented.remove(me);
        available.computeIfAbsent(movie, k -> new TreeSet<>()).add(me);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        for (MovieEntry me : rented) {
            result.add(Arrays.asList(me.shop, me.movie));
            if (result.size() == 5) break;
        }
        return result;
    }
}