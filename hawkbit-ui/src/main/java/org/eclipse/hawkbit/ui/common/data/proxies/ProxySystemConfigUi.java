/**
 * Copyright (c) 2022 Rojar Smith.
 */
package org.eclipse.hawkbit.ui.common.data.proxies;

/**
 * Proxy for the UI view of system config window
 */
public class ProxySystemConfigUi extends ProxySystemConfigWindow {
	private static final long serialVersionUID = 1L;

	private boolean uiShowIdDefault;

	/**
	 * Flag that indicates if the uiShowIdDefault option is enabled.
	 *
	 * @return <code>true</code> if the uiShowIdDefault is enabled, otherwise
	 *         <code>false</code>
	 */
	public boolean isUiShowIdDefault() {
		return uiShowIdDefault;
	}

	/**
	 * Sets the flag that indicates if the uiShowIdDefault option is enabled.
	 *
	 * @param uiShowIdDefault <code>true</code> if the uiShowIdDefault is enabled,
	 *                        otherwise <code>false</code>
	 */
	public void setUiShowIdDefault(final boolean uiShowIdDefault) {
		this.uiShowIdDefault = uiShowIdDefault;
	}
}
