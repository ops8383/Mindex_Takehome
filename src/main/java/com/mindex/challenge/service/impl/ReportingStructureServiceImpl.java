package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;

import java.util.List;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService{

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating reporting structure for employee with id[{}]", id);
        Employee employee = employeeRepository.findByEmployeeId(id);
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(employee);
        reportingStructure.setNumberOfReports(findDirectReports(employee));
        return reportingStructure;
    }

    private int findDirectReports(Employee employee){
        if(employee.getDirectReports() == null){
            return 0;
        }
        List<Employee> employees = employee.getDirectReports();
        int numberOfReports = employees.size();
        for(Employee e : employees){
            numberOfReports += findDirectReports(employeeRepository.findByEmployeeId(e.getEmployeeId()));
        }
        return numberOfReports;
    }
    
}
