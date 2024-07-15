/*
 * Copyright (C) 2024 Rojar Smith
 */
package org.eclipse.hawkbit.ui.common.data.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.eclipse.hawkbit.ui.UiProperties;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyIdentifiableEntity;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyTypeInfo;

import com.vaadin.data.provider.ListDataProvider;

public class LanguageMemoryDataProvider<T extends ProxyIdentifiableEntity> extends ListDataProvider<T> {
	private static final long serialVersionUID = 1L;

	public LanguageMemoryDataProvider(UiProperties uiProperties) {
		super(new ArrayList<>());
		List<Locale> locales = uiProperties.getLocalization().getAvailableLocals();
		ProxyTypeInfo selecteItem = new ProxyTypeInfo();
    	for(int i = 0; i < locales.size(); i++) {
    		String displayLanguage;
    		if(locales.get(i).toLanguageTag().equals("ja")) {
    			displayLanguage = "日本語";
    		}
    		else {
    			displayLanguage = "English";
    		}
    		ProxyTypeInfo item = new ProxyTypeInfo(
    				Long.valueOf(i),
    				displayLanguage,
    				locales.get(i).toLanguageTag());
    		getItems().add((T)item);
    	}
	}

	public T getSelected(Locale selectedLocale) {
		ProxyTypeInfo selecteItem = (ProxyTypeInfo) getItems().stream()
		.filter(item -> ((ProxyTypeInfo)item).getKey().equals(selectedLocale.getLanguage()))
		.findFirst().get();
		 
		 return (T) selecteItem;
	}
}
