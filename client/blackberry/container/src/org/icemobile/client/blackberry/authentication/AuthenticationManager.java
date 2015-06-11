package org.icemobile.client.blackberry.authentication;


import java.util.Hashtable;

import net.rim.device.api.ui.component.Dialog;

import org.icemobile.client.blackberry.ContainerController;
import org.icemobile.client.blackberry.Logger;

/**
 * AuthenticationManager acts as central location for dispatching different 
 * authentication schemes to different implementing strategies. 
 * 
 * For the moment, just add different Strategies by hand
 * 
 */
public class AuthenticationManager {

	// todo: implement a deeper level of authorization caching
	private Hashtable rootPathToRealmMap; 
	private Hashtable realmToAuthenticationMap; 
	
	private Hashtable mRealmEncodings;
	private Hashtable mAuthenticationStrategies; 
	
	public AuthenticationManager( ContainerController controller) { 
		mRealmEncodings = new Hashtable();
		UserAuthenticationDialogStrategy bad = new UserAuthenticationDialogStrategy("User Authorization"); 
		mAuthenticationStrategies = new Hashtable(); 
		mAuthenticationStrategies.put ("basic", bad);
	}	
	
	/**
	 * Execute the plan for authorization. 
	 */
	public String doAuthentication (String uri, String realm, String scheme) { 		
		
		String encoding = (String) mRealmEncodings.get( realm ); 
		if (encoding != null) { 
			return encoding; 
		} else { 
			
			final AuthenticationStrategy as = (AuthenticationStrategy) mAuthenticationStrategies.get(scheme); 
			if (as == null) { 
				Logger.DIALOG("No authorization implementation for scheme: \"" + scheme + "\"" );
				return null;
			}
			int result; 
			
			// Defer to the Strategy 
			as.doAuthorization(); 
			
			result = as.fetchResult();
			if (result == Dialog.CANCEL) { 
				return null; 
			}
			return as.getAuthorizationValue(  ); 
		}		
	}
	
	
	public void cacheSuccessfulAuthorization( String url, String realm, String auth) { 
		mRealmEncodings.put ( realm, auth );
	}
	
	public void clearAuthorizationCacheForRealm(String realm) { 
		mRealmEncodings.remove(realm); 
	}
	public void clearAuthorizationCache() { 
		mRealmEncodings.clear();
	}
}
