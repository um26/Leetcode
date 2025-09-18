import java.util.*;

class TaskManager {
    private static class Task {
        int userId, taskId, priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        // Comparator: higher priority first, then higher taskId
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Task)) return false;
            Task task = (Task) o;
            return taskId == task.taskId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(taskId);
        }
    }

    private Map<Integer, Task> taskMap;
    private TreeSet<Task> taskSet;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        taskSet = new TreeSet<>((a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        taskSet.add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        taskSet.remove(oldTask);
        Task newTask = new Task(oldTask.userId, taskId, newPriority);
        taskMap.put(taskId, newTask);
        taskSet.add(newTask);
    }

    public void rmv(int taskId) {
        Task task = taskMap.remove(taskId);
        if (task != null) taskSet.remove(task);
    }

    public int execTop() {
        if (taskSet.isEmpty()) return -1;
        Task top = taskSet.pollFirst();
        taskMap.remove(top.taskId);
        return top.userId;
    }
}