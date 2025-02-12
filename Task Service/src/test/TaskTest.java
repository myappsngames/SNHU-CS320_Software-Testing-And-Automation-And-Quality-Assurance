package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import taskService.Task;

public class TaskTest {

	// Id Tests
	@Test
	public void testTaskIdSuccess() {
		assertDoesNotThrow( () -> new Task("1234567890", "Jon", "Short Description"));
	}
    @Test
    public void testTaskIdIsGreaterThan10() {
    	assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Jon", "Short Description") );
    }
    @Test
    public void testTaskIdIsNull() {
    	assertThrows(IllegalArgumentException.class, () -> new Task(null, "Jon", "Short Description") );
    }
    
    // Name Tests
    @Test
	public void testTaskNameSuccess() {
		assertDoesNotThrow( () -> new Task("1234567890", "Jon", "Short Description"));
	}
    @Test
    public void testTaskNameIsGreaterThan20() {
    	assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Johnathan Harringtonson", "Short Description") );
    }
    @Test
    public void testTaskNameIsNull() {
    	assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", null, "Short Description") );
    }
    
    // Description Tests
    @Test
	public void testTaskDescriptionSuccess() {
		assertDoesNotThrow( () -> new Task("1234567890", "Jon", "Short Description"));
	}
    @Test
    public void testTaskNameIsGreaterThan50() {
    	assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Jon", "This is a long Description that is greater than 50 characters. This description will cause an exception to be thrown.") );
    }
    @Test
    public void testTaskDescriptionIsNull() {
    	assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Jon", null) );
    }
    
    // Getters and Setters Test
    @Test
    public void testGettersAndSettersSuccess() {
    	String taskId = "1234567890";
    	String name = "John";
      	String description = "This is a short description";

      	Task task = new Task(taskId, name, description);

      	assertEquals(taskId, task.getTaskId());
      	assertEquals(name, task.getName());
      	assertEquals(description, task.getDescription());

      	String newName = "Johnny";
      	String newDescription = "This is a new short description";

      	task.setName(newName);
      	task.setDescription(newDescription);

      	assertEquals(newName, task.getName());
      	assertEquals(newDescription, task.getDescription());
    }
    
    @Test
    public void testTaskSetNameGreaterThan20() {
    	String taskId = "1234567890";
    	String name = "John";
      	String description = "This is a short description";

      	Task task = new Task(taskId, name, description);
      	
      	String newName = "Johnathan Harringtonson";
      	
      	assertThrows(IllegalArgumentException.class, () -> task.setName(newName));   	
    }
    
    @Test
    public void testTaskSetNameToNull() {
    	String taskId = "1234567890";
    	String name = "John";
      	String description = "This is a short description";

      	Task task = new Task(taskId, name, description);
      	
      	String newName = null;
      	
      	assertThrows(IllegalArgumentException.class, () -> task.setName(newName));
    }
    
    @Test
    public void testTaskSetDescriptionGreaterThan50() {
    	String taskId = "1234567890";
    	String name = "John";
      	String description = "This is a short description";

      	Task task = new Task(taskId, name, description);
      	
      	String newDescription = "This is a long Description that is greater than 50 characters. This description will cause an exception to be thrown.";
      	
      	assertThrows(IllegalArgumentException.class, () -> task.setDescription(newDescription));
    }
    
    @Test
    public void testTaskSetDescriptionToNull() {
    	String taskId = "1234567890";
    	String name = "John";
      	String description = "This is a short description";

      	Task task = new Task(taskId, name, description);
      	
      	String newDescription = null;
      	
      	assertThrows(IllegalArgumentException.class, () -> task.setDescription(newDescription));
    }
    
    

}