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

import java.util.Vector;

import org.apache.commons.lang.StringUtils;

/**
 * @author Latest modification by $Author: cagatay_civici $
 * @version $Revision: 1279 $ $Date: 2008-04-20 13:06:50 +0100 (Sun, 20 Apr 2008) $
 */
public class Component {

	private String tag;
	private String tagClass;
	private String componentClass;
	private String parent;
	private String componentType;
	private String componentFamily;
	private String rendererType;
	private String rendererClass;
	private Vector attributes;
	private Vector resources;
	private boolean ajaxComponent;
	
	public Component() {
		attributes = new Vector();
		resources = new Vector();
	}
	
	public void addAttribute(Attribute attribute) {
		attributes.add(attribute);
	}
	
	public void addResource(Resource resource) {
		resources.add(resource);
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getTagClass() {
		return tagClass;
	}
	public void setTagClass(String tagClass) {
		this.tagClass = tagClass;
	}
	
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public Vector getAttributes() {
		return attributes;
	}
	public void setAttributes(Vector attributes) {
		this.attributes = attributes;
	}
	
	public Vector getResources() {
		return resources;
	}
	public void setResources(Vector resources) {
		this.resources = resources;
	}
	
	public String getComponentType() {
		return componentType;
	}
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentFamily() {
		return componentFamily;
	}
	public void setComponentFamily(String componentFamily) {
		this.componentFamily = componentFamily;
	}

	public String getRendererType() {
		return rendererType;
	}
	public void setRendererType(String rendererType) {
		this.rendererType = rendererType;
	}
	
	public String getRendererClass() {
		return rendererClass;
	}
	public void setRendererClass(String rendererClass) {
		this.rendererClass = rendererClass;
	}

	public String getComponentClass() {
		return componentClass;
	}
	public void setComponentClass(String componentClass) {
		this.componentClass = componentClass;
	}
	
	public boolean isAjaxComponent() {
		return ajaxComponent;
	}
	public void setAjaxComponent(boolean ajaxComponent) {
		this.ajaxComponent = ajaxComponent;
	}

	
	/**
	 * Gives the short name of the component
	 * e.g. net.sf.yui4jsf.component.Slider will return Slider
	 */
	public String getComponentShortName() {
		String[] list = componentClass.split("\\.");
		return list[list.length-1];
	}
	
	/**
	 * Gives the short name of the parent
	 * e.g. javax.faces.component.UIComponentBase will return UIComponentBase
	 */
	public String getParentShortName() {
		String[] list = parent.split("\\.");
		return list[list.length-1];
	}
	
	/**
	 * Returns the parent package folder
	 * e.g. net.sf.yui4jsf.component.tabview.Tab will return "tabview"
	 */
	public String getParentPackagePath() {
		String[] list = getTagClass().split("\\.");
		return list[list.length-2];
	}
	
	/**
	 * Returns the parent package folder
	 * e.g. net.sf.yui4jsf.component.tabview.Tab will return "net.sf.yui4jsf.component.tabview"
	 */
	public String getPackage() {
		return StringUtils.substringBeforeLast(getTagClass(), ".");
	}
}