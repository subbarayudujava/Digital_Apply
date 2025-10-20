package com.nt.sevice;

import java.util.List;

import com.nt.entity.CustomerApplication;

public interface ApplicationService {

    CustomerApplication apply(CustomerApplication app);

    CustomerApplication processApplication(Long id, CustomerApplication updatedApp);

    List<CustomerApplication> fetchAllData();
}
