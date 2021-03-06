package com.zimpatica.plugins.MichelleTestPlugin;

import com.appiancorp.suiteapi.common.Name;
import com.appiancorp.suiteapi.expression.annotations.Category;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import org.apache.log4j.Logger;

import com.appiancorp.suiteapi.type.TypeService;
import com.appiancorp.suiteapi.type.TypedValue;
import com.appiancorp.suiteapi.type.exceptions.InvalidTypeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

@Category("category.name.LogicalFunctions")
public class Test{
	private static final Logger LOG = Logger.getLogger(Test.class);
	
	@Function
	public static TypedValue michelle(TypeService ts, @Parameter @Name("field") String paramString, @Parameter @Name("dictionary") TypedValue dictionary, @Parameter @Name("value") String valueParam) {
		TypedValue t = new TypedValue();
		String[] emptyString = new String[0];
	    Long type = dictionary.getInstanceType();
	    Object value = dictionary.getValue();
	    String[] keys;
	    ArrayList<Integer> indices = new ArrayList<Integer>();
	    if ((type.longValue() == 57L) || (value == null) || ("".equals(value))) {
	      return null;
	    }
		if (type.longValue() == 194L) {
//			HashMap testmap = (HashMap)value;
//			return testmap.toString();
			ArrayList<HashMap<TypedValue, TypedValue>> a = new ArrayList(Arrays.asList((HashMap[])ts.cast(Long.valueOf(194L), dictionary).getValue()));
//			ArrayList<HashMap<TypedValue, TypedValue>> a = (ArrayList<HashMap<TypedValue,TypedValue>>)value;

			for(int i = 0; i < a.size(); i++) {
				 HashMap map = (HashMap)a.get(i);
				 HashMap<String,TypedValue> keyMap = new HashMap<String,TypedValue>();
				 ArrayList<String> keyStrings = new ArrayList<String>();
				 for(Object key : map.keySet()) {
					 TypedValue key_value = (TypedValue)key;
					 keyStrings.add(key_value.getValue().toString());
					 keyMap.put(key_value.getValue().toString(), key_value);
				 }
					 
				 if(keyStrings.contains(paramString)) {
					 TypedValue keyvalue = keyMap.get(paramString);
					 TypedValue mapValue = (TypedValue)map.get(keyvalue);
					 
					 if(mapValue.getValue().toString().equals(valueParam)) {
						 indices.add(i);
					 }
				 }

				 else {
					 return null;
				 }
			}
			if(indices.isEmpty()) {
				return null;
			}
			else {
				ArrayList<HashMap<TypedValue, TypedValue>> newMap = new ArrayList<HashMap<TypedValue,TypedValue>>();
				for(int z = 0; z<indices.size(); z++) {
					int index = indices.get(z);
					newMap.add(a.get(index));
				}

				return toDictionaryList(newMap);

			}
		}
		
		return null;
	}
	  public static TypedValue toDictionaryList(ArrayList<HashMap<TypedValue, TypedValue>> toCast) throws InvalidTypeException {
		    try {
		      return new TypedValue(Long.valueOf(194L), toCast.toArray(new HashMap[toCast.size()])); } catch (Exception e) {
		    }
		    throw new InvalidTypeException("Could not cast result to list of dictionary");
		  }
}
