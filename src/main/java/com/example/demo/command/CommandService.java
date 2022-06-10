package com.example.demo.command;

import java.util.List;

public interface CommandService {
    
    List<command> getAllCommands();
    void saveCommand(command command);
    command getCommandById(long id);
    void deleteCommandById(long id);
}
