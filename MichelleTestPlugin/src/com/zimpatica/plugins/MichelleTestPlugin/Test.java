package com.zimpatica.plugins.MichelleTestPlugin;

import com.appiancorp.suiteapi.common.Name;
import com.appiancorp.suiteapi.expression.annotations.Category;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import org.apache.log4j.Logger;

@Category("category.name.LogicalFunctions")
public class Test{
	private static final Logger LOG = Logger.getLogger(Test.class);
	
	@Function
	public static Boolean michelle(@Parameter @Name("name") String paramString) {
		return paramString.equals("michelle");
	}
}
