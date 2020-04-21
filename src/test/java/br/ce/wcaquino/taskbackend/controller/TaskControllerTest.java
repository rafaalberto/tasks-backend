package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskRepo taskRepo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotSaveTaskNoDescription() {
        Task task = new Task();
        task.setDueDate(LocalDate.now());
        try {
            taskController.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskNoDate() {
        Task task = new Task();
        task.setTask("Task 1");
        try {
            taskController.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskWithPastDate() {
        Task task = new Task();
        task.setTask("Task 1");
        task.setDueDate(LocalDate.of(2010,1,1));
        try {
            taskController.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void shouldSaveTaskSuccessfully() throws ValidationException {
        Task task = new Task();
        task.setTask("Task 1");
        task.setDueDate(LocalDate.now());
        taskController.save(task);
        Mockito.verify(taskRepo).save(task);
    }

}
