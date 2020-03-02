package co.grandcircus.tasklist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.tasklist.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
	
	List<Task> findByDescriptionContainingIgnoreCase(String description);

}
