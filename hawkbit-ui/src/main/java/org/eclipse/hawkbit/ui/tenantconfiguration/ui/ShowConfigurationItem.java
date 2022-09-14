/**
 * Copyright (c) 2022 Rojar Smith.
 */
package org.eclipse.hawkbit.ui.tenantconfiguration.ui;

import org.eclipse.hawkbit.ui.components.SPUIComponentProvider;
import org.eclipse.hawkbit.ui.utils.VaadinMessageSource;

import com.vaadin.ui.HorizontalLayout;

/**
 * This class represents the label item of UI.
 */
public class ShowConfigurationItem extends HorizontalLayout {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for tenant specific show setting.
	 *
	 * @param i18n used to translate labels
	 */
	public ShowConfigurationItem(final VaadinMessageSource i18n) {
		setSpacing(false);
		setMargin(false);
		addComponent(SPUIComponentProvider.generateLabel(i18n, "configuration.ui.show.label"));
	}

}
