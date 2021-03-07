package Duke;

import java.util.ArrayList;
import java.util.List;
import Storage.Storage;

public class TaskList {
    private final Storage storage;
    private final List<Task> tasks;
    private int numOfTasks;

    public TaskList(Storage storage) {
        this.storage = storage;
        this.tasks = new ArrayList<>();
        ArrayList<String> storedData = this.storage.load();
        for (String s : storedData) {
            this.tasks.add(loadData(s));
        }
        this.numOfTasks = this.tasks.size();
    }

    private Task loadData(String data) {
        String[] dataArray = data.split("\\|");

        //System.out.println(dataArray.length + " " + dataArray[0] + dataArray[1]);

        Task task;

        if (dataArray[0].equals("T")) {
            task = new Todo(dataArray[2]);
        } else if (dataArray[0].equals("D")) {
            task = new Deadline(dataArray[2], dataArray[3]);
        } else {
            task = new Event(dataArray[2], dataArray[3]);
        }
        if (dataArray[1].contains("X")) {
            task.markDone();
        }

        return task;
    }

    public Task get(int taskNumber) {
        return this.tasks.get(taskNumber - 1);
    }

    public void add(Task task) {
        this.storage.add(task);
        this.tasks.add(task);
        this.numOfTasks = this.tasks.size();
    }
    public void remove(int index) {
        this.storage.remove(index);
        this.tasks.remove(index - 1);
        this.numOfTasks = this.tasks.size();
    }

    public void set(int index, Task task) {
        this.storage.set(index, task);
        this.tasks.set(index - 1, task);
    }

    public int getSize() {
        return this.numOfTasks;
    }

}
