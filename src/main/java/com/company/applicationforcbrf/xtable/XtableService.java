package com.company.applicationforcbrf.xtable;

import com.company.applicationforcbrf.service.ParserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XtableService {
    private final XtableRepository repository;
    private final ParserService parserService;

    public XtableService(XtableRepository repository, ParserService parserService) {
        this.repository = repository;
        this.parserService = parserService;
    }

    public void addToTable() {
        repository.saveAll(parserService.parseToXtableList());
    }

    public List<Xtable> getFromTable(){
        return repository.findAll();
    }

}
