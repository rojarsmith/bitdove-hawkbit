/**
 * Copyright (c) 2022 Rojar Smith.
 */
package org.eclipse.hawkbit.ui.tenantconfiguration;

import org.eclipse.hawkbit.repository.TenantConfigurationManagement;
import org.eclipse.hawkbit.tenancy.configuration.TenantConfigurationProperties.TenantConfigurationKey;
import org.eclipse.hawkbit.ui.UiProperties;
import org.eclipse.hawkbit.ui.common.builder.FormComponentBuilder;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxySystemConfigUi;
import org.eclipse.hawkbit.ui.tenantconfiguration.ui.ShowConfigurationItem;
import org.eclipse.hawkbit.ui.utils.UIComponentIdProvider;
import org.eclipse.hawkbit.ui.utils.VaadinMessageSource;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Provides configuration of the UI.
 */
public class UiConfigurationView extends BaseConfigurationView<ProxySystemConfigUi> {

	private static final long serialVersionUID = 1L;

	private final VaadinMessageSource i18n;
	@SuppressWarnings("unused")
	private final UiProperties uiProperties;
	private final ShowConfigurationItem showConfigurationItem;

	UiConfigurationView(final VaadinMessageSource i18n, final UiProperties uiProperties,
			final TenantConfigurationManagement tenantConfigurationManagement) {
		super(tenantConfigurationManagement);
		this.i18n = i18n;
		this.uiProperties = uiProperties;
		this.showConfigurationItem = new ShowConfigurationItem(i18n);
	}

	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		init();
	}

	private void init() {
		final Panel rootPanel = new Panel();
		rootPanel.setSizeFull();
		rootPanel.addStyleName("config-panel");

		final VerticalLayout vLayout = new VerticalLayout();
		vLayout.setSpacing(false);
		vLayout.setMargin(true);
		vLayout.setSizeFull();

		final Label header = new Label(i18n.getMessage("configuration.ui.title"));
		header.addStyleName("config-panel-header");
		vLayout.addComponent(header);

		final GridLayout gridLayout = new GridLayout(3, 1);
		gridLayout.setSpacing(true);
		gridLayout.setColumnExpandRatio(1, 1.0F);
		gridLayout.setSizeFull();

		final CheckBox approvalCheckbox = FormComponentBuilder.createCheckBox(
				UIComponentIdProvider.UI_SHOW_ID_DEFAULT_ENABLED_CHECKBOX, getBinder(),
				ProxySystemConfigUi::isUiShowIdDefault, ProxySystemConfigUi::setUiShowIdDefault);

		gridLayout.addComponent(approvalCheckbox, 0, 0);
		gridLayout.addComponent(showConfigurationItem, 1, 0);

		vLayout.addComponent(gridLayout);
		rootPanel.setContent(vLayout);
		setCompositionRoot(rootPanel);
	}

	@Override
	protected ProxySystemConfigUi populateSystemConfig() {
		ProxySystemConfigUi configBean = new ProxySystemConfigUi();
		configBean.setUiShowIdDefault(readConfigOption(TenantConfigurationKey.UI_SHOW_ID_DEFAULT_ENABLED));
		return configBean;
	}

	@Override
	public void save() {
		writeConfigOption(TenantConfigurationKey.UI_SHOW_ID_DEFAULT_ENABLED, getBinderBean().isUiShowIdDefault());
	}

}
