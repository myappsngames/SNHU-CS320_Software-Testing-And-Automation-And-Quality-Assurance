package taskService;

public class Task {

	// Private member variables
	private final String taskId;
	private String name;
	private String description;
		
	// Constructor with validations
	public Task(String taskId, String name, String description) {
		super();
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID: Task ID must not be null and cannot exceed 10 characters.");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid task name: Task name must not be null and cannot exceed 20 characters.");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid task description: Task description must not be null and cannot exceed 50 characters.");
		}

    this.taskId = taskId;
    this.name = name;
    this.description = description;
  }

	// Getter methods
	public String getTaskId() {
		return taskId;
	}
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	// Setters methods for name and description
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid task name: Task name must not be null and cannot exceed 20 characters.");
		}
		this.name = name;
	}

	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid task description: Task description must not be null and cannot exceed 50 characters.");
		}
		this.description = description;
  }
}