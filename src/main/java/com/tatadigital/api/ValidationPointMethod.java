package com.tatadigital.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class ValidationPointMethod extends AbstractApiMethodV2{
     
	public ValidationPointMethod(String points,String issue_otp,String mobile) {
		super(null, null);
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
       
	}


}
