/*
 * Copyright 2007 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prime.yui4jsf.jsfplugin.digester;

import junit.framework.TestCase;

/**
 * Latest modification by $Author: cagatay_civici $
 * @version $Revision: 1279 $ $Date: 2008-04-20 13:06:50 +0100 (Sun, 20 Apr 2008) $
 */
public class ComponentTest extends TestCase {

	public void testGetShortName() {
		Component component = new Component();
		component.setComponentClass("net.sf.yui4jsf.component.Slider");
		assertEquals("Slider", component.getComponentShortName());
	}
	
	public void testGetParentShortName() {
		Component component = new Component();
		component.setParent("javax.faces.component.UIComponentBase");
		assertEquals("UIComponentBase", component.getParentShortName());
	}
	
	public void testGetParentPackagePath() {
		Component component = new Component();
		component.setTagClass("net.sf.yui4jsf.component.tabview.Tab");
		assertEquals("tabview", component.getParentPackagePath());
	}
	
	public void testGetPackage() {
		Component component = new Component();
		component.setTagClass("net.sf.yui4jsf.component.tabview.Tab");
		assertEquals("net.sf.yui4jsf.component.tabview", component.getPackage());
	}
}
