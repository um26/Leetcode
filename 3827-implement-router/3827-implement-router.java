import java.util.*;

class Router {
    private static class Packet {
        int source, destination, timestamp;

        Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Packet)) return false;
            Packet p = (Packet) o;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    private final int memoryLimit;
    private final Queue<Packet> queue;
    private final Set<Packet> packetSet;
    private final Map<Integer, List<Integer>> destinationMap;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destinationMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if (packetSet.contains(packet)) return false;

        if (queue.size() == memoryLimit) {
            Packet removed = queue.poll();
            packetSet.remove(removed);
            List<Integer> timestamps = destinationMap.get(removed.destination);
            timestamps.remove(0); // remove oldest timestamp
        }

        queue.offer(packet);
        packetSet.add(packet);
        destinationMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];
        Packet packet = queue.poll();
        packetSet.remove(packet);
        List<Integer> timestamps = destinationMap.get(packet.destination);
        timestamps.remove(0);
        return new int[]{packet.source, packet.destination, packet.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> timestamps = destinationMap.getOrDefault(destination, new ArrayList<>());
        int left = lowerBound(timestamps, startTime);
        int right = upperBound(timestamps, endTime);
        return right - left;
    }

    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}