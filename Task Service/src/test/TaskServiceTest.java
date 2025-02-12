package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import taskService.Task;
import taskService.TaskService;

public class TaskServiceTest {
	private TaskService taskService;
	
	@BeforeEach
    public void setUp() {
		taskService = new TaskService();
    }

	/**
	 * Tests For Adding Tasks
	 */
    @Test
    public void testAddTaskSuccessful() {
        Task task = new Task("1234567890", "John", "This is a description.");
        taskService.addTask(task);
        assertNotNull(taskService.getTask("1234567890"));
    }
    
    @Test
    public void testAddTaskDuplicateTask() {
        Task task = new Task("1234567890", "John", "This is a description.");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task));
    }

    /**
     * Tests For Deleting Tasks
     */
    @Test
    public void testDeleteTaskSuccessful() {
        Task task = new Task("1234567890", "John", "This is a description.");        
        taskService.addTask(task);
        taskService.deleteTask("1234567890");
        
        
        
        assertNull(taskService.getTask("1234567890"));
    }
    
    @Test
    public void testDeleteTaskDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("1234567890"));
    }

    /**
     * Tests For Updating Task Fields
     */
    @Test
    public void testUpdateTaskFieldSuccessfulName() {
        Task task = new Task("1234567890", "John", "This is a description.");
        taskService.addTask(task);
        taskService.updateTaskField("1234567890", "Name", "Johnny");
        assertEquals("Johnny", task.getName());
    }
      
    @Test
    public void testUpdateTaskFieldSuccessfulDescription() {
        Task task = new Task("1234567890", "John", "This is a description.");
        taskService.addTask(task);
        taskService.updateTaskField("1234567890", "Description", "This is an updated description.");
        assertEquals("This is an updated description.", task.getDescription());
    }
    
    @Test
    public void testUpdateTaskFieldInvalidField() {
        Task task = new Task("1234567890", "John", "This is a description.");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskField("1234567890", "FirstName", "Johnny") );
    }
    
    @Test
    public void testUpdateTaskFieldTaskDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskField("1234567890", "FirstName", "Johnny") );
    }
    

    

}