package io.skysail.server.app.prototypr.cucumber;

public interface AutomationApi {

	String getName();

	void addStepDefClass(Object applicationsStepDefs);

	Object getStepDef(Class<?> cls);
}
