/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.grid.events;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
public class ChangeEvent extends AbstractSmartEvent<ChangeHandler>  {

    /**
     * Handler type.
     */
    private static Type<ChangeHandler> TYPE;

    /**
     * Fires a open event on all registered handlers in the handler manager.If no
     * such handlers exist, this method will do nothing.
     *
     * @param <S> The event source
     * @param source the source of the handlers
     * @param jsObj the native event
     */
    public static <S extends HasChangeHandlers & HasHandlers> void fire(
        S source, JavaScriptObject jsObj) {
        if (TYPE != null) {
            ChangeEvent event = new ChangeEvent(jsObj);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<ChangeHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<ChangeHandler>();
        }
        return TYPE;
    }


    @Override
    protected void dispatch(ChangeHandler handler) {
        handler.onChange(this);
    }

    // Because of type erasure, our static type is
    // wild carded, yet the "real" type should use our I param.

    @SuppressWarnings("unchecked")
    @Override
    public final Type<ChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public ChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }



    /**
     * the managing DynamicForm instance
     *
     * @return the managing DynamicForm instance
     */
    public  native DynamicForm getForm() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.form);
    }-*/;

    /**
     * the editor (form item) itself (also available as "this").                              Note that in addition to the standard FormItem APIs available&#010                              on the editor, it also has:<br>&#010                              - a pointer back to the containing listGrid &#010                              [<code>item.grid</code>]<br>&#010                              - the colNum being edited [<code>item.colNum</code>]<br>&#010                              - the rowNum being edited [<code>item.rowNum</code>]
     *
     * @return the editor (form item) itself (also available as "this").                              Note that in addition to the standard FormItem APIs available&#010                              on the editor, it also has:<br>&#010                              - a pointer back to the containing listGrid &#010                              [<code>item.grid</code>]<br>&#010                              - the colNum being edited [<code>item.colNum</code>]<br>&#010                              - the rowNum being edited [<code>item.rowNum</code>]
     */
    public  native FormItem getItem() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.item);
    }-*/;

    /**
     * The new value of the form item
     *
     * @return The new value of the form item
     */
    public  native Object getValue() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return $wnd.SmartGWT.convertToJavaType(jsObj.value);
    }-*/;

    /**
     * The previous value of the form item
     *
     * @return The previous value of the form item
     */
    public  native Object getOldValue() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return $wnd.SmartGWT.convertToJavaType(jsObj.oldValue);
    }-*/;




    /**
     * row number for the cell
     *
     * @return row number for the cell
     */
    public  native int getRowNum() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return jsObj.item.rowNum;
    }-*/;

    /**
     * column number of the cell
     *
     * @return column number of the cell
     */
    public  native int getColNum() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return jsObj.item.colNum;
    }-*/;


}
