package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    TaskListDao taskListDao;

    @Test
    public void testFindByListName(){
        //Given
        TaskList taskList = new TaskList("To Do", "Things you are going to do");
        taskListDao.save(taskList);
        //When
        List<TaskList> result = taskListDao.findByListName("To Do");
        //Then
        Assert.assertEquals(1, result.size());
        //CleanUp
        int id = result.get(0).getId();
        taskListDao.delete(id);
    }

}


