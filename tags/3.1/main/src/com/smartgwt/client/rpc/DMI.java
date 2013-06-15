package com.smartgwt.client.rpc;

/**
 * This class provides static methods to call server-side DMI methods exposed via a
 * {@link com.smartgwt.client.docs.ApplicationDeclaration} file.
 * <p><b>Note</b>:&nbsp; This class is only functional if you have Smart GWT Pro or above.</p>
 */
public class DMI {

	/**
	 * Static method to call a server-side DMI method exposed via a
	 * {@link com.smartgwt.client.docs.ApplicationDeclaration} file.
	 *
	 * @param appID Name of the {@link com.smartgwt.client.docs.ApplicationDeclaration} (.app.xml) file to look in
	 * @param className className (or ID) of the server object on which the method will be invoked
	 * @param methodName The name of the method to call on the serverObject
	 * @param callback Callback to execute when the DMI call completes
	 * @param arguments array of arguments to pass to the server side method
	 */
	public native static void call(String appID, String className, String methodName, RPCCallback callback, Object[] arguments) /*-{
		var jscallback = $entry(function (rpcResponse, data, rpcRequest) {
			    var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
                var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
                if(callback != null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
            });
        var jsParams = arguments == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;Z)(arguments, true);

        $wnd.isc.DMI.call({
        	appID:appID,
        	className:className,
        	methodName:methodName,
        	arguments:jsParams,
        	callback:jscallback
        });

	}-*/;

    /**
     * Static method to call a server-side DMI method exposed via a
     * {@link com.smartgwt.client.docs.ApplicationDeclaration} file.
     *
     * @param appID Name of the {@link com.smartgwt.client.docs.ApplicationDeclaration} (.app.xml) file to look in
     * @param className className (or ID) of the server object on which the method will be invoked
     * @param methodName The name of the method to call on the serverObject
     * @param callback Callback to execute when the DMI call completes
     * @param arguments array of arguments to pass to the server side method
     * @param requestParams Any additional properties that you want to set.  The properties
     * will be applied to the {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} generated
     * by this DMI call.
     */
    public native static void call(String appID, String className, String methodName,
            RPCCallback callback, Object[] arguments, RPCRequest requestParams) /*-{

        var jscallback = $entry(function (rpcResponse, data, rpcRequest) {
                var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
                var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
                if(callback != null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
            });
        var jsParams = arguments == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;Z)(arguments, true);
        var jsRequestParams = requestParams == null ? null : requestParams.@com.smartgwt.client.rpc.RPCRequest::getJsObj();

        $wnd.isc.DMI.call({
            appID: appID,
            className: className,
            methodName: methodName,
            arguments: jsParams,
            callback: jscallback,
            requestParams: jsRequestParams
        });
    }-*/;
}