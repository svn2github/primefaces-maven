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
package org.primefaces.jsfplugin.digester;

import junit.framework.TestCase;

/**
 * Latest modification by $Author: cagatay_civici $
 * @version $Revision: 1279 $ $Date: 2008-04-20 13:06:50 +0100 (Sun, 20 Apr 2008) $
 */
public class AttributeTest extends TestCase{

	public void testGetShortTypeNameForPrimitiveType() {
		Attribute attribute = new Attribute();
		attribute.setType("boolean");
		assertEquals("boolean", attribute.getShortTypeName());
	}
	
	public void testGetShortTypeNameForNonPrimitiveType() {
		Attribute attribute = new Attribute();
		attribute.setType("java.lang.String");
		assertEquals("String", attribute.getShortTypeName());
	}
}
