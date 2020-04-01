package com.tatadigital.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCustTxnMethod extends AbstractApiMethodV2 {

	public GetCustTxnMethod(String external_id) {
        super(null,null);
		
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));

}
}
