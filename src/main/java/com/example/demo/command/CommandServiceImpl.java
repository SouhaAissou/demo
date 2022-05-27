package com.example.demo.command;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements CommandService{

    @Autowired
    private CommandRepository commandRepository;
    
    @Override
    public List<comm> getAllCommands() {

        return commandRepository.findAll();
        
    }

    @Override
    public void saveCommand(comm command) {
        this.commandRepository.save(command);
        
    }

    @Override
    public comm getCommandById(long id) {
        Optional<comm> optionalCommand = commandRepository.findById(id);
        comm command = null;
        if(optionalCommand.isPresent()) {
            command = optionalCommand.get();
        }
        else{
            throw new RuntimeException("Command not found for id: " + id);
        }
        return command;
    }

    @Override
    public void deleteCommandById(long id) {
        this.commandRepository.deleteById(id);
        
    }
    
}
