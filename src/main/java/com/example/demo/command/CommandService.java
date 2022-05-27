package com.example.demo.command;

import java.util.List;





public interface CommandService {

	List<comm> getAllCommands();
	void saveCommand(comm command);
	comm getCommandById(long id);
	void deleteCommandById(long id);
}
