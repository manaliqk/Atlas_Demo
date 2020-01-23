package com.qaprosoft.carina.demo.manali.pages;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostAccountCreationMethod_Cucumber extends AbstractApiMethodV2{

	public PostAccountCreationMethod_Cucumber(String id_token) {
        super("api/manali/bankccounts/cucumber/rq_postAccount.json", "api/manali/bankccounts/cucumber/rs_postAccount.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
