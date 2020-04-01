package com.tatadigital.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCustomerAdvSearchMethod extends AbstractApiMethodV2 {
    public GetCustomerAdvSearchMethod(String q) {
        super(null,null);
		
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}