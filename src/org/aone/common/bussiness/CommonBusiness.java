package org.aone.common.bussiness;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
/*import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.stereotype.Component;

/*import com.jaw.security.SecurityCheck;*/

@Component
public class CommonBusiness {
	/*@Autowired
	private SecurityCheck havilaSecurityCheck;
*/
	public void changeObject(Object destination, Object source) {

		try {
			BeanUtils.copyProperties(destination, source);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return;
	}


}
