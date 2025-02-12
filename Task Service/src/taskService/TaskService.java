package taskService;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	// declare a map variable to hold tasks
	private Map<String, Task> tasks;
	
	// initialize 
	public TaskService() {
		// Initialize HashMap to store tasks
		this.tasks = new HashMap<>();
	}
	
	// Method to add tasks
	public void addTask(Task task) {
		// check if task already exists
		if (tasks.containsKey(task.getTaskId())) {
			throw new IllegalArgumentException("Task with ID " + task.getTaskId() + " already exists.");
		}
		tasks.put(task.getTaskId(), task);
	}
	
	// method to delete contacts per Task ID
	public void deleteTask(String taskId) {
		// Check if contact exists before deletion
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task with ID" + taskId + " does not exist.");
		}
		tasks.remove(taskId);
	}
	
	// method to update task fields per contact ID
	public void updateTaskField(String taskId, String fieldName, String newFieldValue) {
    	
        Task task = tasks.get(taskId);
        
        // Check if task exists before updating
        if (task == null) {
        	throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
        
        // switch statement to update fields
        switch (fieldName) {
        	case "Name":
        		task.setName(newFieldValue);
        		break;
        	case "Description":
        		task.setDescription(newFieldValue);
        		break;
        	default:
        		throw new IllegalArgumentException("Invalid field name");
        }
    }
	
    // method to get a task per task ID
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}