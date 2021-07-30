package com.arteriatech.emami.common;

import android.text.TextUtils;

import com.sap.mobile.lib.parser.IODataEntry;
import com.sap.mobile.lib.parser.IODataSchema;
import com.sap.mobile.lib.parser.Parser;
import com.sap.mobile.lib.parser.ParserException;
import com.sap.mobile.lib.request.BaseRequest;
import com.sap.mobile.lib.request.INetListener;
import com.sap.mobile.lib.request.IRequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {
    private static RequestBuilder instance = null;
    //	private Boolean mIsMAFLogon;
    private String mSMPAppConnectionID;
    private String mEndPoint = "";
    //	private Boolean mIsJSONFormat;
    private Parser mParser;
    private IODataSchema mSchema;
//	private IODataServiceDocument mServiceDoc;

    private static final String APP_CONNECTION_ID_HEADER = "X-SUP-APPCID";
    private static final String ODATA_METADATA_COMMAND = "$metadata";
    private static final String ODATA_JSON_FORMAT = "$format=json";
    private static final String ATOM_CONTENT_TYPE = "application/atom+xml";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final String HTTP_CONTENT_TYPE = "content-type";
    private static final String ODATA_TOP_FILTER = "$top=";
    private static final String ODATA_FILTER = "$filter=";

    protected RequestBuilder() {
        // Exists only to defeat instantiation.
    }

    /**
     * @return RequestBuilder
     */
    public static RequestBuilder getInstance() {
        if (instance == null) {
            instance = new RequestBuilder();
        }
        return instance;
    }


    public void initialize(IODataSchema schema, Parser parser, String smpAppConnectionID, String endPointURL) {
//		this.mIsMAFLogon = isMAFLogon;
        this.mSMPAppConnectionID = smpAppConnectionID;
        this.mEndPoint = endPointURL;
//		this.mIsJSONFormat = isJSONFormat;
        this.mParser = parser;
        this.mSchema = schema;
    }


    /**
     * @param schema
     */
    public void setSchema(IODataSchema schema) {
        this.mSchema = schema;
    }


    public IRequest buildGETRequest(INetListener listener, String collection, int priority) {
        return buildGETRequest(listener, collection, -1, null, priority);
    }

    /**
     * @param listener
     * @param collection
     * @param topFilter
     * @return
     */
    public IRequest buildGETRequest(INetListener listener, String collection, int topFilter, int priority) {
        return buildGETRequest(listener, collection, topFilter, "", priority);
    }

    /**
     * @param listener
     * @param collection
     * @param topFilter
     * @param filter
     * @return
     */
    public IRequest buildGETRequest(INetListener listener, String collection, int topFilter, String filter, int priority) {
        String query = "";
        if (topFilter > 0) query = ODATA_TOP_FILTER + topFilter;

        if (!TextUtils.isEmpty(filter)) {
            if (!TextUtils.isEmpty(query)) query += "&";
            query += ODATA_FILTER + filter;
        }

        IRequest request = new BaseRequest();
        request.setListener(listener);
        request.setPriority(priority);
        request.setRequestMethod(IRequest.REQUEST_METHOD_GET);
        String endPointURL = mEndPoint + collection;
        if (!TextUtils.isEmpty(query)) {
            if (endPointURL.contains("?")) {
                endPointURL = endPointURL + "&" + query;
                System.out.println("endPointURL1" + endPointURL);
            } else {
                endPointURL = endPointURL + "?" + query;
                System.out.println("endPointURL2" + endPointURL);
            }

        }
        request.setRequestUrl(endPointURL);


        return request;
    }

    /**
     * @param listener
     * @param requestTag
     * @return
     */
    public IRequest buildServiceDocumentRequest(INetListener listener, String requestTag) {
        IRequest request = new BaseRequest();
        request.setListener(listener);
        request.setPriority(IRequest.PRIORITY_HIGH);
        request.setRequestMethod(IRequest.REQUEST_METHOD_GET);
        request.setRequestTAG(requestTag);
        request.setRequestUrl(mEndPoint);

//		if (mIsMAFLogon) {
//			Map<String,String> headers = new HashMap<String,String>();		
//			headers.put(APP_CONNECTION_ID_HEADER, mSMPAppConnectionID);
//			request.setHeaders(headers);
//		}

        return request;
    }

    /**
     * @param listener
     * @param requestTag
     * @return
     */
    public IRequest buildMetaDataRequest(INetListener listener, String requestTag) {
        IRequest request = new BaseRequest();
        request.setListener(listener);
        request.setPriority(IRequest.PRIORITY_HIGH);
        request.setRequestMethod(IRequest.REQUEST_METHOD_GET);
        request.setRequestUrl(mEndPoint + ODATA_METADATA_COMMAND);
        request.setRequestTAG(requestTag);
//		if (mIsMAFLogon) {
//			Map<String,String> headers = new HashMap<String,String>();		
//			headers.put(APP_CONNECTION_ID_HEADER, mSMPAppConnectionID);
//			request.setHeaders(headers);
//		}

        return request;
    }

    /**
     * @param listener
     * @param collection
     * @param entry
     * @param requestTag
     * @return
     * @throws ParserException
     */
    public IRequest buildPOSTRequest(INetListener listener, String collection, IODataEntry entry, String requestTag) throws ParserException {

        int formatType = Parser.FORMAT_XML;
//		if (mIsJSONFormat) {
//			formatType = Parser.FORMAT_JSON;
//		}
        String postData = mParser.buildODataEntryRequestBody(entry, collection, mSchema, formatType);

        IRequest request = new BaseRequest();
        request.setListener(listener);
        request.setPriority(IRequest.PRIORITY_HIGH);
        request.setRequestMethod(IRequest.REQUEST_METHOD_POST);
        request.setRequestTAG(requestTag);
        String endPointURL = mEndPoint + collection;
        request.setRequestUrl(endPointURL);

        Map<String, String> headers = new HashMap<String, String>();
//		if (mIsJSONFormat) {
//			headers.put(HTTP_CONTENT_TYPE, JSON_CONTENT_TYPE);
//		} else {
        headers.put(HTTP_CONTENT_TYPE, ATOM_CONTENT_TYPE);
//		}		

//		if (mIsMAFLogon) {	
//			headers.put(APP_CONNECTION_ID_HEADER, mSMPAppConnectionID);
//		}
        request.setHeaders(headers);

        request.setData(postData.getBytes());

        return request;
    }

    /**
     * @param listener
     * @param whiteListedAlias
     * @param requestTag
     * @return
     * @throws MalformedURLException
     */
    public IRequest buildGETRequestForWhiteListedURL(INetListener listener, String whiteListedAlias, String requestTag) throws MalformedURLException {
        IRequest request = new BaseRequest();
        request.setListener(listener);
        request.setPriority(IRequest.PRIORITY_HIGH);
        request.setRequestMethod(IRequest.REQUEST_METHOD_GET);

        URL url = new URL(mEndPoint);
        String whiteListedEndPoint = "http://" + url.getHost() + ":" + url.getPort() + whiteListedAlias;

        request.setRequestUrl(whiteListedEndPoint);

//		if (mIsMAFLogon) {
//			Map<String,String> headers = new HashMap<String,String>();		
//			headers.put(APP_CONNECTION_ID_HEADER, mSMPAppConnectionID);
//			request.setHeaders(headers);
//		}
        request.setRequestTAG(requestTag);


        return request;
    }

}
