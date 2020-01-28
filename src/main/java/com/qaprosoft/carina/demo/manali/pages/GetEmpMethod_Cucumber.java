package com.qaprosoft.carina.demo.manali.pages;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetEmpMethod_Cucumber extends AbstractApiMethodV2 {

	public GetEmpMethod_Cucumber() {
        super(null,null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
