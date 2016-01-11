package com.ibm.rtc.rtc.core;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.ibm.rtc.rtc.model.Workitem;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

/**
 * Created by v-wajie on 1/11/2016.
 */
public class WorkitemRequest extends JsonRequest<Workitem> {

    public WorkitemRequest(String url, Response.Listener<Workitem> listener,
                     Response.ErrorListener errorListener) {
        super(Method.GET, url, (String)null, listener, errorListener);
    }

    @Override
    protected Response<Workitem> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String json = new String(networkResponse.data,
                    HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"));
            Workitem workitem = Workitem.fromJSON(new JSONObject(json));
            return Response.success(workitem, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (ParseException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException e) {
            return Response.error(new ParseError(e));
        }
    }
}
