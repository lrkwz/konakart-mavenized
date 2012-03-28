package com.konakartadmin.modules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.konakart.app.NameValue;
import com.konakartadmin.bl.AdminBaseMgr;

/**
 * Base class for sending payment information to the payment gateway
 * 
 */
public class AdminBasePayment extends AdminBaseMgr
{
    /** the log */
    private static Log log = LogFactory.getLog(AdminBasePayment.class);

    /**
     * Sends data to the payment gateway via a POST. Parameters are received from the
     * AdminPaymentDetails object.
     * 
     * @param pd
     * @return The response to the post
     * @throws IOException
     */
    public String postData(AdminPaymentDetails pd) throws IOException
    {
        URL url = new URL(pd.getRequestUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);

        if (pd.getReferrer() != null && pd.getReferrer().length() > 1)
        {
            connection.setRequestProperty("Referer", pd.getReferrer());
        }

        customizeConnection(connection);

        PrintWriter out = new PrintWriter(connection.getOutputStream());

        StringBuffer sb = getGatewayRequest(pd);

        if (log.isDebugEnabled())
        {
            log.debug("Post URL = " + pd.getRequestUrl() + "\n");
            log.debug("Post string = " + sb.toString() + "\n");

            for (Iterator<NameValue> iterator = pd.getParmList().iterator(); iterator.hasNext();)
            {
                NameValue nv = iterator.next();

                log.debug(nv.getName() + " = " + nv.getValue());
            }
        }

        // Send the message
        out.print(sb.toString());
        out.close();

        // Get back the response
        StringBuffer respSb = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = in.readLine();

        while (line != null)
        {
            respSb.append(line);
            line = in.readLine();
        }

        in.close();

        return respSb.toString();
    }

    /**
     * Sends data to the payment gateway via a GET. Parameters are received from the
     * AdminPaymentDetails object.
     * 
     * @param pd
     * @return The response to the post
     * @throws IOException
     */
    public String getData(AdminPaymentDetails pd) throws IOException
    {
        // Construct data for GET
        String urlStr = pd.getRequestUrl();
        StringBuffer sbRequest = getGatewayRequest(pd);

        if (log.isDebugEnabled())
        {
            log.debug("GET URL = " + urlStr + sbRequest.toString());
        }
        URL url = new URL(urlStr + sbRequest.toString());

        // Send data
        URLConnection conn = url.openConnection();

        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer sbReply = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null)
        {
            sbReply.append(line);
        }
        rd.close();
        String result = sbReply.toString();

        return result;
    }

    /**
     * This method can be specialized in the super class to customize the format of the request.
     * 
     * @param pd
     *            the PaymentDetails
     */
    protected StringBuffer getGatewayRequest(AdminPaymentDetails pd)
    {
        // Create the message from the parameters in the PaymentDetails object
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (Iterator<NameValue> iterator = pd.getParmList().iterator(); iterator.hasNext();)
        {
            NameValue nv = iterator.next();
            if (i > 0)
            {
                sb.append("&");
            }
            sb.append(nv.getName());
            sb.append("=");
            sb.append(nv.getValue());
            i++;
        }

        if (log.isDebugEnabled())
        {
            log.debug("GatewayRequest = \n" + sb);
        }

        return sb;
    }

    /**
     * This method is normally specialized in the super class to customize the connection
     * 
     * @param connection
     */
    protected void customizeConnection(HttpURLConnection connection)
    {
    }

    /**
     * 
     * Class used to pass around the payment details
     * 
     */
    public class AdminPaymentDetails
    {

        /** Contains the parameters that are sent to the payment gateway */
        List<NameValue> parmList;

        /** The URL used for the POST or GET */
        private String requestUrl;

        /** Determines whether we do a POST or GET */
        private String postOrGet;

        /** Holds the referrer - sometimes used to set on HTTP posts */
        private String referrer;

        /**
         * Constructor
         */
        public AdminPaymentDetails()
        {
        }

        /**
         * Returns a string containing the attributes of the AdminPaymentDetail object
         * 
         * @return A String representing the AdminPaymentDetails object
         */
        public String toString()
        {
            StringBuffer str = new StringBuffer();
            str.append("AdminPaymentDetail:\n");
            str.append("postOrGet       = ").append(getPostOrGet()).append("\n");
            str.append("referrer        = ").append(getReferrer()).append("\n");
            str.append("requestUrl      = ").append(getRequestUrl()).append("\n");
            if (parmList != null)
            {
                for (Iterator<NameValue> iterator = parmList.iterator(); iterator.hasNext();)
                {
                    NameValue nv = iterator.next();
                    str.append(nv.toString());
                }
            }
            return (str.toString());
        }

        /**
         * @return the parmList
         */
        public List<NameValue> getParmList()
        {
            return parmList;
        }

        /**
         * @param parmList
         *            the parmList to set
         */
        public void setParmList(List<NameValue> parmList)
        {
            this.parmList = parmList;
        }

        /**
         * @return the requestUrl
         */
        public String getRequestUrl()
        {
            return requestUrl;
        }

        /**
         * @param requestUrl
         *            the requestUrl to set
         */
        public void setRequestUrl(String requestUrl)
        {
            this.requestUrl = requestUrl;
        }

        /**
         * @return the postOrGet
         */
        public String getPostOrGet()
        {
            return postOrGet;
        }

        /**
         * @param postOrGet
         *            the postOrGet to set
         */
        public void setPostOrGet(String postOrGet)
        {
            this.postOrGet = postOrGet;
        }

        /**
         * @return the referrer
         */
        public String getReferrer()
        {
            return referrer;
        }

        /**
         * @param referrer
         *            the referrer to set
         */
        public void setReferrer(String referrer)
        {
            this.referrer = referrer;
        }

    }
}
