package com.qaprosoft.carina.demo.manali.pages;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostCreateEmpMethod_Cucumber extends AbstractApiMethodV2{

	public PostCreateEmpMethod_Cucumber() {
        super("api/manali/create_emp/postcreate_emp/rq.json","api/manali/create_emp/postcreate_emp/postrs.json","api/manali/create_emp/postcreate_emp/details.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }

	
}

