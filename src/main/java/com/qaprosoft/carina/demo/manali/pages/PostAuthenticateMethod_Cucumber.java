package com.qaprosoft.carina.demo.manali.pages;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostAuthenticateMethod_Cucumber extends AbstractApiMethodV2{

	public PostAuthenticateMethod_Cucumber() {
        super(null,"api/manali/bankccounts/cucumber/rs_postAuthencticate.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}

